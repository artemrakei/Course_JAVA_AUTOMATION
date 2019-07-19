import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;


public class MailRuMovingInSpamSteps {
    private static final String MAIN_URL = "http://mail.ru";
    private WebDriver webDriver;

    private MailRuLoginPage mailRuLoginPage;

    public MailRuMovingInSpamSteps() throws SQLException, ParserConfigurationException, SAXException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Courses\\chromedriver.exe");
        webDriver = new ChromeDriver();
        mailRuLoginPage = new MailRuLoginPage(webDriver);
    }

    @Given("^I am on main Mail.ru page and login as correct user$")
    public void loadMainPage() {
        webDriver.get(MAIN_URL);
        try {
            mailRuLoginPage.enterLogin(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            mailRuLoginPage.enterPass(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mailRuLoginPage.clickEnterButton();
    }

    @Given("^I am moving in spam$")
    public void loadSpamPage() {
        mailRuLoginPage.moveToSpam();
    }

    @When("^I choice three letters$")
    public void choiceThreeLetter() {
        mailRuLoginPage.choiceLetter();
    }

    @When("^I choice three letters in spam$")
    public void choiceThreeLetterInSpam() {
        mailRuLoginPage.choiceLetterInSpam();
    }

    @When("^I moving selected letters in or out spam$")
    public void movingInSpam() throws InterruptedException {
        mailRuLoginPage.movingInSpam();
    }

    @Then("I see decrease incoming letters")
    public void seeDecreaseLetters() {
        Assert.assertTrue(mailRuLoginPage.decreaseLetters());
    }

    @Then("I see increase incoming letters")
    public void seeIncreaseLetters() {
        Assert.assertFalse(mailRuLoginPage.decreaseLetters());
    }

    @After
    public void afterClass() {
        webDriver.quit();
    }
}
