package com.hassan.restcontroller;

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
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.logging.Logger;

@RestController
@Api(value="Shoes Management System")
public class ShoeRestController {

    @Autowired
    private ShoeServiceImpl shoeService;

    /**
     * addShoe method will add a new shoe into data base
     * @param shoe
     * @return
     */
    @PostMapping(path = "/shoe")
    @ApiOperation(value = "Add a shoe into data base")
    public ResponseEntity addShoe(@RequestBody Shoe shoe){

        Shoe shoeAdded = shoeService.addShoe(shoe);
        if(shoeAdded == null)
            return new ResponseEntity("shoe can not be added ", HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity(shoeAdded,HttpStatus.OK);
    }

    /**
     * getAll method gets all shoes from DB
     * @return
     */
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
        if(shoeList.isEmpty())
            return new ResponseEntity("The list is empty",HttpStatus.ACCEPTED);

        return new ResponseEntity(shoeList,HttpStatus.OK);
    }

    /**
     * Get the shoes list by the specific
     * color passed in argument
     * @param color
     * @return
     */
    @GetMapping("/shoe/find/color/{color}")
    @ApiOperation(value = "Find the list by Color")
    public ResponseEntity getShoesByColor(@PathVariable("color") String color){

        List<Shoe> shoesList = shoeService.findByColor(color);
        if(shoesList.isEmpty()){
            return new ResponseEntity("No shoe found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(shoesList,HttpStatus.OK);
    }

    /**
     * getShoeById gets Shoe By Id
     * @param id
     * @return
     */

    @GetMapping("/shoe/find/id/{id}")
    @ApiOperation(value = "find shoe by Id")
    public ResponseEntity getShoeById(@PathParam("id") Long id){

        Shoe foundShoe = shoeService.getShoeById(id);
        if(foundShoe==null){
            return new ResponseEntity("Shoe not found ",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(foundShoe,HttpStatus.OK);
    }

    /**
     * deleteShoe deletes a shoe by id
     * @param id
     * @return ResponseEntity
     */
    @DeleteMapping("/shoes/{id}")
    @ApiOperation(value = "delete shoe by Id")
    public ResponseEntity deleteShoe(@PathVariable("id") Long id){

        Shoe shoe = shoeService.getShoeById(id);
        if(shoe== null)
            return new ResponseEntity("Shoe with id : " + id + " is not exist", HttpStatus.NOT_FOUND);

        try {
            shoeService.deleteShoe(shoe.getIdShoe());
            return new ResponseEntity("shoe with id : " + id + " is deleted " , HttpStatus.OK);
        }
        catch (Exception ex){
            Logger.getLogger(ex.toString());
        }
        return new ResponseEntity("This shoe can not be deleted !! " , HttpStatus.INTERNAL_SERVER_ERROR);
    }


    /**
     * getShoeBySize gets a
     * list of shoes by size
     * @param size
     * @return ResponseEntity
     */

    @GetMapping("/shoes/{size}")
    @ApiOperation(value = "find shoe by Size")
    public ResponseEntity getShoeBySize(@PathVariable("size") Integer size){

        List<Shoe> shoesBySize = shoeService.findBySize(size);
        if(shoesBySize==null){
            return new ResponseEntity("Shoes not found ",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(shoesBySize,HttpStatus.OK);
    }


    /**
     * updateShoe method will update an existing shoe
     * in data base.
     * @param shoe
     * @return
     */
    @ApiOperation(value = "Update a shoe In Data Base")
    @PutMapping("/shoe")
    public ResponseEntity updateShoe(@RequestBody Shoe shoe){

        Shoe shoeAdded = shoeService.updateShoe(shoe);
        if(shoeAdded == null)
            return new ResponseEntity("shoe can not be updated ", HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity(shoeAdded,HttpStatus.OK);
    }

}
