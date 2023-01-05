package page_object;
import io.qameta.allure.Allure;
import java.nio.file.Paths;

import java.io.ByteArrayInputStream;
import com.microsoft.playwright.Page;

public class loginPage {
    Page page;
    // localization of page elements
    String emailUser = "id=email_login";
    String password = "id=password_login";
    String LoginButton = "id=btn_login";
    String LogoLogin = "id=Connexion";
    String failedLogin = "text=Email ou mot de passe incorrect";
    String fail_email = "text=Le format de l'email est invalid";
    String LogoHomepageConfirmation = "id=style_content_logo__pkvMP";

    //Declaring the support methods of the page

    public void enterEmail(String email) {
        page.fill(emailUser, email);}

    public void enterPassword(String pass) {
        page.fill(password, pass);}

    public void clickLoginButton() {
        page.click(LoginButton);}
    public void waittime() {
        page.waitForTimeout(10000);
    }

    public String getLogoLogin() {
        return page.textContent(LogoLogin);}


    public String getFailedLogin() {
        return page.textContent(failedLogin);}

    public String getFail_email() {
        return page.textContent(fail_email);}

    public String verifyTitle() {
        String title = page.title();
        return title;}
    public String getLogoHomepage() {
        return page.textContent(LogoHomepageConfirmation);}


    public void saveScreen() {
        Allure.addAttachment("screenshot", new ByteArrayInputStream((page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png"))))));
    }



    // initialize Page using constructor
    public loginPage(Page page) {
        this.page = page;
    }




   //  app Login

    public void loginIntoApplication(String email, String pass) {
        enterEmail(email);
        enterPassword(pass);
        clickLoginButton();}

}
