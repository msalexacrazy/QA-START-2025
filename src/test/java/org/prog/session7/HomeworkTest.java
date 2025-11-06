package org.prog.session7;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//TODO: load allo.ua, search for iPhone
public class HomeworkTest {
    private WebDriver driver;

    @BeforeSuite
    public void initWebDriver(){
        driver = new ChromeDriver();
    }

    @Test
    public void myTestSiteAllo() {
        driver.get("https://allo.ua/?srsltid=AfmBOorrbOxaLB4okTlgtuHLCKss8SpOi_OngCNtdDdNdRLQNbGGxJAO");
        WebElement search = driver.findElement(By.id("search-form__input"));
        search.sendKeys("iPhone");
        search.sendKeys(Keys.ENTER);
        driver.quit();
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
