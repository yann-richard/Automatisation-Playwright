package page_object;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;
import java.nio.file.Paths;

public class productPage {
    Page page;
    // Locator — — — -

    String emailUser = "id=email_login";
    String password = "id=password_login";
    String clickLogin = "id=btn_login";
    String addproduct01 = "text=Ampoule Vecteur Incandescent30.99 € T-shirt en coton biologique8.99 € Chaussures >> span >> :nth-match(img, 2)";
    String polo =  "id=style_popular_product_wrapper__z6J0h div:nth-child(2) .style_card_body__QuF";
    String verifyproduct = "text=Votre panier à été mis à jour";


    // initialize Page using constructor

    public productPage(Page page) {
        this.page = page;
    }

    public void enterEmailandPassword(String email, String pwd) {
        page.fill(emailUser, email);
        page.fill(password, pwd);
        page.click(clickLogin);}

    public void addProduct() {
        page.click(addproduct01);
        page.click("text=Ajouter au panier");
        page.click("#style_popular_product_wrapper__z6J0h div:nth-child(2) .style_card_body__QuFGN");
        page.click("text=Ajouter au panier");
        page.click(polo);
        page.click("text=Ajouter au panier");
    }
    public String verifyaddproduct() {
        return page.textContent(verifyproduct);}
    public void waittime() {
        page.waitForTimeout(10000);
    }

    public void saveScreen() {
        Allure.addAttachment("screenshot",
                new ByteArrayInputStream((page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png"))))));
    }


}


