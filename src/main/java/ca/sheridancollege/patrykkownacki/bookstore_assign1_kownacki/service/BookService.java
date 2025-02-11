package ca.sheridancollege.patrykkownacki.bookstore_assign1_kownacki.service;

import ca.sheridancollege.patrykkownacki.bookstore_assign1_kownacki.beans.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> bookList = new ArrayList<>();

    public BookService() {
        bookList.add(new Book("123456", "Effective Java", "Joshua Bloch", 45.50));
        bookList.add(new Book("234567", "Clean Code", "Robert C. Martin", 35.75));
        bookList.add(new Book("345678", "The Pragmatic Programmer", "Andrew Hunt", 42.80));
        bookList.add(new Book("456789", "Design Patterns", "Erich Gamma", 56.40));
        bookList.add(new Book("567890", "Java Concurrency in Practice", "Brian Goetz", 49.99));
        bookList.add(new Book("678901", "Head First Java", "Kathy Sierra", 29.99));
        bookList.add(new Book("789012", "Learning Python", "Mark Lutz", 60.00));
        bookList.add(new Book("890123", "The C Programming Language", "Brian W. Kernighan", 55.90));
        bookList.add(new Book("901234", "Refactoring", "Martin Fowler", 47.00));
        bookList.add(new Book("012345", "The Art of Computer Programming", "Donald E. Knuth", 75.50));
    }

    public List<Book> bookList() {
        return bookList;
    }
}


