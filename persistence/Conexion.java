package persistence;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Leandro Quiroga
 */
public class Conexion {

    private static SessionFactory sessionFactory;

    private static void createSessionFactory() {
    	Logger logger = Logger.getLogger(Conexion.class);
    	logger.info("CreandoSessionFactory");
        final String propertiesURL = "hibernate.biblioteca.properties";

        InputStream inputStream = Conexion.class.getClassLoader().getResourceAsStream(propertiesURL);

        Properties props = new Properties();
        try {
            props.load(inputStream);

            Configuration configuration = new Configuration();
            configuration.setProperties(props);
            configuration.configure("hibernate.biblioteca.cfg.xml");

//            new SchemaUpdate(configuration).execute(true, true);
//            new SchemaExport(configuration).create(true, true);

            sessionFactory = configuration.buildSessionFactory();
        } catch (IOException e) {
            Logger.getLogger(Conexion.class).error("", e);
        } catch (MappingException e1) {
            Logger.getLogger(Conexion.class).error("", e1);
        } catch (HibernateException e2) {
            Logger.getLogger(Conexion.class).error("", e2);
        }
    }

    public static Session getSession() throws HibernateException {
        if (sessionFactory == null) {
            createSessionFactory();
        }
        return sessionFactory.openSession();
    }
}