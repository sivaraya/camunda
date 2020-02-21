package com.avinash.CamundaDemo.util;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author S!VaRaYapUReddY
 *
 */
@Service("loggerUtil")
public class LoggerUtil {

	private static final Logger log=LoggerFactory.getLogger(LoggerUtil.class);

	private static final String TASK_ID="X-taskId";


	public void taskProcessing(String taskId,Object payload) {

		try {
			DelegateExecution execution = null;
			if((taskId == null || taskId.isEmpty()) && payload instanceof DelegateExecution) {
				execution= (DelegateExecution) payload;
				taskId = execution.getProcessInstanceId()+"_"+execution.getCurrentActivityName();
				payload=execution.getVariables();
				execution.setVariableLocal("taskId", taskId);
				log.info("Processing Task <{}> - <{}>",taskId,execution.getCurrentActivityName());
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void taskCompleted(String taskId, Integer statusCode,String statusMessage,Object payload) {
		try {
			if(statusCode >=200 && statusCode < 300) {
				logInfo("Task<{}> processing completed with CLOSED- statusCode: <{}>, statusMessage:<{}>, output: <{}>", 
						taskId, HttpStatus.valueOf(statusCode).value(),
						HttpStatus.valueOf(statusCode).getReasonPhrase(),
						payload instanceof String ? payload : new ObjectMapper().writeValueAsString(payload));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	/**
	 * Logs a 'INFO' message
	 * @param message
	 * @param parameters
	 */
	public void logInfo(String message, Object... parameters) {
		log.info(message,parameters);
	}
}
