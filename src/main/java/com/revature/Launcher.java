package com.revature;

import java.sql.Connection;
import java.sql.SQLException;
import com.revature.models.Menu;
import com.revature.utils.ConnectionUtil;


public class Launcher {

	public static void main(String[] args) {

		try (Connection con = ConnectionUtil.getConnection()){
			System.out.println("Connection was successful!");
		} catch (SQLException e) {
			System.err.println("Sorry connection failed!");
			e.printStackTrace();
		}
		
		Menu menu = new Menu();
		menu.displayMenu();

	}

}
