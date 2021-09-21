package com.revature.dao;

import java.util.List;

import com.revature.models.Product;

public interface ProductDaoInterface {
	
	public List<Product> getProducts();
	public List <Product> getProductById(int id);
	public List <Product> getProductByCustomerName(String name);
	public void addProduct (Product prod);
	public void deletProduct (int id);

}
