package com.avinash.CamundaDemo.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class TestDelegate implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		String name=(String) execution.getVariable("name");
		
		String address=(String) execution.getVariable("address");
		
		String country="India";
		System.out.println("Name :: "+name+"  Address :: "+address);
		
		execution.setVariable("country", country);
		
	}


}
