package com.hassan.service;

import com.hassan.model.Shoe;
import com.hassan.repository.ShoeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShoeServiceMockito {

    private List<Shoe> shoeList = null;
    private List<Shoe> ListShoeBy40Size = null;
    private Shoe shoe = null;

    @Mock
    private ShoeRepository shoeRepository;

    @InjectMocks
    private ShoeService shoeService = new ShoeServiceImpl();

    @Before
    public void Setup(){
        shoeList = Arrays.asList(new Shoe("koid", 40,"koid Mark",140,"Red"),
                                 new Shoe("nike", 40,"Nike Mark",150,"Red"),
                                 new Shoe("Puma HiGu", 39,"Puma Mark",140,"Blue"),
                                 new Shoe("Bata", 41,"Bata Mark",100,"White"),
                                 new Shoe("Smart", 43,"Any Mark",170,"Green"));
        shoe = new Shoe("nike", 40,"Nike Mark",150,"Red");
        ListShoeBy40Size = Arrays.asList(new Shoe("koid", 40,"koid Mark",140,"Red"),
                new Shoe("nike", 40,"Nike Mark",150,"Red"));

    }

    @Test
    public void testGetAllShoes(){

        when(shoeRepository.findAll()).thenReturn(shoeList);
        assertThat(shoeList.size()).isEqualTo(5);
        assertThat(shoeService.getAll()).isNotEmpty();
        assertThat(shoeService.getAll().size()).isEqualTo(5);
    }

    @Test
    public void testAddNewShoe(){

        when(shoeRepository.saveAndFlush(shoe)).thenReturn(shoe);
        assertThat(shoeService.addShoe(shoe)).isNotNull();
        assertThat(shoeService.addShoe(shoe).getColor()).isEqualTo("Red");
        assertThat(shoeService.addShoe(shoe).getPrice()).isNotZero();
        assertThat(shoeService.addShoe(shoe).getPrice()).isEqualTo(150);
    }

    @Test
    public void testDeleteShoe(){

        assertThat(shoeService.deleteShoe(1L)).isNotNull();
        assertThat(shoeService.deleteShoe(1L)).isEqualTo(1L);
        assertThat(shoeService.deleteShoe(1L)).isNotZero();
        assertThat(shoeService.deleteShoe(1L)).isNotEqualTo(2L);
    }

    @Test
    public void testGetShoeById(){

        when(shoeRepository.findShoeByIdShoe(1L)).thenReturn(shoe);
        assertThat(shoeService.getShoeById(1L)).isNotNull();
        assertThat(shoeService.getShoeById(2L)).isNull();
        assertThat(shoeService.getShoeById(1L).getColor()).isEqualTo("Red");
        assertThat(shoeService.getShoeById(1L).getColor()).isNotEqualTo("Blue");
        assertThat(shoeService.getShoeById(1L).getPrice()).isNotEqualTo(100);
    }


    @Test
    public void testFindBySize(){

        when(shoeRepository.findAllBySize(40)).thenReturn(ListShoeBy40Size);
        assertThat(shoeRepository.findAllBySize(40)).isNotEmpty();
        assertThat(shoeRepository.findAllBySize(40).size()).isEqualTo(2);
        assertThat(shoeRepository.findAllBySize(40).get(0).getColor()).isEqualTo("Red");
        assertThat(shoeRepository.findAllBySize(40).get(0).getPrice()).isNotEqualTo(150);
        assertThat(shoeRepository.findAllBySize(40).get(1).getPrice()).isEqualTo(150);

    }
}
