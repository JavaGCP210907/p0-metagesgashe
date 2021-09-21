package com.revature.models;

public class Product {
	private int product_id;
	private String product_name;
	private double price;
	private String delivery_status;
	private int customer_id;

	
	// boiler plate code below
	
	//No args constructor
	public Product() {
		super();
		
	}

//All args constructor
	public Product(int product_id, String product_name, double price, String delivery_status, int customer_id) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
		this.delivery_status = delivery_status;
		this.customer_id = customer_id;
	}

    //Some args constructor (all except product_id)
	public Product(String product_name, double price, String delivery_status, int customer_id) {
		super();
		this.product_name = product_name;
		this.price = price;
		this.delivery_status = delivery_status;
		this.customer_id = customer_id;
	}
	
	
	//toString method
	@Override
	public String toString() {
		return "Product Id = " + product_id + ", Product Name = " + product_name + ", Price = $" + price + ", Delivery Status = "
				+ delivery_status + ", Customer Id = " + customer_id;
	}

	// getters and setters 
	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDelivery_status() {
		return delivery_status;
	}

	public void setDelivery_status(String delivery_status) {
		this.delivery_status = delivery_status;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	
	//Hash code
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customer_id;
		result = prime * result + ((delivery_status == null) ? 0 : delivery_status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + product_id;
		result = prime * result + ((product_name == null) ? 0 : product_name.hashCode());
		return result;
	}

	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (customer_id != other.customer_id)
			return false;
		if (delivery_status == null) {
			if (other.delivery_status != null)
				return false;
		} else if (!delivery_status.equals(other.delivery_status))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (product_id != other.product_id)
			return false;
		if (product_name == null) {
			if (other.product_name != null)
				return false;
		} else if (!product_name.equals(other.product_name))
			return false;
		return true;
	}
	
	
	
	
	

}
