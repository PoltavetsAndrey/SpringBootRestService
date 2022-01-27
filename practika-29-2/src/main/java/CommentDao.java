import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class CommentDao {

    private final Connection connection;

    public CommentDao(Connection connection) {
        this.connection = connection;
    }

    public Collection<Comment> getAll() throws SQLException {
        Collection<Comment> commentCollection = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet cursor = statement.executeQuery("SELECT * FROM comments");
            while (cursor.next()) {
                commentCollection.add(createCommentFromCursorIfPossible(cursor));
            }
        }
        return commentCollection;
    }

    private Comment createCommentFromCursorIfPossible(ResultSet cursor) throws SQLException {
        Comment comment = new Comment();
        comment.textComment = cursor.getString("textComment");
        comment.id = cursor.getInt("id");
        comment.bookId = cursor.getInt("bookId");
        comment.userId = cursor.getInt("userId");
        return comment;
    }

    public void insert(Comment comment) throws SQLException {
        if (comment.id != 0) {
            throw new IllegalArgumentException("ID is: " + comment.id);
        }
        final String sql = "INSERT INTO comments (textComment, bookId, userId) VALUES (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, comment.textComment);
            statement.setInt(2, comment.bookId);
            statement.setInt(3, comment.userId);
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating comment failed, no rows affected");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()){
                if (generatedKeys.next()) {
                    comment.id = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating comment failed, no ID obtained");
                }
            }
        }
    }
}
