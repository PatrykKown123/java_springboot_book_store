package ca.sheridancollege.patrykkownacki.bookstore_assign1_kownacki;

import ca.sheridancollege.patrykkownacki.bookstore_assign1_kownacki.beans.Book;
import ca.sheridancollege.patrykkownacki.bookstore_assign1_kownacki.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class BookstoreAssign1KownackiApplicationTests {

    @Autowired
    private BookService bookService;

    @BeforeEach
    public void setUp() {
        bookService.bookList().clear();
        bookService.bookList().add(new Book("123456", "The Great Gatsby", "F. Scott Fitzgerald", 10.99));
        bookService.bookList().add(new Book("234567", "1984", "George Orwell", 12.99));
        bookService.bookList().add(new Book("345678", "To Kill a Mockingbird", "Harper Lee", 14.99));
    }

    @Test
    void testAddBook() {
        Book newBook = new Book("456789", "Moby Dick", "Herman Melville", 16.99);

        bookService.bookList().add(newBook);

        assertEquals(4, bookService.bookList().size(), "Book count needs to be 4 after adding a new book.");
        assertTrue(bookService.bookList().contains(newBook), "Newly added book have to be in thelist.");
    }

    @Test
    void testCalculateTotalSum() {
        double expectedTotalSum = 10.99 + 12.99 + 14.99;

        double totalSum = bookService.bookList().stream().mapToDouble(Book::getBookPrice).sum();

        assertEquals(expectedTotalSum, totalSum, "Total sum of books have to be be calculated correctly.");
    }
}

