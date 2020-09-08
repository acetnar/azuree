package pl.sda.final_project.model.product;

import pl.sda.final_project.model.user.BaseEntity;

import java.math.BigDecimal;

public class Product extends BaseEntity {

    private String title;
    private String description;
    private String imageUrl;
    private ProductCategoryEntity category;
    private BigDecimal price;
    private ProductType productType;
    private AuthorEntity author;

}
