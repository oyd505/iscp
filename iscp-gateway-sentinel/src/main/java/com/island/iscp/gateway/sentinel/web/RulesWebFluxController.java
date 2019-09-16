package com.island.iscp.gateway.sentinel.web;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiDefinition;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.GatewayApiDefinitionManager;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rule")
public class RulesWebFluxController {

	@GetMapping("/api")
	public Mono<Set<ApiDefinition>> apiRules() {
		return Mono.just(GatewayApiDefinitionManager.getApiDefinitions());
	}

	@GetMapping("/gateway")
	public Mono<Set<GatewayFlowRule>> apiGateway() {
		return Mono.just(GatewayRuleManager.getRules());
	}

	@GetMapping("/flow")
	public Mono<List<FlowRule>> apiFlow() {
		return Mono.just(FlowRuleManager.getRules());
	}

}
