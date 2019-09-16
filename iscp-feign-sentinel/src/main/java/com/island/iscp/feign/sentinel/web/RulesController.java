package com.island.iscp.feign.sentinel.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;

@RestController
@RequestMapping("/rule")
public class RulesController {

	@GetMapping("/degrade")
	public List<DegradeRule> apiDegrade() {
		return DegradeRuleManager.getRules();
	}

}
