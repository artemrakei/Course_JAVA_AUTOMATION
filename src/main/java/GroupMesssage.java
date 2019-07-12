import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class GroupMesssage {

    @FindBy(xpath = "//*[@id=\"portal-menu\"]/div[2]/div/div[1]/div[2]/div/span/span[2]/span[2]")
    private WebElement contacts;

    @FindBy(xpath = "(.//div[@class=\"messagelist messagelist_contactslist messagelist_without-phones\"]/div/div)[1]/label/input")
    private WebElement conact1;

    @FindBy(xpath = "(.//div[@class=\"messagelist messagelist_contactslist messagelist_without-phones\"]/div/div)[3]/label/input")
    private WebElement contact2;

    @FindBy(id = "js-send-to-contacts")
    private WebElement writeGroupMessage;

    @FindBy(xpath = ".//input[@class=\"b-input\"]")
    private WebElement themeOfMessage;

    @FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div/div/div[2]/div[1]/div")
    private WebElement message;

    @FindBy(xpath = "//*[@id=\"MailRuConfirm\"]/div/div[2]/form/div[2]/button[1]")
    private WebElement sendMessage;

    public GroupMesssage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void sendGroupMessage(String themeOfMessages) {
        contacts.click();
        conact1.click();
        contact2.click();
        writeGroupMessage.click();
        themeOfMessage.sendKeys(themeOfMessages);
        message.click();
        sendMessage.click();

    }
}
