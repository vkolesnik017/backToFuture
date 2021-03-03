package abTest;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CommonMethods {

    private static WebDriver driver = WebDriverProvider.getWebDriver();

    @Step("{url} Open page with close popup")
    public static void openPage(String url) {
        driver.get(url);
    }

}
