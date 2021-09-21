package com.revature.dao;

import java.sql.Connection;
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

}
