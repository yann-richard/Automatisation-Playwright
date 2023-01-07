package Runners;


import com.microsoft.playwright.*;
//import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import junit.textui.TestRunner;
//import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.After;
//import org.junit.Before;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.io.ByteArrayInputStream;
import java.io.File;
import page_object.homePage;
//import io.cucumber.java.Scenario;
/*import io.cucumber.core.api.Scenario;*/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


import java.nio.file.Paths;

public class BaseRunner extends TestRunner {
    public static Boolean Headless=false;
    static Playwright playwright = Playwright.create();
    static BrowserType chrome = playwright.chromium( );
    /*Browser browser = chrome.launch(new BrowserType.LaunchOptions().setHeadless(false));*/
    public static Browser Bigbrowser = chrome.launch(new BrowserType.LaunchOptions().setHeadless(Headless));
    public static BrowserContext browser = Bigbrowser.newContext();
    /*public static BrowserContext browser ;*/
    public static Page pager = browser.newPage();
    public static int i;
    homePage home;






    @BeforeClass
    public static void beforeTest() {



        browser.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));

        /*file cleaning script*/

        File index = new File("C:/Users/Pawk71/Desktop/zenity task/PROJET_Playwright/Automatisation-Playwright/allure-results");
        if (index.exists()) {
            String[] entries = index.list();
            for (String s : entries) {
                File currentFile = new File(index.getPath(), s);
                currentFile.delete();
            }
            index.delete();
        }
        File index2 = new File("C:/Users/hambe/Desktop/playwrightDemo/target/videos");
        if (index2.exists()) {
            String[] entries = index2.list();
            for (String s : entries) {
                File currentFile = new File(index2.getPath(), s);
                currentFile.delete();
            }
            index2.delete();
        }
    }


    @BeforeEach
    void createContextAndPage() {

        browser = Bigbrowser.newContext(new Browser.NewContextOptions()
                .setRecordVideoDir(Paths.get("target/videos/"))
                .setRecordVideoSize(1080, 720));
        browser.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));
        pager = browser.newPage();

    }



    @AfterEach

        public void takeScraenshotOnFailure(Scenario scenario){
        if (!Headless){
           new homePage(pager).takeScreenVideoCapture();
        browser.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("Traces/trace" + i + ".zip")));
        i++;
        }else {
            browser.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("Traces/trace" + i + ".zip")));
            i++;
            pager.close();
            browser.close();
        }

//            Allure.addAttachment("Console log: ", String.valueOf(""));


    /*
            if (scenario.isFailed()) {
                new homePage(pager).saveScreen();
                pager.close();
                if (!Headless)
                    new homePage(pager).takeScreenVideoCapture();
                browser.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("Traces/trace" + i + ".zip")));
                i++;
//            Allure.addAttachment("Console log: ", String.valueOf(""));

            } else {
                browser.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("Traces/trace" + i + ".zip")));
                i++;
                browser.close();
            }*/


        }




   /* @AfterClass
    public static void afterTest() {
        browser.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("Traces/trace"+i+".zip")));
        i++;
    }*/

}
