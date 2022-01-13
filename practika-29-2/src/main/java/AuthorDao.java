import java.sql.*;
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
                authors.add(createAuthorFromCursorIfPossible(cursor));
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
                return Optional.of(authors.add(createAuthorFromCursorIfPossible(cursor)));
            } else {
                return Optional.empty();
            }
        }
    }

    public Collection<Author> findByName() throws SQLException {
        Collection<Author> authors = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet cursor = statement.executeQuery("SELECT * FROM author " +
                    "WHERE NAME LIKE '%%%s%%', text");
            if (cursor.next()) {
                authors.add(createAuthorFromCursorIfPossible(cursor));
            }
        }
        return authors;
    }

    private Author createAuthorFromCursorIfPossible(ResultSet cursor) throws SQLException {
        Author author = new Author();
        author.id = cursor.getInt("id");
        author.name = cursor.getString("name");
        author.birthYear = cursor.getInt("birth_year");
        return author;
    }

    public void update(Author author) throws SQLException {
        String sql = "UPDATE author SET name = ?, birth_year = ?" +
                "WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, author.name);
            statement.setInt(2, author.birthYear);
            statement.setInt(3, author.id);

            statement.executeUpdate();
                    String.format("SELECT FROM author" +
                            "WHERE name LIKE '%%%s%%' ", text));
            while (cursor.next()) {

            }
            )
        }
    }

    public void insert(Author author) throws SQLException {
        if (author.id != 0) {
            throw new IllegalArgumentException("ID is: ", author.id);
        }
        final String sql = "INSERT INTO author (name, birth_year) VALUES (?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, author.name);
            statement.setInt(2, author.birthYear);
            statement.executeUpdate();
        }

    }
}
