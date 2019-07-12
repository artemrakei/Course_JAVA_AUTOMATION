import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class EmailTest {
    private WebDriver driver;
    private Login login;
    private Spamming spamming;
    private Unspamming unspamming;
    private GroupMesssage groupMesssage;
    private Flags flags;


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:/Courses/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://www.mail.ru");
        spamming = new Spamming(driver);
        login = new Login(driver);
        unspamming = new Unspamming(driver);
        groupMesssage = new GroupMesssage(driver);
        flags = new Flags(driver);

    }

    @Test
    public void loginTest() throws InterruptedException {
        login.enterToEmail("temka4_93", "09R09a1993M");
        spamming.spammingMes();
        unspamming.unspammingMes();
        groupMesssage.sendGroupMessage("Theme One");
        flags.actionsFlags();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
