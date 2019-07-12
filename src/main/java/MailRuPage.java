import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MailRuPage {
    private static final int BUTTON_PRESENSE_TIMEOUT = 10;


    private WebDriver driver;

    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='mailbox:submit']/input")
    private WebElement buttonEnter;

    @FindBy(xpath = "//*[@id=\"b-toolbar__left\"]/div/div/div[2]")
    private WebElement buttonWrite;

    @FindBy(xpath = "((.//div[@id=\"b-letters\"]/div/div)[2]/div/div)[2]/div/div/a/div/div/div")
    private WebElement chooseEmail;

    @FindBy(xpath = "(((.//div[@id=\"b-letters\"]/div/div)[2]/div/div)[2]/div)[2]/div/a/div/div/div")
    private WebElement chooseEmail2;

    @FindBy(xpath = "(((.//div[@id=\"b-letters\"]/div/div)[2]/div/div)[2]/div)[3]/div/a/div/div/div")
    private WebElement chooseEmail3;

    @FindBy(xpath = "((.//div[@id=\"b-letters\"]/div/div)[5]/div/div)[2]/div/div/a/div/div/div")
    private WebElement chooseEmailInSpam;

    @FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[2]/div/div[2]/div[3]/div")
    private WebElement moveInSpam;

    @FindBy(xpath = "//*[@id=\"b-nav_folders\"]/div/div[1]/a/span[1]")
    private WebElement countIncoming;

    @FindBy(xpath = "(.//div[@id=\"b-nav_folders\"]/div/div)[6]")
    private WebElement spamLink;

    @FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[3]/div/div[2]/div[3]/div")
    private WebElement notSpam;

    @FindBy(xpath = "//*[@id=\"portal-menu\"]/div[2]/div/div[1]/div[2]/div/span/span[2]/span[2]/a")
    private WebElement contactsLink;

    @FindBy(xpath = "(.//div[@class=\"messagelist-wrapper\"]/div/div/div)[1]/label/input")
    private WebElement choiceContact1ToGroup;

    @FindBy(xpath = "(.//div[@class=\"messagelist-wrapper\"]/div/div/div)[4]/label/input")
    private WebElement choiceContact2ToGroup;

    @FindBy(xpath = "//*[@id=\"js-send-to-contacts\"]")
    private WebElement buttonWriteGroupMessage;

    @FindBy(xpath = "(((.//div[@class=\"compose-head\"]/div)[3]/div)[4]/div/div/div)[2]/div/input")
    private WebElement themeMail;

    @FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div/div/div[2]/div[1]/div")
    private WebElement sendGroupMessage;

    @FindBy(xpath = "//*[@id=\"MailRuConfirm\"]/div/div[2]/form/div[2]/button[1]")
    private WebElement confirmSend;

    @FindBy(xpath = ".//div[@class=\"message-sent message-sent_IsSocialConnect\"]")
    private WebElement messageWasSend;

    @FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[2]/div/div[2]/div[5]/div/div[2]/div[1]")
    private WebElement beforeMarkFlag;

    @FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[2]/div/div[2]/div[5]/div/div[2]/div[2]/a[4]")
    private WebElement markFlag;

    @FindBy(xpath = "//*[@id=\"b-letters\"]/div/div[2]/div/div[2]/div[1]/div/a/div[3]/div")
    private WebElement flag;

    @FindBy(xpath = ".//div[@id=\"b-toolbar__right\"]/div[2]/div/div/div[2]/div/div[2]")
    private WebElement marked;

    @FindBy(xpath = "(.//div[@class=\"b-dropdown__ctrl\"])[2]/div/div[1]")
    private WebElement chooseAllMessages;

    @FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[2]/div/div[2]/div[5]/div/div[2]/div[2]/a[4]")
    private WebElement unmarkedFlag;

    @FindBy(xpath = "//*[@id=\"b-letters\"]/div/div[2]/div/div[2]/div/div/div/div[2]/span")
    private WebElement noMessageInFilters;

    int beforeSpam;

    public MailRuPage(WebDriver webdriver) {
        PageFactory.initElements(webdriver, this);
        this.driver = webdriver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void enterLoginAndPass(String login, String password) {
        loginField.clear();
        loginField.sendKeys(login);
        passwordField.clear();
        passwordField.sendKeys(password);

    }

    public void clickEnterButton() {
        buttonEnter.click();
    }

    public boolean buttonPresents() {
        return (new WebDriverWait(driver, BUTTON_PRESENSE_TIMEOUT)).until(ExpectedConditions.visibilityOf(buttonWrite))
                .isDisplayed();
    }

    public void choiceEmail() {
        chooseEmail.click();
    }

    public void choiceEmailSpam() {
        chooseEmailInSpam.click();
    }

    public int moveMailInSpam() {
        beforeSpam = Integer.parseInt(countIncoming.getText());
        moveInSpam.click();
        return beforeSpam;
    }

    public boolean decreaseOfIncomingMessages() throws InterruptedException {
        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
        int afterSpam = Integer.parseInt(countIncoming.getText());
        if (beforeSpam > afterSpam) {
            return true;
        } else {
            return false;
        }
    }

    public void goInSpam() {
        spamLink.click();
    }

    public void moveNotSpam() {
        beforeSpam = Integer.parseInt(countIncoming.getText());
        notSpam.click();
    }

    public boolean increaseOfIncomingMessages() throws InterruptedException {
        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);

        int afterSpam = Integer.parseInt(countIncoming.getText());
        if (beforeSpam < afterSpam) {
            return true;
        } else {
            return false;
        }
    }

    public void clickContactsLink() {
        contactsLink.click();
    }

    public void clickSelectedToContacts() {
        choiceContact1ToGroup.click();
        choiceContact2ToGroup.click();
    }

    public void clickButtonWrite() {
        buttonWriteGroupMessage.click();
    }

    public void enterTheme(String theme) {
        themeMail.click();
        themeMail.clear();
        themeMail.sendKeys(theme);
    }


    public void clickSendGroupMessage() {
        sendGroupMessage.click();
        confirmSend.click();
    }

    public boolean sendMessagePresents() {
        return (new WebDriverWait(driver, BUTTON_PRESENSE_TIMEOUT)).until(ExpectedConditions.visibilityOf(messageWasSend))
                .isDisplayed();
    }

    public void chooseThreeMessages() {
        chooseEmail.click();
        chooseEmail2.click();
        chooseEmail3.click();
    }

    public void markFlagMessages() {
        beforeMarkFlag.click();
        markFlag.click();
    }

    public boolean visibleFlag() {
        return (new WebDriverWait(driver, BUTTON_PRESENSE_TIMEOUT)).until(ExpectedConditions.visibilityOf(flag))
                .isDisplayed();
    }

    public void markedMessage() {
        marked.click();
    }

    public void chooseAllMessage() {
        chooseAllMessages.click();
    }

    public void unmarkFlagMessages() {
        beforeMarkFlag.click();
        unmarkedFlag.click();
    }


    public boolean visibleMessageFilter() {
        return (new WebDriverWait(driver, BUTTON_PRESENSE_TIMEOUT)).until(ExpectedConditions.visibilityOf(noMessageInFilters))
                .isDisplayed();
    }

}
