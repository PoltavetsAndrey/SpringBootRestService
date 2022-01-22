import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class SqlLibraryRepository implements ILibraryRepository {

    private final BookDao bookDao;
    private final AuthorDao authorDao;

    public SqlLibraryRepository(BookDao bookDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
    }

    @Override
    public Collection<Book> getAllBooks() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Author> getAllAuthors() {
        try {
            return authorDao.getAll();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch authors", e);
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
}
