package com.avinash.CamundaDemo;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ConnectionEsb implements ExecutionListener {
	@Value("${backend.baseUrl}")
	String backendvalue;
	

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		if(execution.getEventName().equalsIgnoreCase("start")) {
			execution.setVariable("urlid", backendvalue);
		}
		
		
	}

}
