package model;

import java.util.ArrayList;
import java.util.List;

import model.order.Order;
import model.provider.Product;
import model.provider.Provider;
import model.user.Customer;
import model.user.Delivery;


public class Faste {

	private List<Customer> customers;
	private List<Delivery> deliverys;
	private List<Product> products;
	private List<Provider> providers;
	private List<Order> orders;

	private Faste() {
		customers = new ArrayList<Customer>();
		deliverys = new ArrayList<Delivery>();
		products = new ArrayList<Product>();
		providers = new ArrayList<Provider>();
		orders = new ArrayList<Order>();
	}
	
	private Faste(List<Customer> aCustomerList, List<Delivery> aDeliveryList, List<Product> aProductList,
			List<Provider> aProviderList, List<Order> anOrderList) {
		this.customers = aCustomerList;
		this.deliverys = aDeliveryList;
		this.products = aProductList;
		this.providers = aProviderList;
		this.orders = anOrderList;
	}

	public static Faste initiate(List<Customer> aCustomerList, List<Delivery> aDeliveryList, List<Product> aProductList,
			List<Provider> aProviderList, List<Order> anOrderList) {
		return new Faste(aCustomerList, aDeliveryList, aProductList, aProviderList, anOrderList);
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	
	@SuppressWarnings("unused")
	private void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Delivery> getDeliverys() {
		return deliverys;
	}

	@SuppressWarnings("unused")
	private void setDeliverys(List<Delivery> deliverys) {
		this.deliverys = deliverys;
	}

	public List<Product> getProducts() {
		return products;
	}

	@SuppressWarnings("unused")
	private void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	@SuppressWarnings("unused")
	private void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

	public List<Order> getOrders() {
		return orders;
	}

	@SuppressWarnings("unused")
	private void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
