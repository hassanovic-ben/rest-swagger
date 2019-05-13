package com.hassan.restcontroller;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.hamcrest.Matchers.*;

public class ShoeRestControllerTest {

    @Test
    public void test_getAll_rest(){

        given().when().get("/shoes")
                .then().statusCode(200);
         assertThat(RestAssured.get("/shoes").statusCode()).isNotEqualTo(404);
        assertThat(RestAssured.get("/shoes").statusCode()).isEqualTo(200);
    }

    @Test
    public void test_save_shoe_rest(){

        JsonObject shoeJsonObject = getJsonObject();
        RestAssured.baseURI = "http://localhost:8080";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(shoeJsonObject.toString());
        Response response = httpRequest.post("/shoe");
        assertThat(response.getStatusCode()).isEqualTo(200);

    }

    @Test
    public void test_get_shoe_by_color(){

        given().pathParam("color","red")
                .when().get("/shoe/find/color/{color}")
                .then().statusCode(200).body("size()",is(13));

        given().pathParam("color","red")
                .when().get("/shoe/find/color/{color}")
                .then().statusCode(200).body("size()",notNullValue());
    }

    @Test
    public void test_get_shoe_by_size(){

        given().pathParam("size",39)
                .when().get("/shoes/{size}")
                .then().statusCode(200).body("size()",is(6));

        given().pathParam("size",39).
                when().get("/shoes/{size}")
               .then().statusCode(200)
               .body("idShoe",hasItems(9))
               .body("name", hasItems("blueSky"));
    }

    private JsonObject getJsonObject() {
        JsonObject shoeJsonObject = new JsonObject();
        shoeJsonObject.addProperty("name", "shoe assured");
        shoeJsonObject.addProperty("size", 39);
        shoeJsonObject.addProperty("brand", "cici");
        shoeJsonObject.addProperty("color", "red");
        shoeJsonObject.addProperty("price", 125);
        return shoeJsonObject;
    }
}
