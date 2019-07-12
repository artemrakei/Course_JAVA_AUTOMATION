import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flags {
    @FindBy (xpath = "(.//div[@id=\"b-nav_folders\"]/div/div)[1]")
    private WebElement incoming;

    @FindBy (xpath = "(((.//div[@id=\"b-letters\"]/div/div)[2]/div/div)[2]/div)[1]/div/a/div/div/div")
    private WebElement message1;

    @FindBy (xpath = "(((.//div[@id=\"b-letters\"]/div/div)[2]/div/div)[2]/div)[2]/div/a/div/div/div")
    private WebElement message2;

    @FindBy (xpath = "(((.//div[@id=\"b-letters\"]/div/div)[2]/div/div)[2]/div)[3]/div/a/div/div/div")
    private WebElement message3;

    @FindBy (xpath = "//*[@id=\"b-toolbar__right\"]/div[3]/div/div[2]/div[1]/div")
    private WebElement detachment;


    public Flags(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void actionsFlags () {
        incoming.click();
        message1.click();
        message2.click();
        message3.click();
        detachment.click();

    }

}
