package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.utils.ConnectionUtil;

public class CustomerDao implements CustomerDaoInterface {

	@Override
	public List<Customer> getCustomerAddress() {
		try(Connection conn = ConnectionUtil.getConnection()){
			ResultSet rs = null;
			String sql = "SELECT * FROM customers";
			Statement st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			List<Customer> addressList = new ArrayList<>();
			while(rs.next()) {
				Customer c = new Customer(
						rs.getInt("customer_id"),
						rs.getString("f_name"),
						rs.getString("l_name"),
						rs.getString("street_number"),
						rs.getString("city"),
						rs.getString("state"),
						rs.getString("zip_code")
						);
				addressList.add(c);
			}
			
			return addressList;
			
		} catch (SQLException e) {
			System.out.println("Sorry we can't display the address of the customer");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addCustomer(Customer cust) {
		
			try(Connection conn = ConnectionUtil.getConnection()){
				
				String sql = "insert into customers (f_name, l_name, street_number, city, state, zip_code) values (?, ?, ?, ?, ?, ?)";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, cust.getF_name());
				ps.setString(2, cust.getL_name());
				ps.setString(3, cust.getStreet_number());
				ps.setString(4, cust.getCity());
				ps.setString(5, cust.getState());
				ps.setString(6, cust.getZip_code());
				ps.executeUpdate();
				
				System.out.println("Customer " + cust.getF_name() + " was added!");
				System.out.println();
				System.out.println();
			} catch (SQLException e) {
				System.err.println("Sorry we can't add the customer");
				System.out.println();
				e.printStackTrace();
			}

		}
	
	@Override
	public void deletCustomer(int id) {
		
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "delete from customers where customer_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("The customer with id number " + id + " is deleted!");
			System.out.println();
			
		} catch (SQLException e) {
			System.err.println("Sorry we can't delete the customer");
			System.err.println("Sorry some thing went wrong. We can't delete the customer.");
		}
		
	}
		
	

}
