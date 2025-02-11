package ca.sheridancollege.patrykkownacki.bookstore_assign1_kownacki.controllers;

import ca.sheridancollege.patrykkownacki.bookstore_assign1_kownacki.beans.Book;
import ca.sheridancollege.patrykkownacki.bookstore_assign1_kownacki.service.BookService;
import jakarta.servlet.http.HttpSession;
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

    int bookCounter= 0;
    double sum = 0.0;

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
    public String addToCart(@PathVariable Double bookPrice, HttpSession session) {
        bookCounter++;
        sum += bookPrice;
        session.setAttribute("bookCounter", bookCounter);
        session.setAttribute("bookSum", sum);
        //System.out.println("Total amount of books:  " + bookCounter + " sum: " + sum);
        return "redirect:/shoppingbooks";
    }
    @GetMapping("/shoppingbooks")
    public String shoppingbooks(Model model, HttpSession session) {
        Integer bookCounter = (Integer) session.getAttribute("bookCounter");
        if (bookCounter == null) {
            bookCounter = 0;
        }
        model.addAttribute("books", bookService.bookList());
        model.addAttribute("bookCounter", bookCounter);
        return "shoppingbooks";
    }
    @GetMapping("/checkout")
    public String checkout(Model model,HttpSession session) {
        Double bookSum = (Double) session.getAttribute("bookSum");
        double tax = bookSum*0.13;
        double totalSum = bookSum + tax;
        model.addAttribute("books", bookService.bookList());
        model.addAttribute("bookSum", bookSum);
        model.addAttribute("tax", tax);
        model.addAttribute("totalSum", totalSum);
        return "checkout";
    }
}
