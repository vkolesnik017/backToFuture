package abTest;

import abTest.pages.AddComputerPage;
import abTest.pages.MainPage;
import io.qameta.allure.Description;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class AddNewComputer extends BaseTest {
    @Test
    @Description(value = "test check add a new computer to Database")
    public void testCheckAddNewComputer() {
        String computerTitle = "GEFER";
        MainPage mainPage = PageFactory.initElements(WebDriverProvider.getWebDriver(), MainPage.class);
        AddComputerPage addComputerPage = mainPage.open("http://computer-database.gatling.io/computers").addNewComputer();
        LocalDate currentDate = LocalDate.now();
        LocalDate oldDate = currentDate.minusYears(10);
        String resultOfSearch = addComputerPage
                .setComputerName(computerTitle)
                .setIntroducedDate(oldDate)
                .setDiscontinuedDate(currentDate)
                .selectCompany("Apple Inc.")
                .createComputer()
                .searchForComputer(computerTitle);
        Assert.assertEquals(resultOfSearch, computerTitle, String.format("Computer %s is absent", computerTitle));
    }
}
