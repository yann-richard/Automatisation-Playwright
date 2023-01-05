package Runners;


import com.microsoft.playwright.*;
import junit.textui.TestRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.After;
import org.junit.Before;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


import java.nio.file.Paths;

public class BaseRunner extends TestRunner {
    static Playwright playwright = Playwright.create();
    static BrowserType chrome = playwright.chromium( );
    /*Browser browser = chrome.launch(new BrowserType.LaunchOptions().setHeadless(false));*/
    public static Browser Bigbrowser = chrome.launch(new BrowserType.LaunchOptions().setHeadless(false));
    public static BrowserContext browser = Bigbrowser.newContext();
    public static Page pager = browser.newPage();
    public static int i;

    @BeforeEach
    void createContextAndPage() {
        browser = Bigbrowser.newContext();
        pager = browser.newPage();
    }

    @AfterEach
    void closeContext() {
        browser.close();
    }

    @BeforeClass
    public static void beforeTest() {
        browser.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));
    }

    @AfterClass
    public static void afterTest() {
        browser.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("Traces/trace"+i+".zip")));
        i++;
    }

}
