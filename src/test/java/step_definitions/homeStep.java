package step_definitions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.nio.file.Paths;

import java.io.ByteArrayInputStream;
import org.junit.Assert;
import page_object.homePage;
import page_object.loginPage;
import static Runners.BaseRunner.*;

import static org.hamcrest.MatcherAssert.assertThat;

public class homeStep {

    homePage home;
    loginPage login;


    @Given("I am connected to my account with {string} and {string}")
    public void iAmConnectedToMyAccountWithAnd(String email, String password) {
        pager.navigate("https://ztrain-web.vercel.app/auth/login");
        home = new  homePage(pager);
        home.enterEmailandPasswordTologin(email,password);
    }

    @When("I do a search with {string}")
    public void KeywordSearchWith(String terms) {
        home.search(terms);
    }

 /*   @Then("I see a result {string}")
    public void verifyProductsNameSearch(String result) {
     home.saveScreen();
   String confirmationProductName = home.getResultProductName();
      Assert.assertEquals(confirmationProductName,result);
    }*/
    @Then("I see a result")
    public void iSeeAMultipleKeywordSearchResultPage() {
        home.saveScreen();
        Assert.assertTrue("An Error has occurred while searching",home.ResultSearch());
      /*  Assert.assertTrue("Erreur au niveau du résultat de la recherche",home.getResultSearch());*/
       // home.waittime();
    }

   /* @And("I clicks to the logout button")
    public void logoutapp() {
        home.logoutButton();}

    @Then("I'm logout")
    public void imlogout() {
        home.saveScreen();
        assert pager.url().equals("https://ztrain-web.vercel.app/home");
        home.saveScreen();
        //home.waittime();
    }
*/

        @Then("I see a message {string}")
        public void iSeeAMessage(String result_exc) {
            home.saveScreen();
            String true_result = home.getResultSearch();
           Assert.assertEquals(true_result,result_exc);
           // home.waittime();
        }



}
