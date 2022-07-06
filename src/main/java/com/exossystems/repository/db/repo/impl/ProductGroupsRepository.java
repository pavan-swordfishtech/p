package com.exossystems.repository.db.repo.impl;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.function.Consumer;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.exossystems.api.products.domain.ProductGroupsDetailInfo;
import com.exossystems.repository.db.model.IProductGroupsRepository;
import com.exossystems.repository.db.model.IProductsRepository;

@Repository
public class ProductGroupsRepository extends JdbcDaoSupport implements IProductGroupsRepository {

	private static final String DELETE_PRODUCTGROUP_SQL = "DELETE FROM products_sch.product_groups ;";

	private static final String INSERT_PRODUCTGROUP_SQL = "INSERT INTO products_sch.product_groups  "
			+ "  (group_code) VALUES " + " (?);";

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Autowired
	IProductsRepository productsRepository;

	@Override
	public void insertIntoProductGroups(List<ProductGroupsDetailInfo> list) {

		KeyHolder keyHolder = new GeneratedKeyHolder();

		list.forEach(new Consumer<ProductGroupsDetailInfo>() {

			public void accept(ProductGroupsDetailInfo item) {
				getJdbcTemplate().update(connection -> {
					PreparedStatement ps = connection.prepareStatement(INSERT_PRODUCTGROUP_SQL,
							Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, item.getGroupCode());
					return ps;
				}, keyHolder);
				productsRepository.insertProducts(Integer.parseInt(keyHolder.getKeys().get("id").toString()),
						item.getGroupProducts());
			}
		});

	}

	@Override
	public void deleteAllProductGroups() {

		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(connection -> {
			PreparedStatement ps = connection.prepareStatement(DELETE_PRODUCTGROUP_SQL,
					Statement.RETURN_GENERATED_KEYS);
			return ps;
		}, keyHolder);

	}

}
