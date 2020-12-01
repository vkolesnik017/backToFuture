package abTest.pages;

import abTest.WebDriverProvider;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddComputerPage {
    private WebDriver driver = WebDriverProvider.getWebDriver();

    @FindBy(how = How.ID, id = "name")
    WebElement computerNameField;

    @FindBy(how = How.ID, id = "introduced")
    WebElement introducedDateField;

    @FindBy(how = How.ID, id = "discontinued")
    WebElement introducedDiscontinuedField;

    Select companyField = new Select(driver.findElement(By.id("company")));

    @FindBy(how = How.XPATH, xpath = "//input[@class='btn primary']")
    WebElement btnCreateComputer;


    @Step("set value for 'Computer name' field")
    public AddComputerPage setComputerName(String computerName) {
        WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(computerNameField)).sendKeys(computerName);
        wait.until(ExpectedConditions.textToBePresentInElementValue(computerNameField, computerName));
        return this;
    }

    @Step("set value for 'Introduced date' field")
    public AddComputerPage setIntroducedDate(LocalDate date) {
        String dateString = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(introducedDateField)).sendKeys(dateString);
        wait.until(ExpectedConditions.textToBePresentInElementValue(introducedDateField, dateString));
        return this;
    }

    @Step("set value for 'Introduced date' field")
    public AddComputerPage setDiscontinuedDate(LocalDate date) {
        String dateString = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(introducedDiscontinuedField)).sendKeys(dateString);
        wait.until(ExpectedConditions.textToBePresentInElementValue(introducedDiscontinuedField, dateString));
        return this;
    }

    @Step("select value for Company field ")
    public AddComputerPage selectCompany(String idOfCompany) {
        WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), 5);
        companyField.selectByVisibleText(idOfCompany);
        wait.until(driver -> idOfCompany.equals(companyField.getFirstSelectedOption().getText()));
        return this;
    }

    @Step("click on 'Create computer' button ")
    public MainPage createComputer() {
        btnCreateComputer.submit();
        return PageFactory.initElements(driver, MainPage.class);
    }

}
