package com.exossystems.api.products.domain;

import java.io.Serializable;
import java.util.List;

public class ProductListResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3440779723999889679L;

	private List<ProductGroupsDetailInfo> productLimitedDetails;

	public List<ProductGroupsDetailInfo> getProductLimitedDetails() {

		return productLimitedDetails;
	}

	public void setProductLimitedDetails(List<ProductGroupsDetailInfo> productLimitedDetails) {
		this.productLimitedDetails = productLimitedDetails;
	}

}
