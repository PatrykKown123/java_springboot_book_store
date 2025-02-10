package ca.sheridancollege.patrykkownacki.bookstore_assign1_kownacki.controllers;

import ca.sheridancollege.patrykkownacki.bookstore_assign1_kownacki.beans.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Random;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PageController {

    @Autowired
    private List<Book> bookList = new ArrayList<>();

    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/availablebooks")
    public String availablebooks() {
        return "availablebooks";
    }
    @PostMapping("/postNewBook")
    public String postNewBook(@RequestParam String bookTitle, @RequestParam String bookAuthor, @RequestParam Double bookPrice ) {
        Random random = new Random();
        bookList.add(new Book( String.valueOf(random.nextInt(900000) + 100000), bookTitle, bookAuthor, bookPrice));
        return "availablebooks";
    }
    @GetMapping("/shoppingbooks")
    public String shoppingbooks() {
        return "shoppingbooks";
    }
    @GetMapping("/checkout")
    public String checkout() {
        return "checkout";
    }
}
