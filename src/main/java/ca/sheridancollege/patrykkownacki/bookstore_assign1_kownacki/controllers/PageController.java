package ca.sheridancollege.patrykkownacki.bookstore_assign1_kownacki.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/availablebooks")
    public String availablebooks() {
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
