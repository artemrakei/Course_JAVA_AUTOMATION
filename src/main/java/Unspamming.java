import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Unspamming {
    @FindBy(xpath = "(.//div[@id=\"b-nav_folders\"]/div/div)[6]")
    private WebElement folderSpam;

    @FindBy(xpath = "(.//div[@class=\"b-datalist__body\"])[2]/div[1]/div/a/div/div/div")
    private WebElement choiceMes;

    @FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[3]/div/div[2]/div[3]/div")
    private WebElement notSpam;

    public Unspamming(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void unspammingMes() throws InterruptedException {
        Thread.sleep(3000);
        folderSpam.click();

        choiceMes.click();

        notSpam.click();
    }
}
