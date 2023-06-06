package it.sincrono.crm;

import com.fasterxml.jackson.annotation.*;

public class Order {

	private Integer id;

	//@JsonBackReference
	@JsonManagedReference
	private Customer customer;

	public Order() {
		super();
	}

	public Order(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}