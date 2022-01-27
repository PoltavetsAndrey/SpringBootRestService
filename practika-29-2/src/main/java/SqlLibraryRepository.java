import java.sql.SQLException;
import java.util.Collection;

public class SqlLibraryRepository implements ILibraryRepository {

    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final CommentDao commentDao;
    private final UserDao userDao;

    public SqlLibraryRepository(BookDao bookDao, AuthorDao authorDao, CommentDao commentDao, UserDao userDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.commentDao = commentDao;
        this.userDao = userDao;
    }

    @Override
    public Collection<Book> getAllBooks() {
        try {
            return bookDao.getAll();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch book", e);
        }
        //throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Author> getAllAuthors() {
        try {
            return authorDao.getAll();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch author", e);
        }
    }

    @Override
    public Collection<Comment> getAllComment() {
        try {
            return commentDao.getAll();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch comment", e);
        }

    }

    @Override
    public Collection<User> getAllUser() {
        try {
            return userDao.getAll();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch user", e);
        }
    }

    @Override
    public void saveAuthor(Author author) {
        try {
            if (author.id == 0) {
                authorDao.insert(author);
            } else {
                authorDao.update(author);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save author", e);
        }
    }

    @Override
    public void saveBook(Book book, Author author) {
        try {
            if (author.id == 0) {
                authorDao.insert(author);
            }
            book.authorId = author.id;
            bookDao.insert(book);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save book", e);
        }
    }

    @Override
    public void saveComment(Comment comment, Book book, User user) {
        try {
            if (book.id == 0) {
                bookDao.insert(book);
            }
            if (user.id == 0) {
                userDao.insert(user);
            }
            comment.bookId = book.id;
            comment.userId = user.id;
            commentDao.insert(comment);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save comment", e);
        }
    }

    @Override
    public void saveUser(User user) {
        try {
            if (user.id == 0) {
                userDao.insert(user);
            } else {
                userDao.update(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save user", e);
        }
    }

    @Override
    public Collection<Book> findBookByAuthorName(String name) {
// Поиск по имени автора без djoin
//        try {
//            Collection<Book> books = new ArrayList<>();
//            Collection<Author> authors = authorDao.findByName(name);
//            for (Author author : authors) {
//                Collection<Book> booksPerAuthor = bookDao.getBooksByAuthorId(author.id);
//                books.addAll(booksPerAuthor);
//            }
//            return books;
//        } catch (SQLException e) {
//            throw new RuntimeException("Failed to save book", e);
//        }

// Поиск по имени автора с использованием djoin
        try {
            return bookDao.findBooksByAuthorName(name);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find books", e);
        }
    }

    @Override
    public Collection<Author> findAuthorByBookTitle(String title) {
        try {
            return authorDao.findByBookTitle(title);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find books", e);
        }
    }

    @Override
    public Collection<Comment> findCommentByBookTitle(String name) {
        return null;
    }
}
