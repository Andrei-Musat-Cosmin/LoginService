package it.sincrono.crm;

import java.util.List;

import com.fasterxml.jackson.annotation.*;

public class Customer {

	private Integer id;

	@JsonBackReference
	//@JsonManagedReference
	private List<Order> orders;

	public Customer() {
		super();
	}

	public Customer(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}