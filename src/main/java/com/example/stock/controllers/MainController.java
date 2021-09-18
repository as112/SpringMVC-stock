package com.example.stock.controllers;

import com.example.stock.models.Product;
import com.example.stock.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @PostMapping("/")
    public String authorization(@RequestParam String categoryName,
                                @RequestParam String description,
                                @RequestParam int balance, Model model) throws Exception {
        Product product = productRepository.findByDescription(description).orElseThrow(() -> new Exception());
        int oldBalance;
        oldBalance = product.getBalance();
        product.setBalance(oldBalance - balance);
        model.addAttribute("balance", oldBalance);
        model.addAttribute("count", balance);
        model.addAttribute("product", product);
        productRepository.save(product);
        return "answer";
    }
}
