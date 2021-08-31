package persistence;

import java.io.InputStream;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();
    							
    private static SessionFactory buildSessionFactory() {

    	final String propertiesURL = "hibernate.properties";

        InputStream inputStream = HibernateUtil.class.getClassLoader().getResourceAsStream(propertiesURL);

        Properties props = new Properties();

    	
        try {
            props.load(inputStream);

            Configuration configuration = new Configuration();
            configuration.setProperties(props);
            configuration.configure("hibernate.cfg.xml");

        	
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

}