package com.revature.models;

public class Customer {
	private int customer_id;
	private String f_name;
	private String l_name;
	private String street_number;
	private String city;
	private String state;
	private String zip_code;
	
	//No args constructor
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//All args constructor
	public Customer(int customer_id, String f_name, String l_name, String street_number, String city, String state,
			String zip_code) {
		super();
		this.customer_id = customer_id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.street_number = street_number;
		this.city = city;
		this.state = state;
		this.zip_code = zip_code;
	}


	//Some args constructor (All except customer_id)
	public Customer(String f_name, String l_name, String street_number, String city, String state, String zip_code) {
		super();
		this.f_name = f_name;
		this.l_name = l_name;
		this.street_number = street_number;
		this.city = city;
		this.state = state;
		this.zip_code = zip_code;
	}

	
	//toString method
		@Override
		public String toString() {
			return customer_id + ". " + "Name: " + f_name +" "+ l_name + " Address: " +  street_number + " "
					+ city + ", " + state + ", " + zip_code;
		}
		

	//getters and setters
	public int getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}


	public String getF_name() {
		return f_name;
	}


	public void setF_name(String f_name) {
		this.f_name = f_name;
	}


	public String getL_name() {
		return l_name;
	}


	public void setL_name(String l_name) {
		this.l_name = l_name;
	}


	public String getStreet_number() {
		return street_number;
	}


	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZip_code() {
		return zip_code;
	}


	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}


	//hash code
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + customer_id;
		result = prime * result + ((f_name == null) ? 0 : f_name.hashCode());
		result = prime * result + ((l_name == null) ? 0 : l_name.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street_number == null) ? 0 : street_number.hashCode());
		result = prime * result + ((zip_code == null) ? 0 : zip_code.hashCode());
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
		Customer other = (Customer) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (customer_id != other.customer_id)
			return false;
		if (f_name == null) {
			if (other.f_name != null)
				return false;
		} else if (!f_name.equals(other.f_name))
			return false;
		if (l_name == null) {
			if (other.l_name != null)
				return false;
		} else if (!l_name.equals(other.l_name))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street_number == null) {
			if (other.street_number != null)
				return false;
		} else if (!street_number.equals(other.street_number))
			return false;
		if (zip_code == null) {
			if (other.zip_code != null)
				return false;
		} else if (!zip_code.equals(other.zip_code))
			return false;
		return true;
	}
	
	
	
	
}
