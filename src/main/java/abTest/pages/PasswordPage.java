package abTest.pages;

import abTest.WebDriverProvider;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordPage {
    private WebDriver driver = WebDriverProvider.getWebDriver();

    By passwordField = By.name("password");

    By btnNext = By.id("passwordNext");

    @Step("set value for 'Computer name' field")
    public PasswordPage setPassword(String password) {
        WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(passwordField)));
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    @Step("click button 'Next'")
    public InboxPage clickBtnNext() {
        driver.findElement(btnNext).click();
        return new InboxPage();
    }
}
