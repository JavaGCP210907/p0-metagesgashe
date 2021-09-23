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
		System.out.println("*======================================================*");
		System.out.println("Welcome to XYZ Electronics order management application!");
		System.out.println("*======================================================*");
		
		
		boolean displayMenu = true;
		Scanner scan = new Scanner (System.in);
		
		
		while (displayMenu) {
			System.out.println();
			System.out.println("Choose an option please: \n");
			
			System.out.println("hi             -> for greetings");
			
			System.out.println("products       -> for list of products");
			
			System.out.println("productById    -> for a product by Id");
			
			System.out.println("customers      -> for customers names and addresses");
			
			System.out.println("productByCustomerName -> for product by customer first name");
			
			System.out.println("addCustomer    -> to add new customer");
			
			System.out.println("addProduct     -> to add new product");
			
			System.out.println("updatePrice    -> to update the price of a product");
			
			System.out.println("deleteProduct  -> to delete a product");
			
			System.out.println("deleteCustomer -> to delete a customer");
			
			System.out.println("exit           -> to exit from the application");
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
				case "customers":
					
					List<Customer> custAddress = custDao.getCustomerAddress();
					if (custAddress.size() != 0) {
						System.out.println("Here is the list of customers with their address: ");
						System.out.println();
						for (Customer c: custAddress) {
							System.out.println(c);
							System.out.println();
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
					
				case "addCustomer":
					System.out.println("First name: ");
					String f_name = scan.nextLine();
					
					System.out.println("Last name: ");
					String l_name = scan.nextLine();
					
					System.out.println("Street number: ");
					String street = scan.nextLine();
					
					System.out.println("City: ");
					String city = scan.nextLine();
					
					System.out.println("State: ");
					String state = scan.nextLine();
					
					System.out.println("Zip code: ");
					String zip_code = scan.nextLine();
					
					Customer customer = new Customer(f_name, l_name, street, city, state, zip_code);
					custDao.addCustomer(customer);
					
					log.info("USER ADDED CUSTOMER "+ f_name);
					break;
				
				case "updatePrice":
					System.out.println("product_id: ");
					int proId = scan.nextInt();
					scan.nextLine();
					System.out.println("New price: ");
					double newPrice = scan.nextDouble();
					scan.nextLine();
					
					proDao.updatePrice(proId, newPrice);
					log.info("HELLO USER UPDATED THE PRICE OF ID " + proId);
					break;
					
				case "deleteProduct":
					System.out.println("Which product do you want to delete? please type the id: ");
					int id = scan.nextInt();
					scan.nextLine();
					
					proDao.deletProduct(id);
					
					log.warn("HELLO USER DELETED PRODUCT ID NUMBER " + id);
					break;
					
				case "deleteCustomer":
					System.out.println("Which customer do you want to delete? please use customer id: ");
					int cust_id = scan.nextInt();
					scan.nextLine();
					
					custDao.deletCustomer(cust_id);
					log.warn("HELLO USER DELETED A CUSTOMER ID NUMBER " + cust_id);
					break;
					
				case "exit":
					displayMenu = false;
					System.out.println("Thank you for using our application! \nCome back soon");
					break;
					
				default:
					System.err.println("Something went wrong... try again please!");
					break;
				
				}   //Switch statement end
				
			
		} //while loop end 
		
		scan.close();
		
	} // displayMenu method end

} // class end
