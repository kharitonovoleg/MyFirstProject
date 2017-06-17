package by.dao.hibernate;

import by.model.Event;
import by.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class EventDaoHibernate {

    public void addEvent(Event event) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(event);
        session.getTransaction().commit();
        session.close();
    }

    public Event getEvent(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Event where id=:id");
        query.setInteger("id", id);
        Event event = (Event) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return event;
    }

    public List<Event> listEvent() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Event> list = session.createQuery("from Event ").list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public void updateEvent(Event event) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(event);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteEvent(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Event event = getEvent(id);
        session.delete(event);
        session.getTransaction().commit();
        session.close();
    }

}
