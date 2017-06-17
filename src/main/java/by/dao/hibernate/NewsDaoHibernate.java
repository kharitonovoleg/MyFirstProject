package by.dao.hibernate;


import by.model.News;
import by.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class NewsDaoHibernate {

    public void addNews(News news) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(news);
        session.getTransaction().commit();
        session.close();
    }

    public News getNews(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from News where id=:id");
        query.setInteger("id", id);
        News news = (News) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return news;
    }

    public List<News> listNews() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<News> list = session.createQuery("from News ").list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public void updateNews(News news) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(news);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteNews(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        News news = getNews(id);
        session.delete(news);
        session.getTransaction().commit();
        session.close();
    }

}
