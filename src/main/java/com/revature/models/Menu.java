package com.revature.models;

import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.CustomerDao;
import com.revature.dao.ProductDao;



public class Menu {
	
	//productDao object
	ProductDao proDao = new ProductDao();
	
	//CustomerDao object
	CustomerDao custDao = new CustomerDao();
	
	//Logger object 
	Logger log = LogManager.getLogger(Menu.class);
	
	//displayMenu method
	public void displayMenu() {
		System.out.println("*=================================================*");
		System.out.println("Welcome to Our Electronics store!");
		System.out.println("*=================================================*");
		
		
		boolean displayMenu = true;
		Scanner scan = new Scanner (System.in);
		
		
		while (displayMenu) {
			System.out.println();
			System.out.println("Choose an option please: ");
			System.out.println("hi -> for greetings");
			System.out.println("products -> for list of products");
			System.out.println("productById -> for a product by Id");
			System.out.println("productByCustomerName -> for product by customer first name");
			System.out.println("address -> for customer's address");
			System.out.println("addProduct -> to add new product");
			System.out.println("delete -> to delete a product");
			System.out.println("exit -> to exit from the program");
			String line = scan.nextLine();
			
			switch (line) {
			
				case "hi": 
					System.out.println("Hello nice to meet you!");
					break;
			
				case "products":
					
					List<Product> products = proDao.getProducts();
					
					if (products.size() != 0) {
						System.out.println("Here is the list of Products...");
						System.out.println();
						
						for (Product product : products) {
							System.out.println(product);
							System.out.println();
						} 
						
						log.info("USER RETRIEVED LIST OF PRODUCTS");
					} else {
						System.err.println("Sorry products are not available");
					}
					
					break;
					
				case "productById":
					System.out.println("Which product do you want to see? (please type product_id)");
					int productId = scan.nextInt();
					scan.nextLine();
					List<Product> productById = proDao.getProductById(productId);
					
					if(productById.size() != 0) {
						System.out.println("The product id number " + productId + " is:");
						for (Product p : productById) {
							System.out.println(p);
							
						}
					} else {
						System.err.println("Sorry product is not available");
					}
					
					break;
					
				case "productByCustomerName": 
					System.out.println("what is the first name of the customer?");
					String name = scan.nextLine(); 
					List<Product> productByName = proDao.getProductByCustomerName(name);
					
					if (productByName.size() != 0) {
						if (productByName.size() == 1){
							System.out.println("The product ordered by " + name + " is:");
						} else {
							System.out.println("The products ordered by " + name + " are:");
						}
						
						for (Product p : productByName) {
							System.out.println(p);
							
						}
					} else {
						System.err.println("Sorry product is not abvailable");
					}
					
					break;
				case "address":
					
					List<Customer> custAddress = custDao.getCustomerAddress();
					if (custAddress.size() != 0) {
						System.out.println("Here is the address of customers");
						System.out.println();
						for (Customer c: custAddress) {
							System.out.println(c);
						}
					}
							break;
				case "addProduct":
					
					System.out.println("what is the name of the product?");
					String productName = scan.nextLine();
					
					System.out.println("What is the price of the product?");
					int price = scan.nextInt();
					scan.nextLine();
					
					System.out.println("What is the delivery status of the product?");
					String status = scan.nextLine();
					
					System.out.println("What is the customer_id of the product?");
					int customer_id = scan.nextInt();
					scan.nextLine();
	
					Product pro = new Product(productName, price, status, customer_id);
					proDao.addProduct(pro);
					
					log.info("USER ADDED PRODUCT TYPE "+ productName);
					break;
				case "delete":
					System.out.println("Which product do you want to delete? please type the id: ");
					int id = scan.nextInt();
					scan.nextLine();
					
					proDao.deletProduct(id);
					
					log.warn("HELLO USER DELETED PRODUCT ID NUMBER " + id);
					break;
				case "exit":
					displayMenu = false;
					System.out.println("Thank you. come back soon");
					break;
				default:
					System.err.println("Something went wrong... try again please!");
					break;
				
				}   //Switch statement end
				
			
		} //while loop end 
		
		scan.close();
		
	} // displayMenu method end

} // class end
