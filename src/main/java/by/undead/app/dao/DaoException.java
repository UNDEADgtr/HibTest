package by.undead.app.dao;

/**
 * Created with IntelliJ IDEA.
 * User: Dzmitry
 * Date: 16.01.13
 * Time: 16:50
 * To change this template use File | Settings | File Templates.
 */
public class DaoException extends Exception {

    public DaoException(Exception e) {
        super(e.getMessage());
    }

    public DaoException(String message) {
        super(message);
    }
}
