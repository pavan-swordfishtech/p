package com.exossystems.repository.db.repo.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.exossystems.api.products.domain.ProductsDetailInfo;
import com.exossystems.repository.db.model.IProductsRepository;

@Repository
public class ProducstRepository extends JdbcDaoSupport implements IProductsRepository {

	private static final String INSERT_PRODUCT_SQL = "INSERT INTO products_sch.products "
			+ "  (code, productgroupid, description, servcode, typecode, pkg ) VALUES " + " (?,?,?,?,?,?);";
	private static final String DELETE_PRODUCTS_SQL = "DELETE FROM products_sch.products ;";

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public void insertProducts(Integer productId, List<ProductsDetailInfo> list) {

		getJdbcTemplate().batchUpdate(INSERT_PRODUCT_SQL, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ProductsDetailInfo product = list.get(i);
				ps.setString(1, product.getCode());
				ps.setInt(2, productId);
				ps.setString(3, product.getDesc());
				ps.setString(4, product.getSrvCode());
				ps.setString(5, product.getTypeCode());
				ps.setBoolean(6, product.isPkg());
			}

			public int getBatchSize() {
				return list.size();
			}
		});

	}

	@Override
	public void deleteAllProducts() {

		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(connection -> {
			PreparedStatement ps = connection.prepareStatement(DELETE_PRODUCTS_SQL, Statement.RETURN_GENERATED_KEYS);
			return ps;
		}, keyHolder);

	}

}
