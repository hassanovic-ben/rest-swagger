package com.hassan.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ApiModel(description = "All details about the Shoe. ")
public class Shoe {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated shoe ID")
    private Long idShoe;
    @ApiModelProperty(notes = "The shoe name")
    private String name;
    @ApiModelProperty(notes = "The size of the shoe")
    private Integer size;
    @ApiModelProperty(notes = "The brand of the shoe")
    private String brand;
    @ApiModelProperty(notes = "The color of the shoe")
    private String color;
    @ApiModelProperty(notes = "The price of the shoe")
    private Integer price;

    public Shoe() {
    }

    public Shoe(String name, Integer size, String brand, Integer price, String color) {

        this.name = name;
        this.size = size;
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    public Long getIdShoe() {
        return idShoe;
    }

    public void setIdShoe(Long idShoe) {
        this.idShoe = idShoe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
