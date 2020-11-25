package abTest;

import io.qameta.allure.Description;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewComputer extends BaseTest {
    public String titleOfCOmputer = "Apolo12";

    @Test
    @Description(value = "test check add a new computer to Database")
    public void testCheckAddNewComputer() throws InterruptedException {
        MainPage mainPage = PageFactory.initElements(WebDriverProvider.getWebDriver(), abTest.MainPage.class);
        AddComputerPage addComputerPage = mainPage.presenceOfDataBaseTable().clickOnAddNewComputer();
        String currentDate = addComputerPage.getCurrentDate();
        String oldDate = addComputerPage.getOldDate(10);
        addComputerPage.presenceMainAddForm().setComputerName(titleOfCOmputer).setIntroducedDate(oldDate).setDiscontinuedDate(currentDate).selectCompany("Apple Inc.")
                .clickOnBtnCreateComputer().presenceOfDataBaseTable();
        String resultOfSearch = mainPage.getResultOfSearch(titleOfCOmputer);
        Assert.assertEquals(resultOfSearch, titleOfCOmputer);
        System.out.println();

    }

}
