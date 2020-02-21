package com.avinash.CamundaDemo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.PathParam;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamundaController {
	
	@Autowired
	private RuntimeService runtimeService;
	
	@PostMapping("/process-definition/key/{processDefinationKey}/start")
	//@RequestMapping(value="test", method =RequestMethod.POST )
	public Object startProcess(@PathVariable String processDefinationKey,@RequestBody Object requestJson) {
		
		Map<String,Object> variables=new HashMap<String, Object>();
		
		variables.put("DppData",requestJson);
		
		ProcessInstance processInstance=runtimeService.startProcessInstanceByKey(processDefinationKey, variables);
		
		String finalResponse=(String) runtimeService.getVariable(processInstance.getId(), "finalResponse");
		
		//runtimeService.signalEventReceived("exit", processInstance.getId());
		
		return finalResponse;
	}
	
	@GetMapping("/test")
	public String test() {
		
		return "Siva Rayapureddy";
	}

}
