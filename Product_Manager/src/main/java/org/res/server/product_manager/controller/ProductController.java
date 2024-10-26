package org.res.server.product_manager.controller;

import org.res.server.product_manager.data.Product;
import org.res.server.product_manager.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //create product
    @PostMapping("/add")
public Product addProduct(@RequestBody Product product) {
    return productService.add(product);
}

@GetMapping("/getAll")
//get all products
public List<Product> getAllProducts() {
    return productService.getAllProducts();
}

@DeleteMapping("/delete/{productId}")
//delete product
public void deleteProduct(@PathVariable String productId) {
    productService.deleteProduct(productId);
}
}
