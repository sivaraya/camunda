package com.avinash.CamundaDemo.listners;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class ConnectUrlListner implements ExecutionListener,TaskListener{
	
	@Value("${backend.baseUrl}")
	private String backendUrl;

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		
		if(execution.getEventName().equalsIgnoreCase("start")) {
			System.out.println("Start Event Listner Executing..........");
			execution.setVariable("backendUrl", backendUrl);
			
		}
		
		if(execution.getEventName().equalsIgnoreCase("end")) {
			System.out.println("End Event Listner Executing..........");
		}		
	}

	@Override
	public void notify(DelegateTask delegateTask) {
		if(delegateTask.getEventName().equalsIgnoreCase("create")) {
			System.out.println("Start Event Listner Executing..........");
		}
		
	}

}
