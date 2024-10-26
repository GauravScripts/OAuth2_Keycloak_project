package org.res.server.product_manager.services;

import org.res.server.product_manager.data.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {



    private List<Product> list = new ArrayList<>();

public ProductService() {
    list.add(Product.builder()
            .productId(UUID.randomUUID().toString())
            .productName("Product 1")
            .productDescription("Product 1 Description")
            .price("100")
            .build());

    list.add(Product.builder()
            .productId(UUID.randomUUID().toString())
            .productName("Product 2")
            .productDescription("Product 2 Description")
            .price("200")
            .build());

    list.add(Product.builder()
            .productId(UUID.randomUUID().toString())
            .productName("Product 3")
            .productDescription("Product 3 Description")
            .price("300")
            .build());
}

    public Product add(Product product) {
        product.setProductId(UUID.randomUUID().toString());
        list.add(product);
        return product;
    }

    //get all products
    public List<Product> getAllProducts() {
        return list;
    }

    public void deleteProduct(String productId) {
        list.removeIf(product -> product.getProductId().equals(productId));
    }
}
