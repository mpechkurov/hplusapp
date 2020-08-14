package com.test.hplus.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.hplus.beans.Product;
import com.test.hplus.repository.ProductRepository;

@Controller
public class SearchController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/search")
    public Callable<String> search(@RequestParam("search") String search, Model model, HttpServletRequest request) {
        System.out.println("I am in search controller");
        System.out.println("search criteria: " + search);
        System.out.println("Async supported in application:" + request.isAsyncSupported());
        System.out.println("Thread from the servlet container: " + Thread.currentThread().getName());

        return () -> {
            //Just to simulate delay of a blocked call 3 sec
            Thread.sleep(3000);
            System.out.println("Thread from the spring MVC task executor: " + Thread.currentThread().getName());
            List<Product> products = new ArrayList<>();
            products = productRepository.searchByName(search);
            model.addAttribute("products", products);
            return "search";
        };
    }
}
