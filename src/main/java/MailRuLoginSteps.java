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

public class MailRuLoginSteps {
    private static final String MAIN_URL = "http://mail.ru";
    private MailRuLoginPage mailRuLoginPage;
    private WebDriver webDriver;

    public MailRuLoginSteps() throws SQLException, ParserConfigurationException, SAXException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Courses\\chromedriver.exe");
        webDriver = new ChromeDriver();
        mailRuLoginPage = new MailRuLoginPage(webDriver);
    }

    @Given("^I am on main application page$")
    public void loadMainPage() {
        webDriver.get(MAIN_URL);
    }

    @When("^I login as correct user$")
    public void loginAsCorrectUser() {
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
    @When("^I login as user with \"([^\"]*)\" XML$")
    public void loginAsCorrectUserXML(String id) throws ParserConfigurationException, SAXException, IOException {
        mailRuLoginPage.enterLoginXML(Integer.parseInt(id));
        mailRuLoginPage.enterPassXML(Integer.parseInt(id));
        mailRuLoginPage.clickEnterButton();
    }

    @When("^I login as user with \"([^\"]*)\"$")
    public void loginCorrectUser(String number) {
        try {
            mailRuLoginPage.enterLogin(Integer.parseInt(number));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            mailRuLoginPage.enterPass(Integer.parseInt(number));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        mailRuLoginPage.clickEnterButton();
    }

    @When("^I login as user with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void loginAsUserWithCredentials(String number) {
        try {
            mailRuLoginPage.enterLogin(Integer.parseInt(number));
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    @Then("I see registration link")
    public void seeRegLink() {
        Assert.assertTrue(mailRuLoginPage.seeRegLink());
    }


    @Then("I see error message")
    public void seeErrorMessage() {

        Assert.assertTrue(mailRuLoginPage.logoutLinkErrorPresents());
    }

    @After
    public void afterClass() {
        webDriver.quit();
    }
}
