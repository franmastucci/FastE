package model;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.dao.QueryDAO;
import model.order.Order;
import model.order.OrderStateFactory;
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

        faste.querys();

    }

	private void querys() {
		//1∞ Query
        QueryDAO queryDao = (QueryDAO) context.getBean("queryDAO");

        this.printQueryResult(queryDao.getAllOrdersMadeByUser("pepe"));

        //2∞ Query
        this.printQueryResult(queryDao.getUsersSpendingMoreThan(199f)); 

        //3∞ Query
        this.printQueryResult(queryDao.getTop10MoreExpensiveProducts());

        //4∞ Query
        this.printQueryResult(queryDao.getPendingOrders());

        //5∞ Query
        this.printQueryResult(queryDao.getCancelledOrdersInPeriod(LocalDate.of(2020, 1, 10),LocalDate.of(2021, 10, 10)));

        //6∞ Query
        this.printQueryResult(queryDao.getDeliveredOrdersForUser("josepe"));

        //7∞ Query
        this.printQueryResult(queryDao.getProductsOnePrice());

        //8∞ Query
        this.printQueryResult(queryDao.getSoldProductsOn(LocalDate.of(2021, 9, 23)));

        //9∞ Query, se retorna la lista de precios para la fecha pedida a la que se puede solicitar el producto del mismo
        this.printQueryResult(queryDao.getProductsWithPriceAt(LocalDate.now()));

        //10∞ Query
        this.printQueryResult(queryDao.getProductsNotSold());
	}

     private void printQueryResult(List<?> queryResultList) {
        queryResultList.stream().forEach(result-> System.out.println(result));
    }
	 
     private void mappingTest() {

	    	//Instantiate a session 
	    	Session session = HibernateUtil.getSessionFactory().openSession();

	        session.beginTransaction();
	        
	        session.save(OrderStateFactory.getPendingState());
	        session.save(OrderStateFactory.getPreparedState());
	        session.save(OrderStateFactory.getArrivedState());
	        session.save(OrderStateFactory.getCancelState());
	        
	        //Instantiate persistent objects 
	        Customer pepe = Customer.register("pepe", "contrase√±a_", "Pepe", "pepe@mail.com", LocalDate.of(1999,2,1));
	        Delivery jose = Delivery.register("josepe", "algo!", "Jose", "jose@mail.com", LocalDate.of(1980,2 ,1), 10f);
	        Provider cocaCola = Provider.register(20301230001l, "Coca-Cola", "calle falsa 123", 0, 10);
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

