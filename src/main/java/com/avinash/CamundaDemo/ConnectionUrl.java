package com.avinash.CamundaDemo;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ConnectionUrl implements ExecutionListener{
	
	@Value("${backend.baseUrl}")
	private String backendBaseUrl;

	//@Autowired
	//private Environment env;
	
	@Override
	public void notify(DelegateExecution execution) throws Exception {
		
		if(execution.getEventName().equalsIgnoreCase("end")) {
			//String baseUrl=env.getProperty("backend.baseUrl");
			System.out.println("Backend Base URL :: "+backendBaseUrl);
			
			execution.setVariable("baseUrl", backendBaseUrl);
		}
		
	}

}
