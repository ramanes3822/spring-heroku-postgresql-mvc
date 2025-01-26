package com.ram.productDemo.control;

import com.ram.productDemo.model.Product;
import com.ram.productDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@SuppressWarnings("unused")
public class ProductController {

    @Autowired
    ProductService prodservice;

    @GetMapping("/products")
    public List<Product> getProduct(){
        return prodservice.getProduct();
    }

    @GetMapping("/product/{prodId}")
    public Optional<Product> getProductById(@PathVariable int prodId){
        return prodservice.getProductById(prodId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product prod){
        prodservice.addProduct(prod);
    }

    @PutMapping("/update-product")
    public Product updateProduct(@RequestBody Product prod){
        return prodservice.updateProduct( prod );
    }

    @DeleteMapping("/product/{prodId}")
    public void deleteProduct(@PathVariable int prodId){
        prodservice.deleteProduct(prodId);
    }

}
