package org.prog.session8;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.session8.page.AlloPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeworkTest {
    private WebDriver driver;
    private AlloPage alloPage;

    @BeforeSuite
    public void initWebDriver(){
        driver = new ChromeDriver();
        alloPage = new AlloPage(driver);
    }

    @Test
    public void myTestSiteAllo() {
        driver.manage().window().maximize();
        alloPage.loadPage();
        alloPage.searchSmth("Iphone");
        alloPage.getCurrencySymbol();
        alloPage.searchFirstElementOnThePage();
        alloPage.searchCameraOnTheCard();
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
