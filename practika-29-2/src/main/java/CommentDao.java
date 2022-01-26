import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}
