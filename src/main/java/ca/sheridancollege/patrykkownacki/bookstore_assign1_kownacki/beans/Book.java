package ca.sheridancollege.patrykkownacki.bookstore_assign1_kownacki.beans;

import lombok.Data;
import org.springframework.stereotype.Component;


@Data
public class Book {
    private String bookISBN;
    private String bookTitle;
    private String bookAuthor;
    private Double bookPrice;

    public Book(String bookISBN, String bookTitle, String bookAuthor, Double bookPrice) {
        this.bookISBN = bookISBN;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
    }
}
