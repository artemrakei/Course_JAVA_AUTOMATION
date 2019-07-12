import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeLesson {
    @Test
    public void resultRatingTest () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Courses/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        /*driver.get("http://www.booking.com");

        WebElement search = driver.findElement(By.xpath(".//input[@id='ss']"));
        search.sendKeys("москва");

        WebElement searchDateRise = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]"));
        searchDateRise.click();

        WebElement dateRise = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr[6]/td[7]"));
        dateRise.click();

        WebElement choice = driver.findElement(By.xpath(".//span[@class='xp__guests__count']"));
        choice.click();

        WebElement adults = driver.findElement(By.xpath("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[1]/div/div[2]/button[2]"));
        adults.click();
        adults.click();

        WebElement chamber = driver.findElement(By.xpath("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[3]/div/div[2]/button[2]"));
        chamber.click();

        WebElement result = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button"));
        result.submit();

        WebElement finalSearch = driver.findElement(By.xpath("//*[@id=\"ss\"]"));
        finalSearch.clear();
        finalSearch.sendKeys("Видишь Ульяна, номера есть!");
        Thread.sleep(3000);
        finalSearch.clear();
        finalSearch.sendKeys("Поехали дальше!");
        Thread.sleep(3000);*/

        driver.get("http://www.booking.com");

        WebElement search1 = driver.findElement(By.xpath(".//input[@id='ss']"));
        search1.clear();
        search1.sendKeys("москва");

        WebElement choice1 = driver.findElement(By.xpath(".//span[@class='xp__guests__count']"));
        choice1.click();

        WebElement adults1 = driver.findElement(By.xpath("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[1]/div/div[2]/button[1]"));
        adults1.click();
        adults1.click();

        WebElement chamber1 = driver.findElement(By.xpath("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[3]/div/div[2]/button[1]"));
        chamber1.click();

        WebElement result1 = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button"));
        result1.submit();

        WebElement choiceOther = driver.findElement(By.xpath("//*[@id=\"sortbar_dropdown_button\"]"));
        choiceOther.click();

        WebElement choiceRating = driver.findElement(By.linkText("Звезды"));
        choiceRating.click();
        Thread.sleep(1000);
        WebElement choiceRatingFinal = driver.findElement(By.linkText("количество звезд [5→1]"));
        choiceRatingFinal.click();


        Thread.sleep(7000);
        WebElement ratingHotel1 = driver.findElement(By.xpath("((.//div[@id='hotellist_inner']/div)[2]/div)[2]/div/div/h3/a[@class='hotel_name_link url']"));
        ratingHotel1.click();


        Thread.sleep(3000);
        WebElement ratingHotelFinal = driver.findElement(By.xpath(".//div[@class='bui-review-score__badge']"));
        String resultRatingString = ratingHotelFinal.getText().toString().trim().replace(',','.');

        boolean res=false;
        double resultRating = Double.parseDouble(resultRatingString);
        if (resultRating>=9.0) {
            res = true;
        }

        Assert.assertTrue(res);
        //System.out.println(resultRating);
        //Thread.sleep(3000);
        //driver.quit();
    }

}
