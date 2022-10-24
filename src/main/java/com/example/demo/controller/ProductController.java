package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private IProductRepository iProductRepository;

    @GetMapping("/products")
    public String GetProducts(Model model){
        try {
            List<Product> products = iProductRepository.findAll();
            //model.addAttribute("products", products);
            return "Products/Products";
        }catch (Exception ex){
            return "error";
        }
    }

}
