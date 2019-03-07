package com.lesson.alibaba.sentinel.quickstart;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
		// 配置规则.
		initFlowRules();
		while (true) {
			Entry entry = null;
			try {
				entry = SphU.entry("HelloWorld");
				// 资源中的逻辑.
				System.out.println("hello world");

			} catch (BlockException e1) {
				System.out.println("blocked!");
			} finally {
				if (entry != null) {
					entry.exit();
				}
			}
		}

	}

	@SentinelResource("HelloWorld")
	public void helloWorld() {
		// 资源中的逻辑
		System.out.println("hello world");
	}

}