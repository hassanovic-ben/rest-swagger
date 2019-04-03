package com.hassan.restController;

import com.hassan.model.Shoe;
import com.hassan.service.ShoeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Api(value="Shoes Management System", description="Management of the shoes into management system")
public class ShoeRestController {

    @Autowired
    private ShoeServiceImpl shoeService;

    @PostMapping("/shoe")
    @ApiOperation(value = "Add a shoe into data base")
    public ResponseEntity addShoe(@RequestBody Shoe shoe){

        Shoe shoeAdded = shoeService.addShoe(shoe);
        if(shoeAdded == null)
            return new ResponseEntity("shoe can not be added ", HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity(shoeAdded,HttpStatus.OK);
    }

    @GetMapping("/shoes")
    @ApiOperation(value = "View of all shoes available", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity getAll(){

        List<Shoe> shoeList = shoeService.getAll();
        if(shoeList.size() == 0)
            return new ResponseEntity("The list is empty",HttpStatus.ACCEPTED);


        return new ResponseEntity(shoeList,HttpStatus.OK);
    }


    @GetMapping("/shoe/{color}")
    @ApiOperation(value = "Find the list by Color")
    public ResponseEntity getShoesByColor(@PathVariable("color") String color){

        List<Shoe> shoesList = shoeService.findByColor(color);
        if(shoesList.size() ==0){
            return new ResponseEntity("No shoe found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(shoesList,HttpStatus.OK);

    }



    @GetMapping("/shoes/{id}")
    @ApiOperation(value = "find shoe by Id")
    public ResponseEntity getShoeById(@PathVariable("id") Long id){

        Shoe foundShoe = shoeService.shoeFound(id);
        if(foundShoe==null){
            return new ResponseEntity("Shoe not found ",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(foundShoe,HttpStatus.OK);
    }

    @DeleteMapping("/shoes/{id}")
    @ApiOperation(value = "delete shoe by Id")
    public void deleteShoe(@PathVariable("id") Long id){

        try {
            Long deleteShoe = shoeService.deleteShoe(id);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
