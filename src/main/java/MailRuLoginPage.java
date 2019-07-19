import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;

public class MailRuLoginPage {
    private static final int LINK_PRESENSE_TIMEOUT = 10;
    private static final Logger log = Logger.getLogger(MailRuLoginPage.class);

    private WebDriver driver;
    private int numberIncomingLetters;
    private int numberIncomingLetters1;
    private boolean result = false;
    private Operations operations = new Operations();
    private SaxParserMailRu saxParserMailRu = new SaxParserMailRu();


    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='mailbox:submit']/input")
    private WebElement buttonEnter;

    @FindBy(id = "PH_logoutLink")
    private WebElement logoutLink;

    @FindBy(xpath = "//*[@id='mailbox:error']")
    public WebElement logoutLinkError;

    @FindBy(xpath = "(.//div[@class='b-datalist__item__body'])[1]/a/div/div/div")
    private WebElement choiceLetter1;

    @FindBy(xpath = "(.//div[@class='b-datalist__item__body'])[2]/a/div/div/div")
    private WebElement choiceLetter2;

    @FindBy(xpath = "(.//div[@class='b-datalist__item__body'])[3]/a/div/div/div")
    private WebElement choiceLetter3;

    @FindBy(xpath = "(.//div[@class=\"b-datalist b-datalist_letters b-datalist_letters_from\"])[2]/div[2]/div[1]/div/a/div/div/div")
    private WebElement choiceLetterInSpam1;

    @FindBy(xpath = "(.//div[@class=\"b-datalist b-datalist_letters b-datalist_letters_from\"])[2]/div[2]/div[2]/div/a/div/div/div")
    private WebElement choiceLetterInSpam2;

    @FindBy(xpath = "(.//div[@class=\"b-datalist b-datalist_letters b-datalist_letters_from\"])[2]/div[2]/div[3]/div/a/div/div/div")
    private WebElement choiceLetterInSpam3;

    @FindBy(xpath = "//*[@id=\"b-nav_folders\"]/div/div[1]/a/span[1]")
    private WebElement incomingLetters;

    @FindBy(xpath = ".//div[@id=\"LEGO\"]/div[3]/div/div/div/div[6]/a")
    private WebElement spamLink;

    @FindBy(id = "PH_regLink")
    private WebElement regLink;


    public MailRuLoginPage(WebDriver webdriver) throws SQLException, IOException, SAXException, ParserConfigurationException {
        log.info("Initial WebDriver");
        PageFactory.initElements(webdriver, this);
        this.driver = webdriver;
    }

    public void enterLogin(int number) throws SQLException {
        log.info("Enter Login");

        String login = operations.getLogin(number);
        loginField.clear();
        loginField.sendKeys(login);
    }

    public void enterPass(int number) throws SQLException {
        log.info("Enter Password");
        String password = operations.getPassword(number);
        passwordField.clear();
        passwordField.sendKeys(password);

    }
    public void enterLoginXML(int id) throws IOException, SAXException, ParserConfigurationException {
        log.info("Enter Login");
        String login = saxParserMailRu.saxParserLogin(id);
        loginField.clear();
        loginField.sendKeys(login);
    }

    public void enterPassXML(int id) throws IOException, SAXException, ParserConfigurationException {
        log.info("Enter Password");
        String password = saxParserMailRu.saxParserPassword(id);
        passwordField.clear();
        passwordField.sendKeys(password);

    }

    public void clickEnterButton() {
        log.info("Click Enter after entry Login and Password");
        buttonEnter.click();
    }

    public boolean logoutLinkPresents() {
        log.info("Here we see 'Logout Link'");

        return (new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT)).until(ExpectedConditions.visibilityOf(logoutLink))
                .isDisplayed();
    }

    public boolean logoutLinkErrorPresents() {
        log.info("Here we are not logged in");

        return (new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(logoutLinkError)).isDisplayed());

    }

    public void choiceLetter() {
        log.info("Choice three mails");
        new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT).until(ExpectedConditions.visibilityOf(choiceLetter1))
                .isDisplayed();
        choiceLetter1.click();
        choiceLetter2.click();
        choiceLetter3.click();
    }

    public void choiceLetterInSpam() {
        log.info("Choice three mails in Spam");

        new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT).until(ExpectedConditions.visibilityOf(choiceLetterInSpam1))
                .isDisplayed();
        choiceLetterInSpam1.click();
        choiceLetterInSpam2.click();
        choiceLetterInSpam3.click();
    }

    public void movingInSpam() throws InterruptedException {
        log.info("Moving mails in Spam");

        numberIncomingLetters = Integer.parseInt(incomingLetters.getText().trim());
//        System.out.println(numberIncomingLetters);
        driver.switchTo().activeElement().sendKeys("j");
        Thread.sleep(1000);
    }

    public boolean decreaseLetters() {
        log.info("Here we see decrease incoming mails");

        numberIncomingLetters1 = Integer.parseInt(incomingLetters.getText().trim());
//        System.out.println(numberIncomingLetters1);
        if (numberIncomingLetters > numberIncomingLetters1) {
            result = true;

        }
        return result;
    }

    public void moveToSpam() {
        log.info("Here we moving mails in Spam");
        new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT).until(ExpectedConditions.visibilityOf(spamLink))
                .isDisplayed();
        spamLink.click();
    }

    public void clickLogoutLink() {
        log.info("Here we click 'Logout Link'");
        new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT).until(ExpectedConditions.elementToBeClickable(logoutLink));
        logoutLink.click();
    }

    public boolean seeRegLink() {
        log.info("Here we see link of Registration");
        return (new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(regLink)).isDisplayed());
    }


}

