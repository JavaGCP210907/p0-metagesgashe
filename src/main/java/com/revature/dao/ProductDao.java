package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Product;
import com.revature.utils.ConnectionUtil;



public class ProductDao implements ProductDaoInterface {

	@Override
	public List<Product> getProducts() {
		try (Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from products";
			
			Statement st = conn.createStatement();
			
			rs = st.executeQuery(sql);
			
			List<Product> productList = new ArrayList<>();
			
			while(rs.next()) {
				Product p = new Product(
				rs.getInt("product_id"),
				rs.getString("product_name"),
				rs.getDouble("price"),
				rs.getString("delivery_status"),
				rs.getInt("customer_id")
			);
				productList.add(p);

			}
			return productList;
			
			
		} catch (SQLException e) {
			System.err.println("Sorry we can't find the list of products!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getProductById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			ResultSet rs = null;
			
			String sql = "select * from products where product_id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			List<Product> productList = new ArrayList<>();
			while(rs.next()) {
				Product p = new Product (
						rs.getInt("product_id"),
						rs.getString("product_name"),
						rs.getDouble("price"),
						rs.getString("delivery_status"),
						rs.getInt("customer_id")
				);
				productList.add(p);
			}
			
			return productList;
			
		} catch (SQLException e) {
			System.out.println("Sorry we can't find the product with the id number: " + id);
			System.out.println();
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List <Product> getProductByCustomerName(String name){
		try(Connection conn = ConnectionUtil.getConnection()){
						
			ResultSet rs = null;
			
			String sql = "select * from products p join customers c on p.customer_id = c.customer_id where c.f_name=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			List<Product> productList = new ArrayList<>(); 
			
			while(rs.next()) {
				
				Product p = new Product(
						rs.getInt("product_id"),
						rs.getString("product_name"),
						rs.getDouble("price"),
						rs.getString("delivery_status"),
						rs.getInt("customer_id")
				);
				productList.add(p);
			}
			
		return productList;
			
		} catch (SQLException e) {
			System.err.println("Sorry we can't find the product");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addProduct(Product prod) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "insert into products (product_name, price, delivery_status, customer_id) values (?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, prod.getProduct_name());
			ps.setDouble(2, prod.getPrice());
			ps.setString(3, prod.getDelivery_status());
			ps.setInt(4, prod.getCustomer_id());
			
			ps.executeUpdate();
			System.out.println("Product " + prod.getProduct_name() + "was added!");
			System.out.println();
			System.out.println();
		} catch (SQLException e) {
			System.err.println("Sorry we can't add the product");
			System.out.println();
			e.printStackTrace();
		}

	}

	@Override
	public void deletProduct(int id) {
		
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "delete from products where product_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("The product with id number " + id + " is deleted!");
			System.out.println();
			
		} catch (SQLException e) {
			System.err.println("Sorry some thing went wrong. We can't delete the product.");
		}
		
	}

}
