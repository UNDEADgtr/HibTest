package by.undead.app.dao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dzmitry
 * Date: 16.01.13
 * Time: 16:48
 * To change this template use File | Settings | File Templates.
 */
public interface DAO<T> {
    T create(T transistObject) throws DaoException;

    T read(Integer id) throws DaoException;

    T readSQL(String query) throws DaoException;

    T load(Integer id) throws DaoException;

    T update(T transistObject) throws DaoException;

    void delete(Integer id) throws DaoException;

    List<T> readAll() throws DaoException;

    T createDelete(T transistObject) throws DaoException;
}
