import com.sun.tools.javac.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class DaoMain {

    private static final String SQLITE_CONNECTION_STRING = "jdbc:sqlite:sample.db";

    public static void main(String[] args) {
        new DaoMain().run();
    }

    private void run() {
        try (Connection connection = DriverManager.getConnection(SQLITE_CONNECTION_STRING)){
            doSqlTasks(connection);
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("CREATE TABLE person(id INTEGER, varchar(100))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void doSqlTasks(Connection connection) {
        AuthorDao authorDao = new AuthorDao(connection);
        BookDao bookDao = new BookDao(connection);
        try {
            authorDao.createTable();
            Author author1 = new Author("Толкин", 1980);
            Author author2 = new Author("Страуструп", 1950);

            authorDao.insert(author1);
            System.out.println("author1: " + author1);
            authorDao.insert(author2);
            System.out.println("author2: " + author2);

            bookDao.createTable();

            Collection<Author> authors = authorDao.getAll();
            for (Author author : authors) {
                System.out.println("author: " + author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
