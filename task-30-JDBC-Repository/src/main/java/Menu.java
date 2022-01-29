import org.sqlite.SQLiteException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class Menu {

    private static final String SQLITE_CONNECTION_STRING = "jdbc:sqlite:sample.db";






    public void menu() {
        try (Connection connection = DriverManager.getConnection(SQLITE_CONNECTION_STRING)) {
            BookDao bookDao = new BookDao(connection);
            AuthorDao authorDao = new AuthorDao(connection);
            CommentDao commentDao = new CommentDao(connection);
            UserDao userDao = new UserDao(connection);
            LibraryMain libraryMain = new LibraryMain();
            SqlLibraryRepository sqlLibraryRepository = new SqlLibraryRepository(
                    bookDao, authorDao, commentDao, userDao);


        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\t 0 - Создать библиотеку");

            System.out.println("\t 11 - Записать книгу");
            System.out.println("\t 12 - Прочитать всю таблицу Books");
            System.out.println("\t 13 - Заменить книгу");
            System.out.println("\t 14 - Удалить книгу");

            System.out.println("\t 21 - Записать автора");
            System.out.println("\t 22 - Прочитать всю таблицу Authors");
            System.out.println("\t 23 - Заменить автора");
            System.out.println("\t 24 - Удалить автора");

            System.out.println("\t 31 - Записать комментарий");
            System.out.println("\t 32 - Прочитать всю таблицу Comments");
            System.out.println("\t 33 - Заменить комментарий");
            System.out.println("\t 34 - Удалить комментарий");

            System.out.println("\t 41 - Записать пользователя");
            System.out.println("\t 42 - Прочитать всю таблицу Users");
            System.out.println("\t 43 - Заменить пользователя");
            System.out.println("\t 44 - Удалить пользователя");



            System.out.println("\t Сделайте свой выбор:");
            String userInput = scanner.next();
            switch (userInput) {
                case "0":

                    break;
                case "11":
                    Book book = new Book();
                    Author author = new Author();
                    sqlLibraryRepository.saveBook(book, author);
                    return;
                case "12":
//                    createStudentsTable();
//                    break;
//                case 13:
//                    createNewStudentFromConsole();
//                    break;
//                case 14:
//                    readAllTable();
//                    break;
//                case "d":
//                    deleteStudentsTable();
//                    break;
//                case "ft":
//                    findText();
 //                   break;
                default:
                    System.out.println("Выбор не верный");
            }

        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
