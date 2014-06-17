package com.hard.core.hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
            try {
                    Configuration configuration = new Configuration();
                    configuration.configure("hibernate.cfg.xml");
                    ServiceRegistryBuilder ssrb = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
                    sessionFactory = configuration.buildSessionFactory(ssrb.buildServiceRegistry());
                
                    
            } catch (Throwable ex) {
                    // Make sure you log the exception, as it might be swallowed
                    System.err.println("Initial SessionFactory creation failed." + ex);
                    throw new ExceptionInInitializerError(ex);
            }
    }

    public static SessionFactory getSessionFactory() {
            return sessionFactory;
    }

    public static void closeSessionFactory() {
    if (sessionFactory != null)
        sessionFactory.close();
}
}

