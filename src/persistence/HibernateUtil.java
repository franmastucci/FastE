package persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();
    							
    private static SessionFactory buildSessionFactory() {
    	
        try {

            Configuration configuration = new Configuration();
            configuration.configure();

            // Create the SessionFactory from hibernate.cfg.xml
            return configuration.buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void persist(Object anObject) {
    	Session session = sessionFactory.openSession();
    	
    	session.beginTransaction();
    	session.save(anObject);
    	
    	session.getTransaction().commit();
    	
    }
    
//    public static void persistUserEncryptingPassword(User anUser, String toEncrypt) {
//    	User toModifyUser = anUser;
//    	
//    	
//    }
    
}