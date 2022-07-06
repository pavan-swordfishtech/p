package com.exossystems.api.products.domain;

import java.io.Serializable;
import java.util.List;

public class ProductGroupsDetailInfo implements Serializable {

	private static final long serialVersionUID = 5256095031787109724L;

	private String groupCode;
	private List<ProductsDetailInfo> groupProducts;

	public String getGroupCode() {

		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public List<ProductsDetailInfo> getGroupProducts() {
		return groupProducts;
	}

	public void setGroupProducts(List<ProductsDetailInfo> groupProducts) {
		this.groupProducts = groupProducts;
	}

}
