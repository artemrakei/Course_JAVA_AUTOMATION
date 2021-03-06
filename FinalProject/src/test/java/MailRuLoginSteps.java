import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Attachment;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;

public class MailRuLoginSteps {
    private static final String MAIN_URL = "http://mail.ru";
    private MailRuLoginPage mailRuLoginPage;
    private WebDriver webDriver;

    public MailRuLoginSteps() throws SQLException {
        webDriver = Singleton.getInstance().getWebDriver();
        mailRuLoginPage = new MailRuLoginPage(webDriver);
    }

    @Given("^I am on main application page$")
    public void loadMainPage() {
        webDriver.get(MAIN_URL);
    }

    @When("^I login as correct user$")
    public void loginAsCorrectUser() throws SQLException {
        mailRuLoginPage.enterLogin(1);
        mailRuLoginPage.enterPass(1);
        mailRuLoginPage.clickEnterButton();
    }

    @When("^I login as user with \"([^\"]*)\" XML$")
    public void loginAsCorrectUserXML(String id) throws ParserConfigurationException, SAXException, IOException {
        mailRuLoginPage.enterLoginXML(Integer.parseInt(id));
        mailRuLoginPage.enterPassXML(Integer.parseInt(id));
        mailRuLoginPage.clickEnterButton();
    }

    @When("^I login as user with \"([^\"]*)\"$")
    public void loginCorrectUser(String number) throws SQLException {
        mailRuLoginPage.enterLogin(Integer.parseInt(number));
        mailRuLoginPage.enterPass(Integer.parseInt(number));
        mailRuLoginPage.clickEnterButton();
    }

    @When("^I login as user with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void loginAsUserWithCredentials(String number) throws SQLException {
        mailRuLoginPage.enterLogin(Integer.parseInt(number));
        mailRuLoginPage.clickEnterButton();
    }

    @When("I see logout link")
    public void seeLogoutLink() {
        Assert.assertTrue(mailRuLoginPage.logoutLinkPresents());
    }

    @When("I click logout link")
    public void clickLogoutLink() {
        mailRuLoginPage.clickLogoutLink();
    }

    @When("^I choice contacts$")
    public void choiceContacts() {
        mailRuLoginPage.clickContactsLink();
        mailRuLoginPage.clickSelectedToContacts();
    }

    @When("^I write message$")
    public void writeMessage() {
        mailRuLoginPage.clickButtonWrite();
        mailRuLoginPage.enterTheme("Test message");
        mailRuLoginPage.clickSendGroupMessage();
    }

    @When("^I mark flags messages$")
    public void markMessage() {
        mailRuLoginPage.choiceLetter();
        mailRuLoginPage.markFlagMessages();
    }

    @When("^I choice marked messages$")
    public void markedMessage() {
        mailRuLoginPage.markedMessage();
        mailRuLoginPage.chooseAllMessage();
    }

    @When("^I unmarked message$")
    public void unmarkedMessage() {
        mailRuLoginPage.unmarkFlagMessages();
    }

    @Then("I see registration link")
    public void seeRegLink() {
        Assert.assertTrue(mailRuLoginPage.seeRegLink());
    }

    @Then("I see error message")
    public void seeErrorMessage() {
        Assert.assertTrue(mailRuLoginPage.logoutLinkErrorPresents());
    }

    @Then("I see that message was send")
    public void seeSendMessage() {
        Assert.assertTrue(mailRuLoginPage.sendMessagePresents());
    }

    @Then("I see marked messages")
    public void markedMessages() {
        Assert.assertTrue(mailRuLoginPage.visibleFlag());
    }

    @Then("I dont see marked messages")
    public void unmarkedMessages() {
        Assert.assertFalse(mailRuLoginPage.visibleFlag());
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @After
    public void afterClass() {

        Singleton.quit();
    }
}
