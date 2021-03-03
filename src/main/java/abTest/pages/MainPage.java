package abTest.pages;

import abTest.WebDriverProvider;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver = WebDriverProvider.getWebDriver();

    By emailField = By.id("identifierId");

    By btnNext = By.id("identifierNext");

    @Step("set Email")
    public MainPage setEmail(String email) {
        WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(emailField)));
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    @Step("click button 'Next'")
    public PasswordPage clickBtnNext() {
        driver.findElement(btnNext).click();
        return new PasswordPage();
    }
}
