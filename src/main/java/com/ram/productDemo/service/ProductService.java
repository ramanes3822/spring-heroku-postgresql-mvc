package com.ram.productDemo.service;

import com.ram.productDemo.model.Product;
import com.ram.productDemo.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    public List<Product> getProduct(){
        List<Product> allProduct = repo.findAll();
        System.out.println(allProduct);
        return allProduct;
    }

    public Optional<Product> getProductById(int prodId) {
        return repo.findById(prodId);
    }

    public void addProduct(Product prod){
        repo.save(prod);
    }

    public  Product updateProduct(Product prod){
        if (repo.existsById(prod.getId())) {
            return repo.save(prod);
        } else {
            throw new RuntimeException("Product not found for update");
        }

    }

    public void deleteProduct(int prodId){
        repo.deleteById(prodId);
    }
}
