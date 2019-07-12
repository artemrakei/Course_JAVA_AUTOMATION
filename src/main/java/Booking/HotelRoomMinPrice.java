package Booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelRoomMinPrice {
    @FindBy(id = "ss")
    private WebElement city;

    @FindBy(xpath = "//*[@id=\"frm\"]/div[3]/div/div[1]/div[1]/div/div/div[2]/div[2]/div[3]/div/div/div[1]/table/tbody/tr[5]/td[7]/span")
    private WebElement departureDay;

    @FindBy(xpath = "//*[@id=\"frm\"]/div[3]/div/div[1]/div[2]/div/div/div[1]/div/div[2]")
    private WebElement returnDate;

    @FindBy(xpath = "//*[@id=\"frm\"]/div[3]/div/div[1]/div[2]/div/div/div[2]/div[2]/div[3]/div/div/div[2]/table/tbody/tr[1]/td[7]/span")
    private WebElement returnDay;

    @FindBy (id = "group_adults")
    private WebElement groupAdults;

    @FindBy(xpath = "//*[@id=\"group_adults\"]/option[4]")
    private WebElement numberOfAdults;

    @FindBy(id="no_rooms")
    private WebElement noRooms;

    @FindBy (xpath = "//*[@id=\"no_rooms\"]/option[2]")
    private WebElement numberOfRooms;

    @FindBy(xpath = "//*[@id=\"frm\"]/div[5]/div[2]/button")
    private WebElement findHotels;

    @FindBy (xpath = "//*[@id=\"filter_price\"]/div[2]/a[4]/div")
    private WebElement highPrice;

    @FindBy(partialLinkText = "Цена (сначала самая низкая)")
    private WebElement sortByPrice;

    @FindBy(xpath = "//*[@id=\"hotellist_inner\"]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div")
    private WebElement myRoom;

    public HotelRoomMinPrice(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public int findHotelRoom(String enterCity) {
        city.clear();
        city.sendKeys(enterCity);
        city.submit();
        departureDay.click();
        returnDate.click();
        returnDay.click();
        groupAdults.click();
        numberOfAdults.click();
        noRooms.click();
        numberOfRooms.click();
        findHotels.click();
        highPrice.click();
        sortByPrice.click();
        String costChamber1 = myRoom.getText();
        int resultCost = Integer.parseInt(costChamber1 = costChamber1.substring(4).replaceAll("\\s+", ""));

        return resultCost;

    }
}
