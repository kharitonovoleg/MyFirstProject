package by.dao.hibernate;


import by.model.UserEvent;
import by.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class UserEventDaoHibernate {

    public void addUserEvent(UserEvent userEvent) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(userEvent);
        session.getTransaction().commit();
        session.close();
    }

    public UserEvent getUserEvent(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from UserEvent where id=:id");
        query.setInteger("id", id);
        UserEvent userEvent = (UserEvent) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return userEvent;
    }

    public List<UserEvent> listUserEvent() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<UserEvent> list = session.createQuery("from UserEvent ").list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public void updateUserEvent(UserEvent userEvent) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(userEvent);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteUserEvent(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        UserEvent userEvent = getUserEvent(id);
        session.delete(userEvent);
        session.getTransaction().commit();
        session.close();
    }

}
