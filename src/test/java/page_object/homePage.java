package page_object;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import page_object.loginPage;

import java.nio.file.Paths;

import java.io.ByteArrayInputStream;




public class homePage {
    loginPage loginPage;
    Page page;
    //localization of page elements
    String handle_mouse = "id=style_avatar_wrapper__pEGIQ";
    String logout_bouton = "text=Se déconnecter";

    String emailUser = "id=email_login";
    String password = "id=password_login";
    String clickLogin = "id=btn_login";
    String searchBar = "id=style_input_navbar_search__Scaxy";
    String failSearch = "id=style_empty_result___y6P_";
    String searchResult = "#style_popular_product_wrapper__z6J0h div div";

    String productName_1 = "text=Ampoule Vecteur Incandescent";
   // String productName_2 =”id=item_4_title_link”;

    //String productName_1 ="”;
//---------------------------------------------------------------------------
    // initialize Page using constructor
    public homePage(Page page) {
        this.page = page;
    }

    //---------------------------------------------------------------------------
    // //Declaring the support methods of the page
    public void enterEmailandPassword(String email, String pwd) {
        page.fill(emailUser, email);
        page.fill(password, pwd);
        page.click(clickLogin);}



    // app logout---------------------------------------------------------------
    public void logoutButton() {
        page.click(handle_mouse);
        page.click(logout_bouton);}

    //----------------------------------------------------------------------
    public void waittime() {
        page.waitForTimeout(10000);
        }

    // Search product---------------------------------------------------------
    public void enterEmailandPasswordTologin(String email, String pwd) {
        page.fill(emailUser, email);
        page.fill(password, pwd);
        page.click(clickLogin);}

    public Boolean ResultSearch() {
        return page.isVisible(searchResult);}

    /*public void search(String searchTerm1,String searchTerm2) {
        //page.pause();
        page.fill(searchBar, searchTerm1);
        page.fill(searchBar, searchTerm2);
    }*/
    public void search(String searchTerm) {
        //page.pause();
        page.waitForTimeout(10000);
        page.fill(searchBar, searchTerm);
    }

    public String getResultSearch() {
        return page.textContent(failSearch);}
    //----------------------------------------------------------------------
    public String getResultProductName() {
        String productName = page.textContent(productName_1);
        return productName;}



    //------------------------------------------------------------------------
    /*public String getLogoHomepage() {
        return page.textContent(LogoHomepage);}*/
//Take Screenshot-------------------------------------------------------------
public void saveScreen() {
    Allure.addAttachment("screenshot", new ByteArrayInputStream((page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png"))))));
}
}








