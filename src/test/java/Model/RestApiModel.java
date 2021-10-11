package Model;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.minidev.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class RestApiModel {


    Response response;
    
    public String baseURL="http://localhost:3000/api/allGrocery";
    JSONObject request = new JSONObject();
    
    
    public void checkProduct(String name,int price,int stock){

        RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("name",name)
                .when()
                .get(baseURL)
                .then()
                .statusCode(200)

                .body("price[0]", equalTo(price))

                .body("stock[0]", equalTo(stock));


    }

    
    public void checkAllProductControl(){
         Response response = given()
                .get(baseURL+"/?name=samsung")
                .then()
                .statusCode(200)
                .extract().response();

         Assert.assertNotNull(response.getBody().jsonPath().getList("id").get(0));
    }
    
    
    public void checkProductControl(){
         Response response = given()
                .get(baseURL+"/?name=samsung")
                .then()
                .statusCode(200)
                .extract().response();

         Assert.assertNotNull(response.getBody().jsonPath().getList("id").get(0));
    }

    public void postProduct(int id,String name,int price,int stock){

        request.put("id",id );
        request.put("name", name);
        request.put("price", price);
        request.put("stock", stock);

        given()
                .header("Content-type", "application/json")
                .and()
                .body(request.toJSONString())
                .when()
                .post(baseURL)
                .then()
                .statusCode(201);

    }

}
