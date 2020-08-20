package com.test.hplus.restcontroler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.hplus.beans.Product;
import com.test.hplus.repository.ProductRepository;

@RestController
public class ProductsRestController {

    @Autowired
    private ProductRepository productRepository;

    /*@GetMapping("/hplus/rest/products")
    @ResponseBody
    public List<Product> getProducts() {
        //call product repository to get data
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(product -> products.add(product));
        return products;
    }*/

    // Will accept request param
    //    http://localhost:8080/hplus/rest/products?name=water
    @GetMapping("/hplus/rest/products")
    public ResponseEntity getProductsByRequestParam(@RequestParam("name") String name) {
        List<Product> products = productRepository.searchByName(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Will accept path variable
    //    http://localhost:8080/hplus/rest/products/water
    @GetMapping("/hplus/rest/products/{name}")
    public ResponseEntity getProductsByPathVariable(@PathVariable("name") String name) {
        List<Product> products = productRepository.searchByName(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
