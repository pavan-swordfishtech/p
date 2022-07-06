package com.exossystems.repository.db.model;

import java.util.List;

import com.exossystems.api.products.domain.ProductGroupsDetailInfo;

public interface IProductGroupsRepository {

	public void insertIntoProductGroups(List<ProductGroupsDetailInfo> productGroups);

	public void deleteAllProductGroups();
}
