package com.exossystems.api.products.domain;

import java.io.Serializable;

public class ProductsDetailInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1722425176095503083L;

	private String code;
	private String desc;
	private boolean isPkg;
	private String srvCode;
	private String typeCode;

	public String getCode() {

		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public boolean isPkg() {
		return isPkg;
	}

	public void setPkg(boolean isPkg) {
		this.isPkg = isPkg;
	}

	public String getSrvCode() {
		return srvCode;
	}

	public void setSrvCode(String srvCode) {
		this.srvCode = srvCode;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

}
