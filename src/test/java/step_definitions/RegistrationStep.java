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

    @And("I clicks validation button")
    public void iClicksValidationButton() {
        registration.clickValidationButton();
        //throw new io.cucumber.java.PendingException();
    }


    @Then("after registration The user is connected, the {string} logo is observed")
    public void theUserIsConnected(String confirmationLogin) {
        String confirmation = registration.getConfirmationLogin();
        registration.saveScreen();
        Assert.assertEquals("Registration failed because 'user failed to login after registration step' : \n" +
                "--> after more 30s of waiting exceeded  we did not find the Ztrain logo indicating the presence on the homepage and an effective connection of the user)\n" +
                "-->",confirmationLogin,confirmation);
        registration.saveScreen();
        //registration.waittime();

    }

    @Then("Access is denied  {string}")
    public void accessIsDenied(String failedRegister) {
        String failed = registration.getFailedRegister();
        registration.saveScreen();
        Assert.assertEquals("this test case is not passed because : \n" +
                "-> after more 30s of waiting exceeded we did not find this error message 'The two passwords are not identical' \n" +
                "->",failedRegister,failed);
        registration.saveScreen();
        //throw new io.cucumber.java.PendingException();
    }

    @Then("the user is existing  {string}")
    public void theUserIsExisting(String failExisting_expect) {
        String fail_obtains = registration.getFailedExisting();
        registration.saveScreen();
        Assert.assertEquals("this test case is not passed because:\n" +
                "-> after more 30s of waiting exceeded we did not find this error message 'This user already exists'\n" +
                "->",failExisting_expect,fail_obtains);
        registration.saveScreen();
       // throw new io.cucumber.java.PendingException();



    }
}
