package com.hard.core;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
            try {
                    // Create the SessionFactory from hibernate.cfg.xml
                    Configuration configuration = new Configuration();
                    configuration.configure();

                    sessionFactory = configuration.buildSessionFactory();
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

