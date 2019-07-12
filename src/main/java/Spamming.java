import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class Spamming {

    @FindBy(xpath = "(.//div[@class=\"b-datalist__body\"]/div)[1]/div/a/div/div/div")
    private WebElement messageOne;

    @FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[2]/div/div[2]/div[3]/div/span")
    private WebElement mesOneSpamming;

    public Spamming(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void spammingMes() {
        messageOne.click();
        mesOneSpamming.click();

    }


}
