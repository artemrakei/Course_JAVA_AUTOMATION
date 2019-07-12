import Booking.HotelRoom;
import Booking.HotelRoomMinPrice;
import Booking.OrderHotelRoom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HotelChamberTest {
    private WebDriver driver;
    private HotelRoom hotelRoom;
    private HotelRoomMinPrice hotelRoomMinPrice;
    private OrderHotelRoom orderHotelRoom;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:/Courses/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.booking.com");
        hotelRoom = new HotelRoom(driver);
        hotelRoomMinPrice = new HotelRoomMinPrice(driver);
        orderHotelRoom = new OrderHotelRoom(driver);
    }

    @Test
    public void hotelRoomTest() {
        int expectedResult = 30000;
        boolean result = false;
        if (expectedResult > hotelRoom.findHotelRoom("париж"))
            result = true;
        Assert.assertTrue(result);

    }


    @Test
    public void hotelRoom2Test(){
        int expectedResult = 5000;
        boolean result = false;
        if (expectedResult < hotelRoomMinPrice.findHotelRoom("париж"))
            result = true;
        Assert.assertTrue(result);

    }

    @Test
    public void orderHotelRoomTest () {
        orderHotelRoom.findHotelRoom("париж");
        String parentHandle = driver.getWindowHandle();
        for(String childHandle : driver.getWindowHandles()){
            if (!childHandle.equals(parentHandle)){
                driver.switchTo().window(childHandle);
            }
        }
        orderHotelRoom.orderHotelRoom("pupkin","pupkin@gmail.com","292929292","4242","424");
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }



}
