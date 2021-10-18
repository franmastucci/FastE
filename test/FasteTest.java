import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Faste;
import model.order.Order;
import model.price.CurrentPrice;
import model.provider.Product;
import model.provider.Provider;
import model.user.Customer;
import model.user.Delivery;

class FasteTest {
	
	private List<Customer> customers;
	private List<Delivery> deliverys;
	private List<Product> products;
	private List<Provider> providers;
	private List<Order> orders;
	private Faste faste;

	@BeforeEach
	void setUp()  {

		 this.customers = mock(List.class);           //new ArrayList<Customer>();  
		 this.deliverys = mock(List.class);			  //new ArrayList<Delivery>();
		 this.products =  mock(List.class);			  //new ArrayList<Product>();
		 this.providers = mock(List.class);			  //new ArrayList<Provider>();
		 this.orders =    mock(List.class); 		  //new ArrayList<Order>();
		 faste = Faste.initiate(customers, deliverys, products, providers, orders);
	}

	@Test
	public void testInitiate() {
		assertDoesNotThrow(()->Faste.initiate(customers, deliverys,products,providers,orders));
	}
	
	@Test
	public void testGetCustomers() {
		assertEquals(customers,faste.getCustomers());
	}
	@Test
	public void testGetDeliverys() {
		assertEquals(deliverys,faste.getDeliverys());
	}
	@Test
	public void testGetProducts() {
		assertEquals(products,faste.getProducts());
	}
	@Test
	public void testGetProviders() {
		assertEquals(providers,faste.getProviders());
	}
	@Test
	public void testGetOrders() {
		assertEquals(orders,faste.getOrders());
	}

}
