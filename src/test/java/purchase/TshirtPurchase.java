package purchase;

import base.ScriptBase;
import homePageController.TShirtPurchaseController;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class TshirtPurchase extends ScriptBase {
    public static final Logger log=Logger.getLogger(TshirtPurchase.class.getName());
    TShirtPurchaseController tspc = new TShirtPurchaseController(driver);


    @Test(priority = 1,description = "Verify user should able to login successfully")
    public void verifySuccessfullLogin() {
        log.info("######verifySuccessfullLogin Test started#####");
        tspc = new TShirtPurchaseController(driver);
        tspc.loginApplication(username, password);
        log.info("######verifySuccessfullLogin Test completed#####");

    }

    @Test(priority = 2,description = "Verify user should able to purchase T-shirt")
    public void verifyEndToEndPurchaseTshirtProcess() {
        log.info("######verifyEndToEndPurchaseTshirtProcess Test started#####");
        tspc = new TShirtPurchaseController(driver);
        tspc.addCartProduct(driver, "Sauce Labs Bolt T-Shirt");
        tspc.addCartProduct(driver, "Test.allTheThings() T-Shirt (Red)");
        tspc.purchase(driver, "Sauce Labs Bolt T-Shirt", "Dilruba", "Jahan", "10003");
        log.info("######verifyEndToEndPurchaseTshirtProcess Test completed#####");
    }


}