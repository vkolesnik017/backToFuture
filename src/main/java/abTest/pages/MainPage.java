package abTest.pages;

import abTest.WebDriverProvider;
import io.qameta.allure.Step;
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

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("open page")
    public MainPage open(String url) {
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(databaseTable));
        return this;
    }

    @Step("click on Add a New Computer button")
    public AddComputerPage addNewComputer() {
        WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(btnAddNewComputer)).click();
        return PageFactory.initElements(driver, AddComputerPage.class);
    }

    @Step("get result of search")
    public String searchForComputer(String titleOfComputer) {
        WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(searchField)).sendKeys(titleOfComputer);
        btnSearch.click();
        String searchResult = "";
        if (!noResult.isDisplayed()) {
            wait.until(ExpectedConditions.visibilityOf(foundComputer));
            searchResult = foundComputer.getText();
        }
        return searchResult;
    }
}
