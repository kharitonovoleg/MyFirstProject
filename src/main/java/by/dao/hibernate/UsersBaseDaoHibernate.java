package by.dao.hibernate;


import by.model.UsersBase;
import by.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class UsersBaseDaoHibernate {

    public void addUsersBase(UsersBase usersBase) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(usersBase);
        session.getTransaction().commit();
        session.close();
    }

    public UsersBase getUsersBase(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from UsersBase where id=:id");
        query.setInteger("id", id);
        UsersBase usersBase = (UsersBase) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return usersBase;
    }

    public List<UsersBase> listUsersBase() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<UsersBase> list = session.createQuery("from UsersBase ").list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public void updateUsersBase(UsersBase usersBase) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(usersBase);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteUsersBase(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        UsersBase usersBase = getUsersBase(id);
        session.delete(usersBase);
        session.getTransaction().commit();
        session.close();
    }

}
