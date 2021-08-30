import org.hibernate.Session;

import model.*;
import persistence.HibernateUtil;

public class FastE {

	public static void main(String[] args) {
        FastE faste = new FastE();

        HibernateUtil.getSessionFactory().openSession();

        faste.mappingTest();
        
        HibernateUtil.getSessionFactory().getCurrentSession().close();

	}

    private void mappingTest() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        //Customer pepe = Customer.register("usuario", "contraseña", "Pepe", "pepe@mail.com", LocalDate.now());
//        Delivery jose = Delivery.register("josepe", "algo", "Jose", "jose@mail.com", LocalDate.now());
        Provider cocaCola = Provider.register("Coca-Cola", 3030123, "calle falsa 123", 0, 10);
//        Product coca = Product.publishProduct("coca", cocaCola, 1.0f, 50.0f);
//        pepe.makeAnOrder(0, 1, coca);

        session.save(cocaCola);
        
        session.getTransaction().commit();
    }

}

