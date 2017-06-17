package by.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

//    Hibernate создал автоматически такой метод
//    public static Session getSession() throws HibernateException {
//        return ourSessionFactory.openSession();
//    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
