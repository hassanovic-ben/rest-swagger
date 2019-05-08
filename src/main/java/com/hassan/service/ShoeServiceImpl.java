package com.hassan.service;

import com.hassan.model.Shoe;
import com.hassan.repository.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShoeServiceImpl implements ShoeService {

    @Autowired
    private ShoeRepository shoeRepository;

    @Override
    public List<Shoe> getAll() {
        return shoeRepository.findAll();
    }

    @Override
    public Shoe addShoe(Shoe shoe) {
        return shoeRepository.saveAndFlush(shoe);
    }

    @Override
    public Long deleteShoe(Long  idShoe) {
        shoeRepository.deleteShoeByIdShoe(idShoe);
        return idShoe;
    }

    @Override
    public Shoe updateShoe(Shoe shoe) {
        Shoe shoeInDB = shoeRepository.findShoeByIdShoe(shoe.getIdShoe());
        Shoe shoeUpdated = mapShoeFoundByShoeInParameter(shoe, shoeInDB);
        return shoeRepository.saveAndFlush(shoeUpdated);
    }

    @Override
    public Shoe getShoeById(Long id) {
        return shoeRepository.findShoeByIdShoe(id);
    }

    @Override
    public List<Shoe> findBySize(Integer size) {
        return shoeRepository.findAllBySize(size);
    }

    @Override
    public List<Shoe> findByColor(String color) {
        return shoeRepository.findByColor(color);
    }

    private Shoe mapShoeFoundByShoeInParameter(Shoe shoe, Shoe shoeInDB) {
        shoeInDB.setBrand(shoe.getBrand());
        shoeInDB.setColor(shoe.getColor());
        shoeInDB.setName(shoe.getName());
        shoeInDB.setPrice(shoe.getPrice());
        shoeInDB.setSize(shoe.getSize());
        return shoeInDB;
    }
}
