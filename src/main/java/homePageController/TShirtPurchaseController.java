package homePageController;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import sun.rmi.runtime.Log;

import java.util.concurrent.TimeUnit;

public class TShirtPurchaseController {
    public static final Logger log=Logger.getLogger(TShirtPurchaseController.class.getName());
    @FindBy(id = "user-name")
    WebElement userName;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(xpath = "//input[@value='LOGIN']")
    WebElement login;
    @FindBy(xpath = "//div[contains(text(),'Products')]")
    WebElement loginVerification;
    @FindBy(xpath = "//button[contains(text(),'ADD TO CART')]")
    WebElement addCart;
    @FindBy(xpath = "//button[contains(text(),'<- Back')]")
    WebElement backButton;

    @FindBy(xpath = "//a[contains(text(),'Continue Shopping')]")
    WebElement continueShoppingButton;

    @FindBy(xpath = "//a[contains(text(),'CHECKOUT')]")
    WebElement checkoutButton;

    @FindBy(id = "first-name")
    WebElement firstName;
    @FindBy(id = "last-name")
    WebElement lastName;
    @FindBy(id = "postal-code")
    WebElement zipCode;
    @FindBy(xpath = "//a[contains(text(),'FINISH')]")
    WebElement finishButton;

    @FindBy(xpath = "//a[@href='./cart.html']")
    WebElement cartLogo;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement continueButton;

    @FindBy(xpath = "//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]")
    WebElement purchaseCompleteMessage;

    public TShirtPurchaseController(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void loginApplication(String user, String pass) {
        userName.clear();
        log.info("User name box cleared: "+userName);
        userName.sendKeys(user);
        log.info("User name input properly: "+user);
        password.clear();
        log.info("Password box cleared: "+password);
        password.sendKeys(pass);
        log.info("Password input properly: "+pass);
        login.click();
        log.info("login button clicked : "+login);
        Assert.assertEquals(loginVerification, loginVerification);
        log.info("Login properly and verified");
    }


    public void addCartProduct(WebDriver driver, String product) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        selectProductByName(driver, product);
        log.info("Item selected: "+product);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        addCart.click();
        log.info("Add cart button clicked");
        backButton.click();
        log.info("Back button clicked");
        cartLogo.click();
        log.info("Cart logo button clicked");
        //below code verify add chart product add properly
        whichProductInYourCart(driver, product);
        log.info("verified product in cart: "+ product);
        continueShoppingButton.click();
        log.info("Continue button click");

    }

    public void purchase(WebDriver driver, String product, String firstname, String lastname, String postalCode) {
        cartLogo.click();
        log.info("cart logo click ");
        checkoutButton.click();
        log.info("Checkout tab click ");
        firstName.clear();
        log.info("First name input box clear");
        firstName.sendKeys(firstname);
        log.info("First name input properly: "+firstname);
        lastName.clear();
        log.info("Last name input box clear");
        lastName.sendKeys(lastname);
        log.info("Last name input properly: "+lastname);
        zipCode.clear();
        log.info("zip code input box clear");
        zipCode.sendKeys(postalCode);
        log.info("Zip code input properly: "+postalCode);
        continueButton.click();
        log.info("Continue button click");
        whichProductInYourCart(driver, product);
        log.info("verified product in cart: "+ product);
        finishButton.click();
        log.info("Finish button click");
        Assert.assertEquals(purchaseCompleteMessage, purchaseCompleteMessage);
        log.info("Item purchase completed and completed message:  "+purchaseCompleteMessage.getText());

    }


    public void selectProductByName(WebDriver driver, String product) {

        driver.findElement(By.xpath("//div[contains(text(),'" + product + "')]")).click();

    }


    public void whichProductInYourCart(WebDriver driver, String product) {

        driver.findElement(By.xpath("//div[contains(text(),'" + product + "')]")).isDisplayed();

    }


}