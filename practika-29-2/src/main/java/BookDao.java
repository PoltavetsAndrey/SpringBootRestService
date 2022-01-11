import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
}
