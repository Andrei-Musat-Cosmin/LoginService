package it.sincrono.crm;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	public static void main(String[] args) throws Exception {

	      Customer customer = new Customer();
	      customer.setId(10);

		  Order order1 = new Order();
	      order1.setId(5);
	      order1.setCustomer(customer);

		  Order order2 = new Order();
	      order2.setId(15);
	      order1.setCustomer(customer);

	      List<Order> orders = new ArrayList<Order>();
	      orders.add(order1);
	      orders.add(order2);
	      customer.setOrders(orders);

	      System.out.println("-- serializing --");
	      ObjectMapper om = new ObjectMapper();
	      om.setSerializationInclusion(Include.NON_NULL);
	      om.setSerializationInclusion(Include.NON_EMPTY);
	      String s = om.writeValueAsString(customer);
	      //String s = om.writeValueAsString(order1);
	      System.out.println(s);
	}
}