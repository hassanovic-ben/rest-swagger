package com.hassan.service;

import com.hassan.model.Shoe;
import com.hassan.repository.ShoeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShoeServiceImpl implements ShoeService {

    private static final String CLASSENAME = "ShoeServiceImpl";

    @Autowired
    private ShoeRepository shoeRepository;

    @Override
    public List<Shoe> getAll() {

        try {
            List<Shoe> shoes = shoeRepository.findAll();
            return shoes;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Shoe addShoe(Shoe shoe) {

        try {
            Shoe shoeSaved = shoeRepository.saveAndFlush(shoe);
            return shoeSaved;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Long deleteShoe(Long idShoe) {

        try {
            shoeRepository.deleteShoeByIdShoe(idShoe);
            return idShoe;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Shoe updateShoe(Shoe shoe) {

        try {
            Shoe shoeInDB = shoeRepository.findShoeByIdShoe(shoe.getIdShoe());
            Shoe shoeUpdated = mapShoeFoundByShoeInParameter(shoe, shoeInDB);
            Shoe updatedShoe = shoeRepository.saveAndFlush(shoeUpdated);
            return updatedShoe;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Shoe getShoeById(Long id) {

        try {
            Shoe shoeByIdShoe = shoeRepository.findShoeByIdShoe(id);
            return shoeByIdShoe;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Shoe> findBySize(Integer size) {
        try {
            List<Shoe> allBySize = shoeRepository.findAllBySize(size);
            return allBySize;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Shoe> findByColor(String color) {

        try {
            List<Shoe> byColor = shoeRepository.findByColor(color);
            return byColor;
        } catch (Exception e) {
            return null;
        }
    }

    private Shoe mapShoeFoundByShoeInParameter(Shoe shoe, Shoe shoeInDB) {

        try {
            shoeInDB.setBrand(shoe.getBrand());
            shoeInDB.setColor(shoe.getColor());
            shoeInDB.setName(shoe.getName());
            shoeInDB.setPrice(shoe.getPrice());
            shoeInDB.setSize(shoe.getSize());
            return shoeInDB;
        } catch (Exception ex) {
            return null;
        }
    }

}
