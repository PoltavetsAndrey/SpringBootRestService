import org.sqlite.SQLiteException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

public class LibraryMain {

    private static final String SQLITE_CONNECTION_STRING = "jdbc:sqlite:sample.db";

    public static void main(String[] args) {
        new LibraryMain().run();
    }

    private void run() {
        try (Connection connection = DriverManager.getConnection(SQLITE_CONNECTION_STRING)) {
            doSqlTasks(connection);
        } catch (SQLiteException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void doSqlTasks(Connection connection) throws SQLException {
        ILibraryRepository repository = initializeLibrary(connection);

        Author author1 = new Author("Толкин", 1980);
        Author author2 = new Author("Страуструп", 1950);
        repository.saveBook(new Book("Властелин колец: 1"), author1);
        repository.saveBook(new Book("Властелин колец: 2"), author1);
        repository.saveBook(new Book("C++"), author2);

        Collection<Book> books = repository.findBookByAuthorName("и");


        System.out.println(books);
    }

    private ILibraryRepository initializeLibrary(Connection connection) throws SQLException {
        BookDao bookDao = new BookDao(connection);
        AuthorDao authorDao = new AuthorDao(connection);
        CommentDao commentDao = new CommentDao(connection);
        UserDao userDao = new UserDao(connection);

        bookDao.createTable();
        authorDao.createTable();

        return new SqlLibraryRepository(bookDao, authorDao, commentDao, userDao);
    }
}
