package com.exossystems.api.exceptions;

import java.util.UUID;

public class ExosExceptionSchema {

	private String _message;
	private UUID _trackingId;

	protected ExosExceptionSchema() {
	}

	public ExosExceptionSchema(String pMessage, UUID pTrackingId) {
		_message = pMessage;
		_trackingId = pTrackingId;

	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String pMessage) {
		_message = pMessage;
	}

	public UUID getTrackingId() {
		return _trackingId;
	}

	public void setTrackingId(UUID pTrackingId) {
		_trackingId = pTrackingId;
	}
}
