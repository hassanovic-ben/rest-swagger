package com.hassan.restController;

import com.hassan.model.Shoe;
import com.hassan.service.ShoeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Api(value="Shoes Management System", description="Management of the shoes into management system")
public class ShoeRestController {

    @Autowired
    private ShoeServiceImpl shoeService;

    @PostMapping("/shoe")
    @ApiOperation(value = "Add a shoe")
    public Shoe addShoe(@RequestBody Shoe shoe){

        Shoe shoeAdded = shoeService.addShoe(shoe);
        if(shoeAdded == null)
            return null;
        else
            return shoeAdded;
    }

    @GetMapping("/shoes")
    @ApiOperation(value = "View of all shoes available", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    private List<Shoe> getAll(){

        List<Shoe> shoeList = shoeService.getAll();
        return shoeList;
    }


    @GetMapping("/shoes/{id}")
    @ApiOperation(value = "find shoe by Id")
    public Shoe getShoeById(@PathVariable("id") Long id){

        Shoe foundShoe = shoeService.shoeFound(id);
        return foundShoe;
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
