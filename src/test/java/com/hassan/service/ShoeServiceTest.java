package com.hassan.service;

import com.hassan.model.Shoe;
import com.hassan.repository.ShoeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ShoeServiceTest {

    @Autowired
    private ShoeRepository shoeRepository;

    /**
     * This test will check if
     * findAll method can get all elements
     * from data base and test the result
     *
     */

  /*  @Test
    public void can_get_all(){

       assertThat(shoeRepository.findAll()).isNotEmpty();
       assertThat(shoeRepository.findAll()).isNotNull();
       assertThat(shoeRepository.findAll().size()).isNotZero();
    }*/

    /**
     * can_save_shoe method tests
     * the save method of ShoeRepository
     * and check the insertion is done or not
     */

/*    @Test
    public void can_save_shoe(){

        Shoe shoe = new Shoe("coco",14,"clccl",41,"red");
        assertThat(shoeRepository.saveAndFlush(shoe)).isNotNull();
        assertThat(shoeRepository.saveAndFlush(shoe).getIdShoe()).isNotNull();
    }*/

}
