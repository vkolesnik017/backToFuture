package abTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverProvider {

    private static WebDriver webDriver;

    private WebDriverProvider() {
    }

    public static synchronized WebDriver getWebDriver() {
        if (webDriver == null) {
            System.setProperty("webdriver.chrome.driver", "D:\\JavaProject\\ab_task\\driver\\chromedriver.exe");
            webDriver = new ChromeDriver();
        }
        return webDriver;
    }
}
