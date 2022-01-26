import java.util.Collection;

public interface ILibraryRepository {

    Collection<Book> getAllBooks();

    Collection<Author> getAllAuthors();

    Collection<Comment> getAllComment();

    Collection<User> getAllUser();

    void saveAuthor(Author author);

    void saveBook(Book book, Author author);

    void saveComment(Comment comment);

    void saveUser(User user);

    /**
     * ищет все книги, имя автора включает заданный текст имени
     *
     * @param name Текст имени для частичного поиска
     * @return коллекция заданных книг
     */

    Collection<Book> findBookByAuthorName(String name);

    Collection<Author> findAuthorByBookTitle(String name);
}
