package com.lesson.alibaba.sentinel.quickstart;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SentinelQuickstartBootstrapTest {

	private static void initFlowRules(){
		List<FlowRule> rules = new ArrayList<>();
		FlowRule rule = new FlowRule();
		rule.setResource("HelloWorld");
		rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
		// Set limit QPS to 20.
		rule.setCount(20);
		rules.add(rule);
		FlowRuleManager.loadRules(rules);
	}

	@Test
	public void test1() {

		System.setProperty("csp.sentinel.dashboard.server","127.0.0.1:8080");
		// 配置规则.
		initFlowRules();
		SphO sphO;
		while (true) {
			// 1.5.0 版本开始可以直接利用 try-with-resources 特性
			try (Entry entry = SphU.entry("HelloWorld")) {

				// 被保护的逻辑
				log.info("hello world");
			} catch (BlockException ex) {
				// 处理被流控的逻辑
				log.info("blocked!");
			}
		}

	}

	@SentinelResource("HelloWorld")
	public void helloWorld() {
		// 资源中的逻辑
		log.info("hello world");
	}

}