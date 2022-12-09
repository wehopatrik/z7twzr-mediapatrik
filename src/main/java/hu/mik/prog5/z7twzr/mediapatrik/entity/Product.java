package hu.mik.prog5.z7twzr.mediapatrik.entity;

import lombok.Data;

@Data
public class Product {

    private Long id;
    private String name;
    private int price;
    private String imageName;
    private ProductType productType;


}
