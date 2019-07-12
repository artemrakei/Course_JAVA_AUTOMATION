package Booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.SQLOutput;

public class HotelRoom {
    @FindBy(id = "ss")
    private WebElement city;

    @FindBy(xpath = "//*[@id=\"frm\"]/div[3]/div/div[1]/div[1]/div/div/div[2]/div[2]/div[3]/div/div/div[1]/table/tbody/tr[5]/td[7]/span")
    private WebElement departureDay;

    @FindBy(xpath = "//*[@id=\"frm\"]/div[3]/div/div[1]/div[2]/div/div/div[1]/div/div[2]")
    private WebElement returnDate;

    @FindBy(xpath = "//*[@id=\"frm\"]/div[3]/div/div[1]/div[2]/div/div/div[2]/div[2]/div[3]/div/div/div[2]/table/tbody/tr[1]/td[7]/span")
    private WebElement returnDay;

    @FindBy(xpath = "//*[@id=\"frm\"]/div[5]/div[2]/button")
    private WebElement findHotels;

    @FindBy(xpath = "//*[@id=\"sortbar_dropdown_button\"]")
    private WebElement otherLink;

    @FindBy(partialLinkText = "Оценка + кол-во отзывов")
    private WebElement sortByRating;

    @FindBy(xpath = "//*[@id=\"hotellist_inner\"]/div[2]/div[2]/div[3]/div/div[3]/div[1]/div/div[2]/div[3]/div[2]/div")
    private WebElement costChamber;

    public HotelRoom(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public int findHotelRoom(String enterCity) {
        city.clear();
        city.sendKeys(enterCity);
        city.submit();
        departureDay.click();
        returnDate.click();
        returnDay.click();
        findHotels.click();
        otherLink.click();
        sortByRating.click();
        String costChamber1 = costChamber.getText();
        int resultCost = Integer.parseInt(costChamber1 = costChamber1.substring(4).replaceAll("\\s+", ""));

        return resultCost;

    }


}
