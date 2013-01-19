import by.undead.app.dao.DAO;
import by.undead.app.dao.BaseDao;
import by.undead.app.dao.DaoException;
import by.undead.app.entity.Book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dzmitry
 * Date: 18.01.13
 * Time: 12:01
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    private DAO bookDAO;

    public Main() {
        bookDAO = new BaseDao(Book.class);
    }

    public static void main(String[] args) throws IOException, DaoException {
        Main m = new Main();
        m.CreatePerson();
    }

    public void CreatePerson() throws IOException, DaoException {
        Book book = new Book();

        //book.setTitle("Золотая рыбка");
        //book.setAuthor("Пушкин");

        //bookDAO.create(book);

        //int id = 2;
        String query = "Select * from t_book where id=1";
        book = (Book) bookDAO.readSQL(query);
        //book.setTitle("Лермонтов");
        //bookDAO.update(book);
        //bookDAO.delete(2);
        //book = (Book) bookDAO.load(id);
        //List<Book> list = new ArrayList<Book>();
        //list = (ArrayList<Book>) bookDAO.readAll();

        //for(Book book : list){
        System.out.println("Извлекли книгу " + book.getTitle());
        System.out.println("автора " + book.getAuthor());
        //}
        //bookDAO.
    }


}
