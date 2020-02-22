package com.avinash.CamundaDemo.listners;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import com.avinash.CamundaDemo.util.LoggerUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoggerListner implements ExecutionListener{

	private static final Logger log=LoggerFactory.getLogger(LoggerListner.class);
	
	@Override
	public void notify(DelegateExecution execution) throws Exception {
		
		if(execution.getEventName().equalsIgnoreCase("start")) {
			
			log.info("Processing Task <{}> - <{}>",execution.getProcessInstanceId()+"_"+execution.getCurrentActivityName(),execution.getCurrentActivityName());
		}
		
		if(execution.getEventName().equalsIgnoreCase("end")) {
			
			int statusCode = Integer.parseInt((String) execution.getVariableLocal("statusCode"));
			String resposne=(String) execution.getVariableLocal("response");
			log.info("Task<{}> processing completed with CLOSED- statusCode: <{}>, statusMessage:<{}>, output: <{}>", 
					execution.getProcessInstanceId()+"_"+execution.getCurrentActivityName(),
					HttpStatus.valueOf(statusCode).value(),
					HttpStatus.valueOf(statusCode).getReasonPhrase(),
					resposne instanceof String ? resposne : new ObjectMapper().writeValueAsString(resposne));
		}		
		
	}

}
