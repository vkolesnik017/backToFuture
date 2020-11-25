package abTest;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver = WebDriverProvider.getWebDriver();

    @FindBy(how = How.XPATH, xpath = "//table[@class='computers zebra-striped']")
    WebElement databaseTable;

    @FindBy(how = How.ID, id = "add")
    WebElement btnAddNewComputer;

    @FindBy(how = How.ID, id = "searchbox")
    WebElement searchField;

    @FindBy(how = How.ID, id = "searchsubmit")
    WebElement btnSearch;

    @FindBy(how = How.XPATH, xpath = "//div[@class='well']")
    WebElement noResult;

    @FindBy(how = How.XPATH, xpath = "//table[@class='computers zebra-striped']//tr/td[1]/a")
    WebElement foundComputer;

    @FindBy(how = How.XPATH, xpath = "//div[@class='alert-message warning']")
    WebElement successfulMessage;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://computer-database.gatling.io/computers");
    }

    @Description("Presence of Database table")
    public MainPage presenceOfDataBaseTable() {
        WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(databaseTable));
        return this;
    }

    @Description("click on Add a New Computer button")
    public AddComputerPage clickOnAddNewComputer() {
        WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(btnAddNewComputer)).click();
        return PageFactory.initElements(driver, AddComputerPage.class);
    }

    @Description("presence of added computer message")
    public MainPage presenceOfAddedComputerMessage() {
        WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(successfulMessage));
        return this;
    }

    @Description("get result of search")
    public String getResultOfSearch(String titleOfComputer) {
        WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(searchField)).sendKeys(titleOfComputer);
        btnSearch.click();
        String resultOfSearch;
        if (noResult.isDisplayed()) {
            resultOfSearch = " ";
        } else {
            wait.until(ExpectedConditions.visibilityOf(foundComputer));
            resultOfSearch=foundComputer.getText();
        }
        return resultOfSearch;
    }
}
