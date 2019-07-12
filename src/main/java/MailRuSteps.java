import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MailRuSteps {
    private static final String MAIN_URL = "http://mail.ru";
    private static final String LOGIN = "temka4_93";
    private static final String PASSWORD = "09R09a1993M";
    private static final String THEME = "Theme of message";
    private static final String CONTENT = "Test message";
    private MailRuPage mailRuPage;
    private WebDriver webDriver;

    public MailRuSteps() {
        System.setProperty("webdriver.chrome.driver", "C:\\Courses\\chromedriver.exe");

        webDriver = new ChromeDriver();
        mailRuPage = new MailRuPage(webDriver);
    }

    @Given("^I am on main mail.ru page$")
    public void loadMainPage() {
        webDriver.get(MAIN_URL);
    }

    @When("^I login as correct user$")
    public void loginAsCorrectUser() {
        mailRuPage.enterLoginAndPass(LOGIN, PASSWORD);
        mailRuPage.clickEnterButton();
    }


    @When("^I choose mail$")
    public void choiceMail() {
        mailRuPage.choiceEmail();
    }

    @When("^I choose 3 mail$")
    public void choiceThreeMail() {
        mailRuPage.chooseThreeMessages();
    }

    @When("^I choose mail in Spam$")
    public void choiceMailInSpam() {
        mailRuPage.choiceEmailSpam();
    }

    @When("^I click button in Spam$")
    public void clickButtonInSpam() {
        mailRuPage.moveMailInSpam();
    }

    @When("^I go in contacts$")
    public void clickLinkContacts() {
        mailRuPage.clickContactsLink();
    }

    @When("^I go in spam$")
    public void clickLinkSpam() {
        mailRuPage.goInSpam();
    }

    @When("^I click button not Spam$")
    public void clickButtonNotSpam() {
        mailRuPage.moveNotSpam();
    }

    @When("^I click selected contacts$")
    public void clickSelectedContacts() {
        mailRuPage.clickSelectedToContacts();
    }

    @When("^I click button \"Write\" group message$")
    public void clickButtonWrite() {
        mailRuPage.clickButtonWrite();
    }

    @When("^I write theme of message$")
    public void writeTheme() {
        mailRuPage.enterTheme(THEME);
    }


    @When("^I click send message$")
    public void clickSendMessage() {
        mailRuPage.clickSendGroupMessage();
    }

    @When("^I mark flag messages$")
    public void markFlag() {
        mailRuPage.markFlagMessages();
    }

    @When("^I choose marked mail$")
    public void chooseMarkedFlag() {
        mailRuPage.markedMessage();
    }


    @When("^I choose all mail in filter$")
    public void chooseAllMessages() {
        mailRuPage.chooseAllMessage();
    }

    @When("^I unmark flag messages$")
    public void unmarkFlag() {
        mailRuPage.unmarkFlagMessages();
    }


    @Then("I see button \"write letter\"")
    public void seeLogoutLink() {
        Assert.assertTrue(mailRuPage.buttonPresents());
    }

    @Then("I see decrease incoming Mails")
    public void seeDecreaseMail() throws InterruptedException {
        Assert.assertTrue(mailRuPage.decreaseOfIncomingMessages());
    }

    @Then("^I see increase incoming Mails$")
    public void seeIncreaseMail() throws InterruptedException {
        Assert.assertTrue(mailRuPage.increaseOfIncomingMessages());
    }

    @Then("I see message \"Message was send\"")
    public void seeMessageWasSend() {
        Assert.assertTrue(mailRuPage.sendMessagePresents());
    }

    @Then("I see flag on messages")
    public void seeFlag() {
        Assert.assertTrue(mailRuPage.visibleFlag());
    }

    @Then("I see messages in filter")
    public void seeMessageInFilter() {
        Assert.assertTrue(mailRuPage.visibleMessageFilter());
    }

    @After
    public void afterClass() {
        webDriver.quit();
    }
}
