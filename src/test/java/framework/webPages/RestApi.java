package framework.webPages;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.omg.PortableInterceptor.ORBIdHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestApi {

    private String url = "https://api.darksky.net/forecast/5df1432f135c8f1505b4577f0fa79618/42.3601,-71.0589,255657600?exclude=currently,flags&5df1432f135c8f1505b4577f0fa79618";
    private String jsonServerUrl = "http://localhost:3000/users";
    private String jsonServerPostUrl = "http://localhost:3000/users";


    @Test
    public void apiTestBody(){
        Response responseGet = get(url);
        int status = responseGet.getStatusCode();
        given()
                .auth().preemptive().basic("ridh","test")
        .when()
                .get("https://pokeapi.co/api/v2/pokemon/ditto")
        .then()
                .statusCode(200)
                .body("abilities.ability.name", hasItems("limber"))
                .body("game_indices.version.name", hasItems("ridh"))
                .body("held_items.version.name", hasItems("ridh"));


    }

    @Test
    public void apiTestDarkSkyGet(){
        Response responseGet = get(url);
        int status = responseGet.getStatusCode();
        String details = responseGet.asString();
        System.out.println(status);
        Assert.assertEquals(status,200);
        System.out.println(details);
    }

    @Test
    public void jsonServerGet(){
        String user = get(jsonServerUrl).asString();
        System.out.println(user);
    }

    @Test
    public void jsonServerPost(){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type","application/json");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName","Sulaiman");
        jsonObject.put("lastName","Ch");
        jsonObject.put("email","sul@gmail.com");
        jsonObject.put("age","27");
        jsonObject.put("companyId","37");
        jsonObject.put("id","129");

        requestSpecification.body(jsonObject.toString());

        requestSpecification.post(jsonServerPostUrl);

        Response responsePost = requestSpecification.post(jsonServerUrl);

        System.out.println(responsePost.getStatusCode());

    }
}
