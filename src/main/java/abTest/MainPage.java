package abTest;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends MainPageLogic {
    private WebDriver driver = WebDriverProvider.getWebDriver();
    WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), 5);
    @FindBy(how = How.NAME, name = "ss")
    WebElement cityField;

    @FindBy(how = How.XPATH, xpath = "//div[@class='xp__dates-inner']")
    WebElement dateField;

    @FindBy(how = How.XPATH, xpath = "//div[@class='bui-calendar']")
    WebElement calendarDropMenu;

    @FindBy(how = How.XPATH, xpath = "//div[@class='bui-calendar__wrapper'][1]/table//span[contains(text(),'29')]")
    WebElement firstDate;

    @FindBy(how = How.XPATH, xpath = "//div[@class='bui-calendar__wrapper'][2]/table//span[contains(text(),'18')]")
    WebElement lastDate;

    @FindBy(how = How.XPATH, xpath = "//button[@class='sb-searchbox__button ']")
    WebElement btnSearch;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.booking.com/");
    }

  @Description("Select city for order of Hotel")
    public MainPage selectСity() {
        wait.until(ExpectedConditions.visibilityOf(cityField)).sendKeys("Rome");
        return this;
    }
    @Description("Select hotel for order")
    public ListingOfHotel selectDate() {
        dateField.click();
        wait.until(ExpectedConditions.attributeContains(calendarDropMenu, "style", "display: block;"));
        firstDate.click();
        lastDate.click();
        btnSearch.click();
        return PageFactory.initElements(driver, ListingOfHotel.class);
    }
}
