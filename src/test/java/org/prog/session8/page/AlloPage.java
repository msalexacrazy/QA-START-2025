package org.prog.session8.page;

//TODO: add allo.ua page and move iphone search there
//TODO: confirm price has ₴ sign in it
//завдання з * навести на товар і роздрукувати дані про камеру, через actions

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlloPage {
    private final WebDriver driver;

    public AlloPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get("https://allo.ua/?srsltid=AfmBOorrbOxaLB4okTlgtuHLCKss8SpOi_OngCNtdDdNdRLQNbGGxJAO");
    }

    public void searchSmth(String searchItem) {
        WebElement search = driver.findElement(By.id("search-form__input"));
        search.sendKeys(searchItem);
        search.sendKeys(Keys.ENTER);
    }

    public void getCurrencySymbol() {
        WebElement currencySymbol = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@id=\'__layout\']/div/div[1]/div[2]/div/div[2]/div[2]/div[1]/div/div[3]/div[2]/div/div[2]")));

        String text = currencySymbol.getText();
        System.out.println("In the text of the price include symbol ₴: " + text.contains("₴"));
    }
}
