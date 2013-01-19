package by.undead.app.dao;

import by.undead.app.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dzmitry
 * Date: 16.01.13
 * Time: 17:17
 * To change this template use File | Settings | File Templates.
 */
public class BaseDao<T> implements DAO<T> {

    private Class cl;

    private HibernateUtil util = HibernateUtil.getInst();

    public BaseDao(Class<T> cl) {
        this.cl = cl;
    }

    @Override
    public T create(T transistObject) throws DaoException {
        Session session = util.getSession();
        Transaction tr = session.beginTransaction();
        try {
            session.save(transistObject);
            tr.commit();
        } catch (HibernateException ex) {
            tr.rollback();
            throw new DaoException(ex);
        }

        return transistObject;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T read(Integer id) throws DaoException {
        Session session = util.getSession();
        Transaction trans = session.beginTransaction();
        T t;
        try {
            t = (T) session.get(cl, id);
            trans.commit();
        } catch (HibernateException ex) {
            trans.rollback();
            throw new DaoException(ex);
        }
        return t;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T readSQL(String query) throws DaoException {
        Session session = util.getSession();
        Transaction trans = session.beginTransaction();
        T t;
        try {
            //t = (T) session.createSQLQuery(query).addEntity(cl);
            t = (T) session.createSQLQuery(query).list().get(0);
            trans.commit();
        }   catch (HibernateException ex){
            trans.rollback();
            throw new DaoException(ex);

        }
        return t;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T load(Integer id) throws DaoException {
        Session session = util.getSession();
        Transaction trans = session.beginTransaction();
        T t;
        try {
            t = (T) session.load(cl, id);
            trans.commit();
        } catch (HibernateException ex) {
            trans.rollback();
            throw new DaoException(ex);
        }
        return t;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T update(T transistObject) throws DaoException {
        Session session = util.getSession();
        Transaction trans = session.beginTransaction();
        try {
            session.saveOrUpdate(transistObject);
            trans.commit();
        } catch (HibernateException ex) {
            trans.rollback();
            throw new DaoException(ex);
        }
        return transistObject;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(Integer id) throws DaoException {
        Session session = util.getSession();
        Transaction trans = session.beginTransaction();
        try {
            session.delete(session.get(cl, id));
            trans.commit();
        }   catch (HibernateException ex){
            trans.rollback();
            throw new DaoException(ex);
        }
    }

    @Override
    public List<T> readAll() throws DaoException {
        Session session = util.getSession();
        Transaction trans = session.beginTransaction();
        List<T> list = new ArrayList<T>();
        try {
            list = session.createCriteria(cl).list();
            trans.commit();
        }   catch (HibernateException ex){
            trans.rollback();
            throw new DaoException(ex);
        }
        return list;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T createDelete(T transistObject) throws DaoException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
