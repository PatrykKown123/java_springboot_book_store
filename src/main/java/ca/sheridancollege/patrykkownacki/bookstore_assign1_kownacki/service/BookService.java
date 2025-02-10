package ca.sheridancollege.patrykkownacki.bookstore_assign1_kownacki.service;

import ca.sheridancollege.patrykkownacki.bookstore_assign1_kownacki.beans.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> bookList = new ArrayList<>();

    public List<Book> bookList() {
        return bookList;
    }
}
