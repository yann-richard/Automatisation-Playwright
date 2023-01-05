package step_definitions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import page_object.productPage;
import page_object.homePage;
import static Runners.BaseRunner.*;

public class productStep {
    productPage product;

    @Given("I am connected to my account {string} and {string}")
    public void iAmConnectedToMyAccountAnd(String arg0, String arg1) {
        pager.navigate("https://ztrain-web.vercel.app/auth/login");
        product = new productPage(pager);
        product.enterEmailandPassword(arg0,arg1);
        product.saveScreen();
    }

    @And("I added to my bag")
    public void iAddedToMyBag() {
        product.addProduct();
        product.saveScreen();
    }


    @Then("I can see the message {string}")
    public void iCanSeeTheMessage(String verify_except) {
        String verify_obtains = product.verifyaddproduct();
        product.saveScreen();
        Assert.assertEquals(verify_except,verify_obtains);
        //product.waittime();
    }
}
