package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.entity.Supplier;
import com.example.demo.repository.IProductRepository;
import com.example.demo.repository.ISupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private IProductRepository iProductRepository;

    @Autowired
    private ISupplierRepository iSupplierRepository;

    @GetMapping("/products")
    public String GetProducts(Model model){
        try {
            List<Product> products = iProductRepository.findAll();
            model.addAttribute("products", products);
            return "Products/Products";
        }catch (Exception ex){
            return "error";
        }
    }

    @GetMapping("/products/new")
    public String GetShowCreateProduct(Model model){
        //consultar todos los proveedores
        List<Supplier> suppliers = iSupplierRepository.findAll();
        model.addAttribute("suppliers", suppliers);
        model.addAttribute("product", new Product());
        return "Products/Create";
    }

    @PostMapping("/products/save")
    public String SaveProduct(Product product){
        iProductRepository.save(product);
        return "redirect:/products";
    }

}
