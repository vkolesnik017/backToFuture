package abTest;

import abTest.pages.InboxPage;
import abTest.pages.MainPage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static abTest.CommonMethods.openPage;

public class LogInGmail extends BaseTest {
    private InboxPage inboxPage = new InboxPage();
    String email = "eisgroupgeffer@gmail.com";
    String password = "GefferTest";
    String emailSubject = "EIS_Group";

    @Test
    @Description(value = "the test checks sending and removing a letter")
    public void testCheckSendAndRemoveLetter() {

        openPage("https://mail.google.com");

        new MainPage()
                .setEmail(email)
                .clickBtnNext()
                .setPassword(password)
                .clickBtnNext()
                .clickBtnWriteLetter()
                .setEmailSubject(emailSubject)
                .setRecipientOfEmail(email)
                .setTextForEmail("Hello EIS_Group")
                .clickSendEmail()
                .displayOfInfoPopUp();
        Assert.assertTrue(inboxPage.displayLetterByEmail(email), String.format("There is no letter from %s", email));
        inboxPage.deleteLetter();
        Assert.assertFalse(inboxPage.displayLetterByEmail(email), String.format("A letter from %s is present", email));
    }
}
