package com.hassan.service;

import com.hassan.model.Shoe;

import java.util.List;

public interface ShoeService {

    List<Shoe> getAll();
    Shoe addShoe(Shoe shoe);
    Long deleteShoe(Long  idShoe);
    Shoe updateShoe(Shoe shoe);
    Shoe shoeFound(Long id);
    List<Shoe> findBySize(Integer size);
    List<Shoe> findByColor(String color);
}
