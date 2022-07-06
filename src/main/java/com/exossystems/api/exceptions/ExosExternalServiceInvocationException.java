package com.exossystems.api.exceptions;

public class ExosExternalServiceInvocationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6929202975150526214L;

	private String _message;

	protected ExosExternalServiceInvocationException() {
	}

	public ExosExternalServiceInvocationException(String pMessage) {
		_message = pMessage;

	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String pMessage) {
		_message = pMessage;
	}

}
