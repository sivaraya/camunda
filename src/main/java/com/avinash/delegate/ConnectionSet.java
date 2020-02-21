package com.avinash.delegate;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConnectionSet implements ExecutionListener {
	@Value("${service.url}")
	String service;
	

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		if(execution.getEventName().equalsIgnoreCase("start")) {
			
			execution.setVariable("urlid", service);
		}
		// TODO Auto-generated method stub
		
	}

}
