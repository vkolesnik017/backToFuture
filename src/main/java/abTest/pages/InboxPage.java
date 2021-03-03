package abTest.pages;

import abTest.WebDriverProvider;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class InboxPage {
    private WebDriver driver = WebDriverProvider.getWebDriver();

    By btnWriteLetter = By.xpath("//div[@class='T-I T-I-KE L3']");

    By expectedLetter = By.xpath("//div[@class='yW']//span[@class='zF']");

    By checkBoxAllLetters = By.xpath("//div[@class='bzn']/div/div[1]//span");

    By btnDeleteLetter = By.xpath("//div[@class='T-I J-J5-Ji nX T-I-ax7 T-I-Js-Gs mA']");

    By infoPopUp = By.xpath("//div[@class='b8 UC bAp']/div/div[2]");

    @Step("click button  'Write Letter' ")
    public NewEmailPage clickBtnWriteLetter() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnWriteLetter))).click();
        return new NewEmailPage();
    }

    @Step("displaying letter from expected email")
    public boolean displayLetterByEmail(String expectedEmail) {
        boolean label;
        List<WebElement> listOfLetters = driver.findElements(expectedLetter);
        List<String> attributeOfLetters = listOfLetters.stream().map(attr -> attr.getAttribute("email")).collect(Collectors.toList());
        label = attributeOfLetters.contains(expectedEmail) ? true : false;
        return label;
    }

    @Step("delete letter")
    public InboxPage deleteLetter() {
        driver.findElement(checkBoxAllLetters).click();
        driver.findElement(btnDeleteLetter).click();
        return this;
    }

    @Step("displaying of information pop-up")
    public InboxPage displayOfInfoPopUp() {
        WebDriverWait wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(infoPopUp)));
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(driver.findElement(infoPopUp))));
        return this;
    }

}
