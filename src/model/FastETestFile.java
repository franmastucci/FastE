package model;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.dao.QueryDAO;
import model.order.DeliverOrder;
import model.order.Order;
import model.provider.Product;
import model.provider.Provider;
import model.user.Customer;
import model.user.Delivery;
import model.user.User;

import java.time.LocalDate;
import java.util.List;

import persistence.HibernateUtil;

//Este archivo tiene como finalidad servir de ingreso a la aplicacion para ver los efectos generados en la base de datos

public class FastETestFile {

	//Instanciando el contexto
//	static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationContext.class);
	static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ConfigurationContext.xml");
	

	public static void main(String[] args) {
        //FastETestFile faste = new FastETestFile();
        
        //faste.mappingTest();
		
        
        QueryDAO queryDao = (QueryDAO) context.getBean("queryDAO");

        List<Order> orders = queryDao.getAllOrdersMadeByUser("pepe");
        
        orders.stream().forEach(order-> System.out.println(order));
        
//	   	 for(Order i: orders)
//		 {
//			 System.out.println("Order Number : " + i.getOrderNumber());
//			 System.out.println("quantity : " + i.getQuantity());
//			 
//			 // could not initialize proxy [model.user.User#pepe] - no Session
//			
//			 //System.out.println("Customer Name : " + i.getCustomer()); 
//			 //System.out.println("Product name : " + i.getProduct());
//			 //System.out.println("State : " + i.getState());
//			 System.out.println();
//		 }
//
//        List<Customer> users = queryDao.getUsersSpendingMoreThan();
//        
//        for(User name: users) {
//        	System.out.println(name);
//        }
//
//        List<Product> expensiveProducts = queryDao.getTop10MoeExpensiveProducts();
//        
//        for(Product name: expensiveProducts) {
//        	System.out.println(name);
//        }
//
//        List<Order> pendingOrders = queryDao.getPendingOrders();
//        
//        for(Order name: pendingOrders) {
//        	System.out.println(name);
//        }
//
//        List<Order> cancelledOrders = queryDao.getCancelledOrdersInPeriod();
//        
//        for(Order name:cancelledOrders) {
//        	System.out.println(name);
//        }
//
//        List<Order> deliveredOrders = queryDao.getDeliveredOrdersForUser();
//        
//        for(Order name: deliveredOrders) {
//        	System.out.println(name);
//        }
//
//        List<String> products = queryDao.getProductsOnePrice();
//        
//        for(String name:products) {
//        	System.out.println(name);
//        }
//
//        List<Product> soldOnProducts = queryDao.getSoldProductsOn();
//        
//        for(Product name: soldOnProducts) {
//        	System.out.println(name);
//        }
//
//        List<Product> productsWithPrice = queryDao.getProductsWithPriceAt();;
//        
//        for(Product name: productsWithPrice) {
//        	System.out.println(name);
//        }
//
//        List<String> notSoldProducts = queryDao.getProductsNotSold();
//        
//        for(String name: notSoldProducts) {
//        	System.out.println(name);
//        }
        
	}
	
	 private void mappingTest() {

	    	//Instantiate a session 
	    	Session session = HibernateUtil.getSessionFactory().openSession();

	        session.beginTransaction();
	        
	        //Instantiate persistent objects 
	        Customer pepe = Customer.register("pepe", "contraseña", "Pepe", "pepe@mail.com", LocalDate.now());
	        Delivery jose = Delivery.register("josepe", "algo", "Jose", "jose@mail.com", LocalDate.now(), 10f);
	        Provider cocaCola = Provider.register(3030123, "Coca-Cola", "calle falsa 123", 0, 10);
	        Product coca = Product.publishProduct("Coca", cocaCola, 1.0f, 15.0f);
	        Product cindor = Product.publishProduct("Cindor", cocaCola, 1.0f, 20.0f);
	        Product sprite = Product.publishProduct("Sprite", cocaCola, 1.0f, 20.0f);
	        Product fanta = Product.publishProduct("Fanta", cocaCola, 1.0f, 20.0f);
	        Product shweps = Product.publishProduct("Shweps", cocaCola, 1.0f, 25.0f);
	        Order cokeOrder = pepe.makeAnOrder(coca, 1);
	        Order spriteOrder = pepe.makeAnOrder(sprite, 1);
	        Order fantaOrder = pepe.makeAnOrder(fanta, 1);
	        Order cindorOrder = pepe.makeAnOrder(cindor, 10);
	        DeliverOrder order = DeliverOrder.doneOrderDeliver(cindorOrder, jose);  
	        DeliverOrder otherOrder = DeliverOrder.doneOrderDeliver(cokeOrder, jose);
	        DeliverOrder otherSpriteOrder = DeliverOrder.doneOrderDeliver(spriteOrder, jose);
	        DeliverOrder otherFantaOrder = DeliverOrder.doneOrderDeliver(fantaOrder, jose);
	        
	        //Persist objects
	        session.save(pepe);
	        session.save(jose);
	        session.save(cocaCola);
	        
	        coca.updatePrice(25.0f);
	        coca.updatePrice(35.0f);
	        coca.updatePrice(55.0f);
	        cindor.updatePrice(25.0f);
	        cindor.updatePrice(30.0f);
	        cindor.updatePrice(40.0f);
	        
	        session.save(cindor);
	        session.save(coca);
	        session.save(sprite);
	        session.save(fanta);
	        session.save(shweps);
	        
	        session.save(cokeOrder);
	        session.save(cindorOrder);
	        session.save(spriteOrder);
	        session.save(fantaOrder);
	        
	        cindorOrder.getPrepare();
	        jose.deliver(cindorOrder);
	        cokeOrder.getPrepare();
	        jose.deliver(cokeOrder);
	        
	        spriteOrder.getPrepare();
	        jose.deliver(spriteOrder);
	        
	 
	        
	        session.save(order);
	        session.save(otherOrder);
	        session.save(otherSpriteOrder);
	        session.save(otherFantaOrder);
	        
	        Order dato = session.load(Order.class, Integer.toUnsignedLong(1));
	        System.out.println("El estado de la orden " + dato.getOrderNumber() + " del cliente " 
	        + dato.getCustomer().getUserName() + " de " + dato.getProduct().getName() + " por la cantidad de "
	        		+ dato.getQuantity() + " es " + dato.getState().getName() + " y suma un total a pagar de "
	        		+ dato.getTotalCost());
	        
	        session.getTransaction().commit();
	        

        session.close();
    }

}

