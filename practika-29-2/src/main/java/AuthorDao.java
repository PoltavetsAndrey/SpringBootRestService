import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class AuthorDao {

    private final Connection connection;

    public AuthorDao(Connection connection) {
        this.connection = connection;
    }

    public void createTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE author (" +
                "id INTEGER PRIMARY KEY AVTOINCREMENT" +
                "name VARCHAR(100)" +
                "birth_year INTEGER" +
                ")");
    }

    public Collection<Author> getAll() throws SQLException {
        Collection<Author> authors = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet cursor = statement.executeQuery("SELECT * FROM author");
            if (cursor.next()) {
                return (authors.add(createAuthorFromCursorIfPossible(cursor));
            }
        }
        return authors;
    }

    public Optional<Author> getById(int id) throws SQLException {
        Collection<Author> authors = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet cursor = statement.executeQuery(String.format(
                    "SELECT * FROM author WHERE id = %d", id));
            if (cursor.next()) {
                return Optional.of(authors.add(createAuthorFromCursorIfPossible(cursor));
            } else {
                return Optional.empty();
            }
        }
    }

    public Collection<Author> findByName() throws SQLException {
        Collection<Author> authors = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet cursor = statement.executeQuery("SELECT * FROM author WHERE NAME LIKE '%s', text");
            if (cursor.next()) {
                return (authors.add(createAuthorFromCursorIfPossible(cursor));
            }
        }
        return authors;
    }

    private Author createAuthorFromCursorIfPossible(ResultSet cursor) throws SQLException {
        Author author = new Author();
    }
}
