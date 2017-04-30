package org.megaprint;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;


/**
 * Created by Baurz on 4/15/2017.
 */
public class RestBasic1Test {
    @BeforeMethod
    public void initTest(){
        RestAssured.baseURI="https://maps.googleapis.com";
    }
    @Test
    public void test1(){
        given().
                param("location","-33.8670522,151.1957362").
                param("radius","5000").
                param("key","AIzaSyCRLYEnebEej6DjJAo6U_hp3ELl12AyzSs").
        when().
                get("/maps/api/place/nearbysearch/json").
        then().
                assertThat().
                statusCode(200).
                and().
                contentType(ContentType.JSON).
                and().
                body("results[0].name",equalTo("Sydney")).
                and().
                header("Server","pablo");
    }
}
