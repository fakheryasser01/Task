package apiTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class SearchPoemsTest {
@Test
    public void setBaseURI() {
        baseURI= "http://betapoems.hindawi.org/";

        given().log().all().header("Content-Type","application/json").
               body("{\n" +
                       "  \"pageNumber\": 1,\n" +
                       "  \"pageSize\": 10,\n" +
                       "  \"searchText\": \"المساء\"\n" +
                       "}")
                .when().post("/Poems/SearchPoems")
                .then().log().all().assertThat().statusCode(200)
                .body("data.poemsList[0].poemTitle",equalTo("الْمَسَاء") )
                .body("data.poemsList[1].poemTitle",equalTo("الْمَسَاء") );

    }



    public void post(String endpoint)
    {
        baseURI ="baseURL";

        JSONObject body = new JSONObject();

        body.put("title" , "foo");
        body.put("body" , "bar");
        body.put("userId" , "1");

        given().header("Content-Type" , "application/json")
                .body(body)
                .when().post(endpoint).
                then().assertThat().statusCode(200);
    }






}
