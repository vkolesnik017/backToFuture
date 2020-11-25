package abTest;

import io.qameta.allure.Description;
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

    @FindBy(how = How.ID, id = "main")
    WebElement mainForm;


    @Description("set value for 'Computer name' field")
    public AddComputerPage setComputerName(String computerName) throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(computerNameField)).sendKeys(computerName);
        wait.until(ExpectedConditions.textToBePresentInElementValue(computerNameField, computerName));
        return this;
    }

    @Description("set value for 'Introduced date' field")
    public AddComputerPage setIntroducedDate(String date) {
        WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(introducedDateField)).sendKeys(date);
        wait.until(ExpectedConditions.textToBePresentInElementValue(introducedDateField, date));
        return this;
    }

    @Description("set value for 'Introduced date' field")
    public AddComputerPage setDiscontinuedDate(String date) {
        WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(introducedDiscontinuedField)).sendKeys(date);
        wait.until(ExpectedConditions.textToBePresentInElementValue(introducedDiscontinuedField, date));
        return this;
    }

    @Description("get current date")
    public String getCurrentDate() {
        LocalDate date = LocalDate.now();
        return String.valueOf(date);
    }

    @Description("get current date")
    public String getOldDate(int years) {
        LocalDate date = LocalDate.now();
        String oldDate = String.valueOf(date.minusYears(years));
        return oldDate;
    }

    @Description("select value for Company field ")
    public AddComputerPage selectCompany(String idOfCompany) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), 5);
        companyField.selectByVisibleText(idOfCompany);
        wait.until(driver -> idOfCompany.equals(companyField.getFirstSelectedOption().getText()));
        return this;
    }

    @Description("click on 'Create computer' button ")
    public MainPage clickOnBtnCreateComputer() {
        btnCreateComputer.submit();
        return PageFactory.initElements(driver, MainPage.class);
    }

    @Description("presence Main form for adding a new computer ")
    public AddComputerPage presenceMainAddForm() {
        WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(mainForm));
        return this;
    }

}
