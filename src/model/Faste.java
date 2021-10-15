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

	@SuppressWarnings("unused")
	private Faste() {
		this.customers = new ArrayList<Customer>();
		this.deliverys = new ArrayList<Delivery>();
		this.products = new ArrayList<Product>();
		this.providers = new ArrayList<Provider>();
		this.orders = new ArrayList<Order>();
	}
	
	public Faste(List<Customer> aCustomerList, List<Delivery> aDeliveryList, List<Product> aProductList,
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
		return this.customers;
	}

	
	@SuppressWarnings("unused")
	private void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Delivery> getDeliverys() {
		return this.deliverys;
	}

	@SuppressWarnings("unused")
	private void setDeliverys(List<Delivery> deliverys) {
		this.deliverys = deliverys;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	@SuppressWarnings("unused")
	private void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Provider> getProviders() {
		return this.providers;
	}

	@SuppressWarnings("unused")
	private void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	@SuppressWarnings("unused")
	private void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
