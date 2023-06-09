package com.besanttech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.besanttech.beans.Product;

public class ProductDao {
	static Connection con = null;
	static {
		// initialize data source connections
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myshoppingstore", "root", "vivoy73sk");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		try {

			String getProductsQuery = "select * from products";
			PreparedStatement stmt = con.prepareStatement(getProductsQuery);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setProductid(rs.getInt(1));
				product.setProductname(rs.getString(2));
				product.setProductcolor(rs.getString(3));
				product.setProductprice(rs.getFloat(4));
				product.setProductquantity(rs.getInt(5));
				products.add(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public Product getProductById(int id) {

		try {
			String getProductQuery = "select * from products where product_id=?";
			PreparedStatement stmt = con.prepareStatement(getProductQuery);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				Product product = new Product();
				product.setProductid(rs.getInt(1));
				product.setProductname(rs.getString(2));
				product.setProductcolor(rs.getString(3));
				product.setProductprice(rs.getFloat(4));
				product.setProductquantity(rs.getInt(5));
				return product;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//public Product ProductgetById(int parseInt) {
		// TODO Auto-generated method stub
	//	return null;
//	}

	public Product getById(Integer parseInt) {
		// TODO Auto-generated method stub
		return null;
	}
}