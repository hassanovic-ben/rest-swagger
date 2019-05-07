package com.hassan.repository;

import com.hassan.model.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ShoeRepository extends JpaRepository<Shoe,Long> {

    List<Shoe> findAll();
    Shoe saveAndFlush(Shoe shoe);
    void deleteShoeByIdShoe(Long idShoe);
    Shoe findShoeByIdShoe(Long idShoe);
    List<Shoe> findAllBySize(Integer size);
    List<Shoe> findAllByColor(String color);
}
