public class Book {

    public int authorId;
    public String title;
    public int id;

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id = " + id +
                ", title'" + title + '\'' +
                ", authorId = " + authorId +
                '}';
    }
}
