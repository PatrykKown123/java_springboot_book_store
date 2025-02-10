package ca.sheridancollege.patrykkownacki.bookstore_assign1_kownacki.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class book {
    String bookISBN;
    String bookTitle;
    String bookAuthor;
    Double bookPrice;
}
