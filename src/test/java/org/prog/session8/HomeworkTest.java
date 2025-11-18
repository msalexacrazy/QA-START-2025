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

        WebElement productCard = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".product-card")));
        Actions actions = new Actions(driver);
        actions.moveToElement(productCard).perform();

        WebElement cameraValue = driver.findElement(By.xpath("(//dt[text()='Камера']/following-sibling::dd)[1]"));
        String cameraText = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", cameraValue);
        System.out.println("Камера: " + cameraText);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
