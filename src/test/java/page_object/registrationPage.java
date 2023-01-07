package page_object;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;
import java.nio.file.Paths;

public class registrationPage {

    Page page;
    // Locator — — — -

    String registerButton = "text=S'inscrire";
    String email_register = "id=email_register";
    String password_register = "id=password_register";
    String confirmPassword = "id=confirm_password_register";
    String validationButton = "id=btn_register";
    String confirmationLogin = "id=style_content_logo__pkvMP";
    String failedRegister = "text=Les deux mots de passe ne sont pas identiques";
    String failExisting = "text=Cet utilisateur existe déjà";


    // initialize Page using constructor

    public registrationPage(Page page) {
        this.page = page;
    }


    //Create methods
    public void clickRegisterButton() {
        page.hover(registerButton);
        page.click(registerButton);}
    public void enterEmailRegister(String email) {
        page.fill(email_register, email);}
    public void waittime() {
        page.waitForTimeout(10000);
    }

    public void enterPasswordRegister(String password) {
        page.fill(password_register, password);}
    public void enterConfirmPassword(String passconf) {
        page.fill(confirmPassword, passconf);}
    public void clickValidationButton() {
        page.click(validationButton);}


    public String getConfirmationLogin() {
        try {
            return page.textContent(confirmationLogin);
        } catch (TimeoutError e) {
            System.out.println("Timeout !");
            return ("Home page logo is not observed after registration step ");
        }
    }

        /*  return page.textContent(LogoHomepageConfirmation);*/
//        try { return page.textContent(LogoHomepageConfirmation);
//
//        } catch (TimeoutError e) {
//            System.out.println("Timeout !");
//            return page.textContent("e");
//        }



    public String getFailedRegister() {
        try {
            return page.textContent(failedRegister);
        } catch (TimeoutError e) {
            System.out.println("Timeout !");
            return ("no presence of the error message 'The two passwords are not identical'");
        }

    }


    public String getFailedExisting() {
        try {
            return page.textContent(failExisting);
        } catch (TimeoutError e) {
            System.out.println("Timeout !");
            return ("no presence of the error message 'This user already exists'");
        }
    }


    public void saveScreen() {
        Allure.addAttachment("screenshot",
                new ByteArrayInputStream((page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png"))))));
    }



}
