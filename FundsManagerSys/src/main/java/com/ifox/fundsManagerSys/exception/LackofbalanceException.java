package com.ifox.fundsManagerSys.exception;

public class LackofbalanceException extends Exception{
	
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;

	public LackofbalanceException(){}
	
	public LackofbalanceException(String message) {
		super(message);
	}
	
	public LackofbalanceException(String message,Throwable cause){
		super(message, cause);
	}
}
