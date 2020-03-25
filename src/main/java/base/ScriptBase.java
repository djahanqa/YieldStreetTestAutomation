package base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class ScriptBase {

    public static WebDriver driver;
    public static String username;
    public static String password;
    public static String url;
    public static final Logger log=Logger.getLogger(ScriptBase.class.getName());

    @Parameters({"browser", "environment"})
    @BeforeTest
    public void beforeTest(String browser, String environment) throws MalformedURLException {
        String Log4jConfigPath="log4j.properties";
        PropertyConfigurator.configure(Log4jConfigPath);
        if (browser.equalsIgnoreCase("chrome")) {
            //Chrome Driver version 80.0.3987.106. If your machine chrome version different ,plese download here same version
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver");
            driver = new ChromeDriver();
            System.out.println(" Executing on Chrome");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "./driver/geckodriver");
            driver = new FirefoxDriver();
            System.out.println(" Executing on FireFox");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        if (environment.equals("standard")) {
            url = "https://www.saucedemo.com/index.html";
            username = "standard_user";
            password = "secret_sauce";
        } else if (environment.equals("locked")) {
            url = "https://www.saucedemo.com/index.html";
            username = "locked_out_user";
            password = "secret_sauce";
        } else if (environment.equals("problem")) {
            url = "https://www.saucedemo.com/index.html";
            username = "problem_user";
            password = "secret_sauce";
        } else if (environment.equals("performance")) {
            url = "https://www.saucedemo.com/index.html";
            username = "performance_glitch_user";
            password = "secret_sauce";

        }
        driver.get(url);
    }

    @AfterTest
    public void afterTest() {
        System.out.println("End");
        driver.quit();

    }
}
