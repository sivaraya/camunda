package com.avinash.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class TestDelegate implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		String name=(String) execution.getVariable("name");
		System.out.println("test  :: "+name);
		
		execution.setVariable("field1", "Test");
		
	}

}
