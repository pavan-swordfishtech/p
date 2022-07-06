package com.exossystems.api.products.domain;

import java.io.Serializable;

public class ProductSearchCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1472954401227417932L;

	private String handle;

	public String getHandle() {

		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

}
