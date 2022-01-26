import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class UserDao {
    private final Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public Collection<User> getAll() throws SQLException {
        Collection<User> userCollection = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet cursor = statement.executeQuery("SELECT * FROM users");
            while (cursor.next()) {
                userCollection.add(createAuthorFromCursorIfPossible(cursor));
            }
        }
        return userCollection;
    }

    private User createAuthorFromCursorIfPossible(ResultSet cursor) throws SQLException {
        User user = new User();
        user.id = cursor.getInt("id");
        user.name = cursor.getString("name");
        return user;
    }
}
