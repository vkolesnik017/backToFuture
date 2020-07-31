package abTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LkwCategoryCarList {
    private WebDriver driver = WebDriverProvider.getWebDriver();
    WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), 5);

    public LkwCategoryCarList(WebDriver driver) {
        this.driver = driver;
        driver.get("https://lkwteile.autodoc.de/ersatzteile/olfilter-200157/mercedes-benz/actros?car_id=1000784");
    }
}
