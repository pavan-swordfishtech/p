package com.exossystems.api.products.services;

import com.exossystems.api.exceptions.ExosExternalServiceInvocationException;
import com.exossystems.api.products.domain.ProductListResponse;
import com.exossystems.api.products.domain.ProductSearchCriteria;

public interface IProductService {

	public ProductListResponse getProducts(ProductSearchCriteria pProductSearchCriteria)
			throws ExosExternalServiceInvocationException;

}
