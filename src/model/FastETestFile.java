package model;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.dao.QueryDAO;
import model.order.Order;
import model.order.OrderState;
import model.provider.Product;
import model.provider.Provider;
import model.user.Customer;
import model.user.Delivery;
import java.time.LocalDate;
import java.util.List;

import persistence.HibernateUtil;

//Este archivo tiene como finalidad servir de ingreso a la aplicacion para ver los efectos generados en la base de datos

public class FastETestFile {

	//Instanciando el contexto
//	static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationContext.class);
	static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ConfigurationContext.xml");
	

	public static void main(String[] args) {
        FastETestFile faste = new FastETestFile();
        
        faste.mappingTest();
		
		//1° Query
        QueryDAO queryDao = (QueryDAO) context.getBean("queryDAO");

        List<Order> orders = queryDao.getAllOrdersMadeByUser("pepe");
        
        orders.stream().forEach(order-> System.out.println(order));

//        //2° Query

        List<Customer> users = queryDao.getUsersSpendingMoreThan(199f);

        users.stream().forEach(user-> System.out.println(user));

//        //3° Query
        List<Product> expensiveProducts = queryDao.getTop10MoreExpensiveProducts();
        
        expensiveProducts.stream().forEach(product-> System.out.println(product));

        
//        //4° Query
        List<Order> pendingOrders = queryDao.getPendingOrders();
        
        pendingOrders.stream().forEach(order-> System.out.println(order));


//        //5° Query
        List<Order> cancelledOrders = queryDao.getCancelledOrdersInPeriod(LocalDate.of(2020, 1, 10),LocalDate.of(2021, 10, 10) );
        
        cancelledOrders.stream().forEach(order-> System.out.println(order));

        
//        //6° Query
        List<Order> deliveredOrders = queryDao.getDeliveredOrdersForUser("josepe");
        
        deliveredOrders.stream().forEach(order-> System.out.println(order));

//        //7° Query
        List<Product> products = queryDao.getProductsOnePrice();
        
        products.stream().forEach(product-> System.out.println(product));

//        //8° Query
        List<Product> soldOnProducts = queryDao.getSoldProductsOn(LocalDate.of(2021, 9, 23));
        
        soldOnProducts.stream().forEach(product-> System.out.println(product));

//        List<Product> productsWithPrice = queryDao.getProductsWithPriceAt();;

        //10° Query
        List<Product> notSoldProducts = queryDao.getProductsNotSold();
        
        notSoldProducts.stream().forEach(product-> System.out.println(product));
	}
	
	 private void mappingTest() {

	    	//Instantiate a session 
	    	Session session = HibernateUtil.getSessionFactory().openSession();

	        session.beginTransaction();
	        
	        session.save(OrderState.getPendingState());
	        session.save(OrderState.getPreparedState());
	        session.save(OrderState.getArrivedState());
	        session.save(OrderState.getCancelState());
	        
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
	        
	        
	        session.getTransaction().commit();
	        

        session.close();
    }

}

