import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class MailRu {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Courses\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        Eyes eyes = new Eyes();

        eyes.setApiKey("RFy678rDfd7Jtb0LlJJsxgoyohmMAL4Upgu0L7mcKN4110");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


            eyes.open(driver, "appName","Mail.ru test", new RectangleSize(600, 800));


        driver.get("https://mail.ru");
            eyes.checkWindow("Main page");

        WebElement login = driver.findElement(By.id("mailbox:login"));
        login.sendKeys("temka4_93");
        WebElement pass = driver.findElement(By.id("mailbox:password"));
        pass.sendKeys("09R09a1993M");
        pass.submit();
        Thread.sleep(3000);
            eyes.checkWindow("My page");
        WebElement writeMessage = driver.findElement(By.xpath("//*[@id=\"b-toolbar__left\"]/div/div/div[2]/div/a"));
        writeMessage.click();
            eyes.checkWindow("Write message");
        WebElement email = driver.findElement(By.xpath(".//div[@class='compose-head__field']/div/div/textarea[2]"));

        email.sendKeys("temak74@gmail.com");
        WebElement theme = driver.findElement(By.xpath(".//input[@class=\"b-input\"]"));
        theme.sendKeys("Test message");

        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        driver.switchTo().activeElement().sendKeys("Hello");
        eyes.checkWindow("Write message 2");
        WebElement sent = driver.findElement(By.xpath("//*[@id=\"b-toolbar__right\"]/div[3]/div/div[2]/div[1]/div"));
        sent.click();
        WebElement enter = driver.findElement(By.xpath("//*[@id=\"MailRuConfirm\"]/div/div[2]/form/div[2]/button[1]"));
        enter.click();
        Thread.sleep(3000);
        eyes.checkWindow("Sent message");

            eyes.close();


            driver.quit();


            eyes.abortIfNotClosed();


        System.exit(0);
    }

}

