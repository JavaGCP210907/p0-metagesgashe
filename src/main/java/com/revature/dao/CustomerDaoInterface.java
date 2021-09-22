package com.revature.dao;

import java.util.List;

import com.revature.models.Customer;

public interface CustomerDaoInterface {
	
	public List<Customer> getCustomerAddress();
	
	public void addCustomer(Customer cust);
	public void deletCustomer(int id);

}
