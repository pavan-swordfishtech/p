package com.exossystems.repository.db.model;

import java.util.List;

import com.exossystems.api.products.domain.ProductsDetailInfo;

public interface IProductsRepository {

	public void insertProducts(Integer productGroupId, List<ProductsDetailInfo> products);

	public void deleteAllProducts();

}
