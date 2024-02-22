package items;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Книга '" + book.getType() + "' добавлена в библиотеку.");
    }

    public void removeBook(Book book) {
        if (books.contains(book)) {
            books.remove(book);
            System.out.println("Книга '" + book.getType() + "' удалена из библиотеки.");
        } else {
            System.out.println("Книга '" + book.getType() + "' отсутствует в библиотеке.");
        }
    }
    public void manageBooks() {
        BookManager bookManager = new BookManager();
        bookManager.displayAllBooks();
    }
    // Локальный класс
    public class BookManager {
        public void displayAllBooks() {
            System.out.println("Список книг в библиотеке:");
            for (Book book : books) {
                System.out.println(book.getType());
            }
        }
    }
}
