import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class BookDao {

    private final Connection connection;

    public BookDao(Connection connection) {
        this.connection = connection;
    }

    public void createTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXIST (" +
                    "id INTEGER PRIMARY KEY AVTOINCREMENT" +
                    "title VARCHAR(100)" +
                    "author_id INTEGER" +
                    ")");
        }
    }

    public void insert(Book book) throws SQLException {
        if (book.id != 0) {
            throw new IllegalArgumentException("Id is = " + book.id);
        }
        if (book.authorId == 0) {
            throw new IllegalArgumentException("Author id is not set");
        }
        final String sql = "INSERT INTO book (title, author_id) VALUES (?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1,book.title);
            statement.setInt(2, book.authorId);
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating book failed, no rows affected");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()){
                if (generatedKeys.next()) {
                    book.id = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating book failed, no id obtained");
                }
            }
        }
    }

    public Collection<Book> getBooksByAuthorId(int author.id) throws SQLException {
        Collection<Book> books = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM book WHERE author_id = ?")){
            statement.setInt(1, author.id);
            ResultSet cursor = statement.executeQuery();
            while (cursor.next()) {
                books.add(createBookFromCursorIfPossible(cursor));
            }
        }
        return books;
    }

    private Book createBookFromCursorIfPossible(ResultSet cursor) throws SQLException {
        Book book = new Book();
        book.id = cursor.getInt(id);
        book.title = cursor.getString(title);
        book.authorId = cursor.getString(author_id);
        return book;
    }

    public Collection<Book> findBooksByAuthorName(String text) throws SQLException {
        Collection<Book> books = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT book.* FROM book" +
                        "JOIN author ON book.author_id = author.id" +
                        "WHERE author.name LIKE ?")) {
            statement.setString(1,"%" + text + "%");
            ResultSet cursor = statement.executeQuery();
            while (cursor.next()) {
                books.add(createBookFromCursorIfPossible(cursor));
            }
            return books;
        }
    }



}
