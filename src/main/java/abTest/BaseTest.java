package abTest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        WebDriverProvider.getWebDriver().manage().window().maximize();
        WebDriverProvider.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void turnDown() {
        WebDriverProvider.getWebDriver().quit();
        System.out.println("The site is closed.");
    }
}
