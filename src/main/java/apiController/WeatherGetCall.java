package apiController;

import homePageController.TShirtPurchaseController;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.Assert;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class WeatherGetCall {
    public static final Logger log=Logger.getLogger(WeatherGetCall.class.getName());

    public void getWeather() {
        Response response = RestAssured.get("https://openweathermap.org/data/2.5/weather/?appid=b6907d289e10d714a6e88b30761fae22&id=2643743").andReturn();
        String json = response.getBody().asString();
        System.out.println("Get call response is: "+json);
        JsonPath jsonPath = new JsonPath(json);
        jsonPath.getString("base").equals("stations");
        System.out.println("Response body object is: "+jsonPath.getString("base").equals("stations"));
    }

    //Another way to do
    public void getCityWeather() {

        when().get("https://openweathermap.org/data/2.5/weather/?appid=b6907d289e10d714a6e88b30761fae22&id=2643743")
                .then().statusCode(200).assertThat().body("base", equalTo("stations"));


    }


}
