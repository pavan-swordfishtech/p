package com.exossystems.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exossystems.api.exceptions.ExosExternalServiceInvocationException;
import com.exossystems.api.exceptions.ExosExternalServiceMandatoryParameterException;
import com.exossystems.api.products.domain.ProductListResponse;
import com.exossystems.api.products.services.IProductService;
import com.exossystems.api.products.domain.*;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

	@Autowired
	private IProductService _productService;

	@GetMapping(value = "/products")
	ResponseEntity<ProductListResponse> getProducts(@RequestParam String handle)
			throws ExosExternalServiceInvocationException, ExosExternalServiceMandatoryParameterException {
		ProductSearchCriteria pProductSearchCriteria = new ProductSearchCriteria();
		pProductSearchCriteria.setHandle(handle);
		ProductListResponse response = _productService.getProducts(pProductSearchCriteria);

		return new ResponseEntity<ProductListResponse>(response, HttpStatus.OK);

	}
}
