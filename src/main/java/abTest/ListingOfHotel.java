package abTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ListingOfHotel {
    WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), 5);
    @FindBy(how = How.XPATH, xpath = "//ul[@class='sort_option_list sort_option_list--a11y']")
    WebElement filterBlock;

    @FindBy(how = How.XPATH, xpath = "//ul[@class='sort_option_list sort_option_list--a11y']/li")
    List<WebElement> filterLinks;

    @FindBy(how = How.XPATH, xpath = "//*[contains(text(),'Получите доступ к более низким ценам')]")
    WebElement loader;


    public ListingOfHotel selectPriceSorting() {
        wait.until(ExpectedConditions.visibilityOf(filterBlock));
        filterLinks.get(2).click();
        wait.until(ExpectedConditions.visibilityOf(loader));
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(loader)));
        return this;
    }
}
