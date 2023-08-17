package com.teknopar.northwind.model.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

//    @Column(name = "category_id")
//    private int categoryId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "unit_price")
    private double unitPrice;
    @Column(name = "units_in_stock")
    private short unitInStock;
    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;

    @ManyToOne()  //kategorinin ne olduğunu burada aldığımız için yukarıda tanımlanan category_id tanımlamasını kapattık
    @JoinColumn(name = "category_id")
    private Category category; //her bir ürünün tek bir tane kategorisi olduğundan List<> şeklinde bir tanımlama yapmadık

}
