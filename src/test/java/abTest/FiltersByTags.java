package abTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FiltersByTags extends BaseTest {


    @Test
    public void checkOfFiltersTagsSorting() {

        MainPage  mainPage = PageFactory.initElements(WebDriverProvider.getWebDriver(), abTest.MainPage.class);
      //  openUrl();
     //   MainPage mainPage = new MainPage();
        mainPage.selectСity().selectDate();
        System.out.println();

    }

}
