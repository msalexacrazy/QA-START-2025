package org.prog.session13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.prog.session11.steps.WebSteps;
import org.prog.session8.page.GooglePage;
import org.prog.session8.page.W3SchoolsPage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AllureSampleTests {

    private WebDriver driver;
    private GooglePage googlePage;
    public W3SchoolsPage w3SchoolsPage;

    @BeforeSuite
    public void initWebDriver() throws MalformedURLException {
        driver = WebSteps.driver = new RemoteWebDriver(
                new URL("http://selenoid:4445/wd/hub"), CucumberRunner.remoteChrome());
        googlePage = new GooglePage(driver);
        w3SchoolsPage = new W3SchoolsPage(driver);
    }

    @Test
    public void myGoogleTest() {
        googlePage.loadPage();
        googlePage.acceptCookiesIfPresent();
        googlePage.searchForSomething();
    }

    @Test
    public void myIframeTest() {
        w3SchoolsPage.loadPage();
        w3SchoolsPage.acceptCookiesIfPresent();
        w3SchoolsPage.switchToResultFrame();
        w3SchoolsPage.findIframeButtonAndReturn();
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
