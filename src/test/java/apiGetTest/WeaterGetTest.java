package apiGetTest;

import apiController.WeatherGetCall;
import org.testng.annotations.Test;

public class WeaterGetTest extends WeatherGetCall {


    @Test(priority = 1,description = "Verify user should able to get London weather info")
    public void verifyGetLondonWeather() {
        getWeather();
    }
}
