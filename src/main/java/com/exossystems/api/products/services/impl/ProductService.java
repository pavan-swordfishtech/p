package com.exossystems.api.products.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.exossystems.api.exceptions.ExosExternalServiceInvocationException;
import com.exossystems.api.products.domain.ProductListResponse;
import com.exossystems.api.products.domain.ProductSearchCriteria;
import com.exossystems.api.products.services.IProductService;
import com.exossystems.constants.GlobalConstants;
import com.exossystems.repository.db.model.IProductGroupsRepository;
import com.exossystems.repository.db.model.IProductsRepository;
import com.exossystems.util.RestTemplateWrapper;

@Service
public class ProductService implements IProductService {

	@Value("${" + GlobalConstants.APPSERVER_ENDPOINT_CONFIG + "}")
	private String appserverEndpointConfig;

	@Value("${" + GlobalConstants.PRODUCTS_LIST + "}")
	private String productsList;

	@Autowired
	IProductGroupsRepository productGroupRepository;

	@Autowired
	IProductsRepository productsRepository;

	@Autowired
	RestTemplateWrapper restTemplateWrapper;

	@Override
	public ProductListResponse getProducts(ProductSearchCriteria pCriteria)
			throws ExosExternalServiceInvocationException {

		ProductListResponse response = null;
		try {

			response = restTemplateWrapper.postForEntity(ProductListResponse.class,
					appserverEndpointConfig + productsList, pCriteria);

			this.productsRepository.deleteAllProducts();
			this.productGroupRepository.deleteAllProductGroups();

			this.productGroupRepository.insertIntoProductGroups(response.getProductLimitedDetails());
			return response;
		} catch (Exception e) {
			throw new ExosExternalServiceInvocationException(e.getMessage());
		}
	}

}
