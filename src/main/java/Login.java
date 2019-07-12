import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    @FindBy(id = "mailbox:login")
    private WebElement login;

    @FindBy(id = "mailbox:password")
    private WebElement password;

    @FindBy(id = "mailbox:submit")
    private WebElement submitEmail;

    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterToEmail(String enterLogin, String enterPassword) {
        login.sendKeys(enterLogin);
        password.sendKeys(enterPassword);
        submitEmail.submit();

    }
}
