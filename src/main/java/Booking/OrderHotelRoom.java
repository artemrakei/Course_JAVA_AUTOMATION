package Booking;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OrderHotelRoom {
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

    @FindBy(xpath = "//*[@id=\"hotellist_inner\"]/div[2]/div[2]/div[2]/div/div[3]/div/div/a")
    private WebElement myRoom;

    @FindBy (xpath = "//*[@id=\"hp_book_now_button\"]/span[1]")
    private WebElement order;

    @FindBy (xpath = "(.//table[@class=\"hprt-table  \"]//tbody//tr//td)[5]//div//select")
    private WebElement numberOfRoom;

    @FindBy (xpath = "((.//table[@class=\"hprt-table  \"]//tbody//tr//td)[5]//div//select//option)[3]")
    private  WebElement twoRooms;

    @FindBy (xpath = ".//div[@class='hprt-reservation-cta']//button")
    private WebElement orderRoom;

    @FindBy (xpath = "//*[@id=\"bp_travel_purpose_business\"]")
    private WebElement riseOfJob;

    @FindBy (xpath = ".//div[@class=\"name\"]//select")
    private WebElement sex;

    @FindBy (xpath = "(.//div[@class=\"name\"]//select//option)[2]")
    private WebElement mr;

    @FindBy (id="lastname")
    private WebElement lastName;

    @FindBy (id="email")
    private WebElement email;

    @FindBy (id="email_confirm")
    private WebElement confirmEmail;

    @FindBy (xpath = "(.//button)[1]")
    private WebElement nextStep;

    @FindBy (id="phone")
    private WebElement phone;

    @FindBy (id="cc_type")
    private WebElement typeCard;

    @FindBy (xpath = "(.//select[@id=\"cc_type\"])//option[3]")
    private WebElement cardVisa;

    @FindBy (id="cc_number")
    private WebElement cardNumber;


    @FindBy (id="ccYear")
    private WebElement cardMonth;

    @FindBy (xpath = "(.//select[@id='ccYear'])//option[2]")
    private WebElement cardYear;

    @FindBy (id="cc_cvc")
    private WebElement cardCvc;

    @FindBy (xpath = "//*[@id=\"bookwrapper_cell\"]/div[4]/div[1]/button[2]")
    private WebElement finalOrder;

    @FindBy (xpath = "//*[@id=\"b2confirmationPage\"]/div[8]/button")
    private WebElement closeWindow;

    public OrderHotelRoom(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void findHotelRoom(String enterCity) {
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
        myRoom.click();
    }
    public void orderHotelRoom (String lastname,String emails, String phones, String numberCard,String numberCVC) {
        order.click();
        numberOfRoom.click();
        twoRooms.click();
        orderRoom.click();
        riseOfJob.click();
        sex.click();
        mr.click();
        lastName.sendKeys(lastname);
        email.sendKeys(emails);
        confirmEmail.sendKeys(emails);
        nextStep.click();
        phone.sendKeys(phones);
        typeCard.click();
        cardVisa.click();
        cardNumber.sendKeys(numberCard);
        cardNumber.sendKeys(numberCard);
        cardNumber.sendKeys(numberCard);
        cardNumber.sendKeys(numberCard);

        cardMonth.click();
        cardYear.click();
        cardCvc.sendKeys(numberCVC);

        finalOrder.click();
        closeWindow.click();





    }
}
