package com.hassan.restController;

import com.hassan.model.Shoe;
import io.restassured.RestAssured;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.hamcrest.Matchers.*;

public class ShoeRestControllerTest {

    @Test
    public void test_getAll_rest(){

        given().when().get("/shoes")
                .then().statusCode(200);
        RestAssured.get("/shoes").then().statusCode(200).body("size()",is(6));
        given().when().get("/shoes").then().statusCode(200).body("idShoe",hasItems(13,9,11,10,12,14));
        assertThat(RestAssured.get("/shoes").statusCode()).isNotEqualTo(404);
        assertThat(RestAssured.get("/shoes").statusCode()).isEqualTo(200);
    }

    @Test
    public void test_save_shoe_rest(){

       Shoe shoe = new Shoe("nike", 40,"Nike Mark",150,"Red");
       when().post("/shoe").then().statusCode(200);

    }

    @Test
    public void test_get_shoe_by_color(){

        given().pathParam("color","red")
                .when().get("/shoe/find/color/{color}")
                .then().statusCode(200).body("size()",is(3));
    }

    @Test
    public void test_get_shoe_by_size(){

        given().pathParam("size",39)
                .when().get("/shoes/{size}")
                .then().statusCode(200).body("size()",is(1));

        given().pathParam("size",39).when().get("/shoes/{size}")
               .then().statusCode(200)
               .body("idShoe",hasItems(9))
               .body("name", hasItems("blueSky"));
    }
}
