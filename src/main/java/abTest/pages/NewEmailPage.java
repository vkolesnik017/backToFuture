package abTest.pages;

import abTest.WebDriverProvider;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewEmailPage {
    private WebDriver driver = WebDriverProvider.getWebDriver();

    By recipientField = By.xpath("//table[@class='aoP aoC']//tr[1]/td[2]/form/div[2]/div[1]");

    By recipientOfLetterField = By.xpath("//table[@class='aoP aoC']//tr[1]/td[2]/form//tr[1]/td[2]//textarea");

    By emailSubject = By.name("subjectbox");

    By inputEmailField = By.xpath("//div[@class='Am Al editable LW-avf tS-tW']");

    By btnSendEmail = By.xpath("//div[@class='dC']/div[1]");

    @Step("set the recipient of the letter")
    public NewEmailPage setRecipientOfEmail(String recipientOfEmail) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(recipientField))).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(recipientOfLetterField))).sendKeys(recipientOfEmail);
        return this;
    }

    @Step("set email subject")
    public NewEmailPage setEmailSubject(String title) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(emailSubject))).sendKeys(title);
        return this;
    }

    @Step("set text for email")
    public NewEmailPage setTextForEmail(String text) {
        driver.findElement(inputEmailField).sendKeys(text);
        return this;
    }

    @Step("click button 'Send email'")
    public InboxPage clickSendEmail() {
        driver.findElement(btnSendEmail).click();
        return new InboxPage();
    }

}
