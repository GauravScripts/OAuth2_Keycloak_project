package org.res.server.product_manager.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private String productId;
    private String productName;
    private String productDescription;
    private String price;

}
