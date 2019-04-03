package com.hassan.repository;

import com.hassan.model.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository

public interface ShoeRepository extends CrudRepository<Shoe,Long> {


    List<Shoe> findAll();
    @Transactional
    Shoe saveAndFlush(Shoe shoe);
    @Transactional
    void deleteShoeByIdShoe(Long idShoe);
    Shoe findShoeByIdShoe(Long idShoe);
    List<Shoe> findAllBySize(Integer size);
}
