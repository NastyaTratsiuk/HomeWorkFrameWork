import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.*;

public class TestDemoqa extends BaseTest {

    @Test
    public void checkAlert() {
        BaseBrowser.toUrl();
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isPageOpen(), "Home page isn't open");
        homePage.ckickAlertsFrameWindowsBtn();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        alertsFrameWindowsPage.clickAlertBtn();
        Assert.assertEquals(alertsFrameWindowsPage.getCheckPageHeaderMain(), "Alerts",
                "Alerts form isn't open");
        AlertClass alertPage = new AlertClass();
        alertsFrameWindowsPage.clickClikButtonToSeeAlert();
        Assert.assertEquals(alertPage.alertMessage(), "You clicked a button", "Alert closed or opened with different text");
        alertPage.clickOkAlert();
        Assert.assertFalse(alertPage.isAlertPresent(), "Alert still open");
        alertsFrameWindowsPage.clickOnButtonClickConfirmBoxWillAppear();
        Assert.assertEquals(alertPage.alertMessage(), "Do you confirm action?", "Alert closed or opened with different text");
        alertPage.clickOkAlert();
        Assert.assertFalse(alertPage.isAlertPresent(), "Alert still open");
        Assert.assertEquals(alertsFrameWindowsPage.checkYouSelectedOK(), "You selected Ok",
                "Alerts form isn't open");
        alertsFrameWindowsPage.clickOnButtonClickPromptBoxWillAppear();
        Assert.assertEquals(alertPage.alertMessage(), "Please enter your name", "Alert closed or opened with different text");
        RandomClass randomClass = new RandomClass();
        alertsFrameWindowsPage.inputRandomTextInAlert(randomClass.generateString());
        alertPage.clickOkAlert();
        Assert.assertFalse(alertPage.isAlertPresent(), "Alert still open");
        Assert.assertEquals(alertsFrameWindowsPage.checkRandomText(), ("You entered " + alertsFrameWindowsPage.getRandomText()),
                "The text does not match what was entered in the alert");
    }

    @Test
    public void checkIframe() {
        BaseBrowser.toUrl();
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isPageOpen(), "Home page isn't open");
        homePage.ckickAlertsFrameWindowsBtn();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        alertsFrameWindowsPage.clickNestedFramesBtn();
        Assert.assertEquals(alertsFrameWindowsPage.getCheckPageHeaderMain(), "Nested Frames",
                "Iframe s form isn't open");
        Assert.assertEquals(alertsFrameWindowsPage.parentFrameText(), "Parent frame",
                "Iframe closed or opened with different text");
        Assert.assertEquals(alertsFrameWindowsPage.childFrameText(), "Child Iframe",
                "Iframe closed or opened with different text");
        alertsFrameWindowsPage.clickFrameBtn();
        Assert.assertEquals(alertsFrameWindowsPage.getCheckPageHeaderMain(), "Frames",
                "Frames form isn't open");
        Assert.assertEquals(alertsFrameWindowsPage.upperFrameText(), alertsFrameWindowsPage.lowerFrameText(),
                "Frames have different text");
    }

    @Test(dataProvider = "testUsers", dataProviderClass = DataProviderUser.class)
    public void checkTables(User user) {
        BaseBrowser.toUrl();
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isPageOpen(), "Home page isn't open");
        homePage.ckickElementsBtn();
        ElementsPage elementsPage = new ElementsPage();
        Assert.assertEquals(elementsPage.getCheckPageHeaderMain(), "Elements",
                "Elements form isn't open");
        elementsPage.clickWebTablesBtn();
        elementsPage.clickAddBtn();
        Assert.assertTrue(elementsPage.isUserFormDisplayed(), "User form isn't displayed");
        elementsPage.addUsers(user);
        elementsPage.clickSubmitBtn();
        Assert.assertTrue(elementsPage.isCheckUserFormClose(), "User form is displayed");
        Assert.assertEquals(elementsPage.getUserWebTableFirstName(), user.getFirstName(),
                "First name doesn't match");
        Assert.assertEquals(elementsPage.getUserWebTableLastName(), user.getLastName(),
                "Last name doesn't match");
        Assert.assertEquals(elementsPage.getUserWebTableEmail(), user.getEmail(),
                "First name doesn't match");
        elementsPage.deleteUserWebTable();
        Assert.assertNotEquals(elementsPage.getSizeUsersWebTableAfterAdd(), elementsPage.getSizeUsersWebTableAfterDelete(),
                "The number of users in the table has not changed");
        Assert.assertEquals(elementsPage.getUserWebTableFirstName(), " ",
                "First name doesn't empty");
        Assert.assertEquals(elementsPage.getUserWebTableLastName(), " ",
                "Last name doesn't empty");
        Assert.assertEquals(elementsPage.getUserWebTableEmail(), " ",
                "Email name doesn't empty");
    }

    @Test
    public void checkHandles() {
        BaseBrowser.toUrl();
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isPageOpen(), "Home page isn't open");
        homePage.ckickAlertsFrameWindowsBtn();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        alertsFrameWindowsPage.clickBrowserWindowsBtn();
        Assert.assertEquals(alertsFrameWindowsPage.getCheckPageHeaderMain(), "Browser Windows",
                "Browser Windows form isn't open");
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
        browserWindowsPage.clickNewTabBtn();
        SamplePage samplePage = new SamplePage();
        Assert.assertTrue(samplePage.isDisplay());
        samplePage.closeSample();
        Assert.assertEquals(alertsFrameWindowsPage.getCheckPageHeaderMain(), "Browser Windows",
                "Browser Windows form isn't open");
        browserWindowsPage.clickElementsBtn();
        browserWindowsPage.clicklinksBtn();
        Assert.assertEquals(browserWindowsPage.getCheckPageHeaderMain(), "Links");
        LinksPage linksPage = new LinksPage();
        linksPage.clickHomeBtn();
        linksPage.switchHomePage();
        Assert.assertTrue(homePage.isPageOpen(), "Home page isn't open");
        linksPage.switchLinks();
        Assert.assertEquals(browserWindowsPage.getCheckPageHeaderMain(), "Links");
    }
}


