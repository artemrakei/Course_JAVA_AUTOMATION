import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.sql.SQLException;


public class MailRuMovingInSpamSteps {
    private static final String MAIN_URL = "http://mail.ru";
    private WebDriver webDriver;
    private MailRuLoginPage mailRuLoginPage;

    public MailRuMovingInSpamSteps() throws SQLException {
        webDriver = Singleton.getInstance().getWebDriver();
        mailRuLoginPage = new MailRuLoginPage(webDriver);
    }


    @Given("^I am on main Mail.ru page and login as correct user$")
    public void loadMainPage() throws SQLException {
        webDriver.get(MAIN_URL);
        mailRuLoginPage.enterLogin(1);
        mailRuLoginPage.enterPass(1);
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
    public void movingInSpam() {
        mailRuLoginPage.movingInSpam();
    }

    @Then("I see decrease incoming letters")
    public void seeDecreaseLetters() {
        Assert.assertTrue(mailRuLoginPage.decreaseLetters());
    }

    @Then("I see increase incoming letters")
    public void seeIncreaseLetters() throws InterruptedException {
        Assert.assertTrue(mailRuLoginPage.increaseLetters());
    }


    @After
    public void afterClass1() {
        Singleton.quit();
    }
}
