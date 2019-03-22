package com.lesson.alibaba.sentinel.quickstart;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
public class SentinelQuickstartBootstrapTest {

	private static void initFlowRules(){
		List<FlowRule> rules = new ArrayList<>();
		FlowRule rule = new FlowRule();
		rule.setResource("HelloWorld");
		rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
		// Set limit QPS to 20.
		rule.setCount(5);
		rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_RATE_LIMITER);
		rules.add(rule);
		rule.setMaxQueueingTimeMs(20);
		FlowRuleManager.loadRules(rules);
	}

	@Test
	public void test1() throws InterruptedException {

		// System.setProperty("csp.sentinel.dashboard.server","127.0.0.1:8080");
		// 配置规则.
		initFlowRules();
		SphO sphO;

		while (true) {
			try (Entry entry = SphU.entry("HelloWorld")) {

				// 被保护的逻辑
				log.info("hello world");

				entry.exit();
			} catch (Exception ex) {
				// 处理被流控的逻辑
				ex.printStackTrace();

			}
		}

	}

	@SentinelResource("HelloWorld")
	public void helloWorld() {
		// 资源中的逻辑
		log.info("hello world");
	}




	public void initDegradeRule(){
		List<DegradeRule> degradeRules = new ArrayList<>();
		DegradeRule degradeRule = new DegradeRule();
		degradeRule.setResource("1212");
		degradeRule.setCount(10);
		degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_RT);
		degradeRule.setTimeWindow(20);
		degradeRules.add(degradeRule);
		DegradeRuleManager.loadRules(degradeRules);
	}

	@Test
	public void test2() throws InterruptedException {
		initDegradeRule();
		IntStream.range(0,10).forEach(value -> {
			new Thread(()->{
				Entry entry = null;

				try {
					initDegradeRule();
					entry = SphU.entry("1212");


					Thread.sleep(1000);
				} catch (Throwable t) {
					t.printStackTrace();
					if (!BlockException.isBlockException(t)) {
						//Tracer.trace(t);
					}
				} finally {
					if (entry != null) {
						entry.exit();
					}
				}
			}).start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(value);
		});


		Thread.currentThread().join();

	}

}