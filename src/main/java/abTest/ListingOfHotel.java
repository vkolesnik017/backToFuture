package abTest;

import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ListingOfHotel {
    WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), 5);
    @FindBy(how = How.XPATH, xpath = "//ul[@class='sort_option_list sort_option_list--a11y']")
    WebElement filterBlock;

    @FindBy(how = How.XPATH, xpath = "//ul[@class='sort_option_list sort_option_list--a11y']/li")
    List<WebElement> filterLinks;

    @FindBy(how = How.XPATH, xpath = "//div[@class='sr-usp-overlay__title']")
    WebElement loader;

    @FindBy(how = How.XPATH, xpath = "//span[contains(@class,'sr-hotel__name')]")
    List<WebElement> titleOfHotels;

    @FindBy(how = How.XPATH, xpath = "//div[@class='bui-price-display__value prco-text-nowrap-helper prco-inline-block-maker-helper']")
    List<WebElement> priceList;

    @Description("Select sorting price from minimal to max")
    public ListingOfHotel selectPriceSorting() {
        String firstCurrentHotel;
        wait.until(visibilityOf(filterBlock));
        firstCurrentHotel = titleOfHotels.get(0).getText();
        filterLinks.get(2).click();
        // wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'sr-hotel__name')]"), firstCurrentHotel));
        //   wait.until(ExpectedConditions.visibilityOf(loader));
        //  wait.until(ExpectedConditions.invisibilityOf(loader));
        return this;
    }

    public ListingOfHotel checkSortingPrice() {
        List<Integer> priceBeforeSorting = new ArrayList<Integer>();

        for (int i = 0; i < priceList.size(); i++) {
            priceBeforeSorting.add(Integer.parseInt(priceList.get(i).getText().replaceAll("[^0-9]", "")));
        }

        for (int e : priceBeforeSorting) {
            System.out.println(e);
        }
        return this;
    }

}
