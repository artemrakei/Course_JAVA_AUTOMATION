import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Singleton {
    private static Singleton INSTANCE;
    private static ChromeDriver webDriver;

    public Singleton() {
        webDriver = new ChromeDriver();
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public static void quit() {
        if (webDriver != null) {
            webDriver.quit();
        }
        webDriver = null;

    }
}
