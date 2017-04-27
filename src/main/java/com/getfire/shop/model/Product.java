package com.getfire.shop.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product extends AbstractModel {
    @Column(name = "name")
    private String name;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "price")
    private int price;
    @Column(name = "description")
    private String description;
}
