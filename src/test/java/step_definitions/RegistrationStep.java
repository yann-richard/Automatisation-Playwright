package step_definitions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page_object.registrationPage;
import static Runners.BaseRunner.*;

public class RegistrationStep {
    registrationPage registration;


    @Given("i'm Ztrain login page")
    public void iMZtrainLoginPage() {
        pager.navigate("https://ztrain-web.vercel.app/auth/login");
        registration = new registrationPage(pager);
        registration.saveScreen();
        //throw new io.cucumber.java.PendingException();
    }
    @When("I click on register button")
    public void iClickOnRegisterButton() {
        registration.clickRegisterButton();
    }

    @And("I fill in the form with the information {string} {string} {string}")
    public void iFillInTheFormWithTheInformation(String email, String password, String confirmpass) {
        registration.enterEmailRegister(email);
        registration.enterPasswordRegister(password);
        registration.enterConfirmPassword(confirmpass);
        registration.saveScreen();
        //throw new io.cucumber.java.PendingException();
    }

    @Then("I clicks validation button")
    public void iClicksValidationButton() {
        registration.clickValidationButton();
        registration.saveScreen();
        //throw new io.cucumber.java.PendingException();
    }


    @Then("The user is connected {string}")
    public void theUserIsConnected(String confirmationLogin) {
        String confirmation = registration.getConfirmationLogin();
        registration.saveScreen();
        Assert.assertEquals(confirmation,confirmationLogin);
        registration.saveScreen();
        //registration.waittime();
        //throw new io.cucumber.java.PendingException();
    }

    @Then("Access is denied  {string}")
    public void accessIsDenied(String failedRegister) {
        String failed = registration.getFailedRegister();
        Assert.assertEquals(failed,failedRegister);
        registration.saveScreen();
        //throw new io.cucumber.java.PendingException();
    }

    @Then("the user is existing  {string}")
    public void theUserIsExisting(String failExisting_expect) {
        String fail_obtains = registration.getFailedExisting();
        Assert.assertEquals(fail_obtains,failExisting_expect);
        registration.saveScreen();
       // throw new io.cucumber.java.PendingException();

    }
}
