package abTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FiltersByTags extends BaseTest {


    @Test
    public void checkOfFiltersTagsSorting() {

        MainPage mainPage = PageFactory.initElements(WebDriverProvider.getWebDriver(), abTest.MainPage.class);
        ListingOfHotel listingPage = mainPage.selectСity().selectDate();
        listingPage.selectPriceSorting();
        System.out.println();

    }

}
