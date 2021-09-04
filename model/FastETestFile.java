package model;
import org.hibernate.Session;

import model.order.DeliverOrder;
import model.order.Order;
import model.provider.Address;
import model.provider.Product;
import model.provider.Provider;
import model.user.Customer;
import model.user.Delivery;

import java.time.LocalDate;
import persistence.HibernateUtil;

//Este archivo tiene como finalidad servir de ingreso a la aplicacion para ver los efectos generados en la base de datos

public class FastETestFile {

	public static void main(String[] args) {
        FastETestFile faste = new FastETestFile();

        faste.mappingTest();
        
        HibernateUtil.getSessionFactory().getCurrentSession().close();

	}

    private void mappingTest() {

    	//Instantiate a session 
    	Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        
        //Instantiate persistent objects 
        Customer pepe = Customer.register("pepe", "contraseña", "Pepe", "pepe@mail.com", LocalDate.now());
        Delivery jose = Delivery.register("josepe", "algo", "Jose", "jose@mail.com", LocalDate.now(), 10f);
        Address rivadavia = Address.registerAddress(1, "Rivadavia", "1570 piso '10' depto 'b' ", 20, 10);
        Provider cocaCola = Provider.register(3030123, "Coca-Cola", rivadavia);
        Product coca = Product.publishProduct("Coca", cocaCola, 1.0f, 15.0f);
        Product cindor = Product.publishProduct("Cindor", cocaCola, 1.0f, 20.0f);
        Order cokeOrder = pepe.makeAnOrder(coca, 1);
        Order cindorOrder = pepe.makeAnOrder(cindor, 10);
        DeliverOrder order = DeliverOrder.doneOrderDeliver(cindorOrder, jose);  
        DeliverOrder otherOrder = DeliverOrder.doneOrderDeliver(cokeOrder, jose);
        
        //Persist objects
        session.save(pepe);
        session.save(jose);
        session.save(rivadavia);
        session.save(cocaCola);
        coca.updatePrice(25.0f);
        coca.updatePrice(35.0f);
        coca.updatePrice(55.0f);
        cindor.updatePrice(25.0f);
        cindor.updatePrice(30.0f);
        cindor.updatePrice(40.0f);
        session.save(cindor);
        session.save(coca);
        
        session.save(cokeOrder);
        session.save(cindorOrder);
        
        session.save(order);
        session.save(otherOrder);
        
        Order dato = session.load(Order.class, Integer.toUnsignedLong(1));
        System.out.println("El estado de la orden " + dato.getOrderNumber() + " del cliente " 
        + dato.getCustomer().getUserName() + " de " + dato.getProduct().getName() + " por la cantidad de "
        		+ dato.getQuantity() + " es " + dato.getState().getName() + " y suma un total a pagar de "
        		+ dato.getTotalCost());
        
        session.getTransaction().commit();
    }

}

