package ca.sheridancollege.patrykkownacki.bookstore_assign1_kownacki.controllers;

import ca.sheridancollege.patrykkownacki.bookstore_assign1_kownacki.beans.Book;
import ca.sheridancollege.patrykkownacki.bookstore_assign1_kownacki.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Random;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PageController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/availablebooks")
    public String availablebooks(Model model) {
        model.addAttribute("books", bookService.bookList());
        return "availablebooks";
    }
    @PostMapping("/postNewBook")
    public String postNewBook(@RequestParam String bookTitle, @RequestParam String bookAuthor, @RequestParam Double bookPrice ) {
        Random random = new Random();
        bookService.bookList().add(new Book(String.valueOf(random.nextInt(900000) + 100000), bookTitle, bookAuthor, bookPrice));
        System.out.println(bookService.bookList());
        return "redirect:/availablebooks";
    }
    @GetMapping("/addToCart/{bookPrice}")
    public String addToCart(@PathVariable Double bookPrice) {
        System.out.println("Book with price " + bookPrice + " added to cart.");
        return "redirect:/shoppingbooks";
    }
    @GetMapping("/shoppingbooks")
    public String shoppingbooks(Model model) {
        model.addAttribute("books", bookService.bookList());
        return "shoppingbooks";
    }
    @GetMapping("/checkout")
    public String checkout() {
        return "checkout";
    }
}
