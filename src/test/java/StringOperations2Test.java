import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringOperations2Test {

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }


    @Test (expectedExceptions = NumberFormatException.class)
    public void testStringToNumber() {
        String str ="a";
        StringOperations stringOperations = new StringOperations();
        int actualResult = stringOperations.stringToNumber(str);
        int expectedResult = 5;
        Assert.assertEquals(expectedResult,actualResult);
    }



    @DataProvider
    public Object [] [] stringToNumber () {
        return new Object[][] {
                {"5",5},
                {"10",10},
                {"132",132}
        };
    }
    @Test (dataProvider = "stringToNumber")
    public void testStringToNumber(String str1, int expectedResult) {
        StringOperations stringOperations = new StringOperations();
        int actualResult = stringOperations.stringToNumber(str1);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test (enabled = false)
    public void testStringEquals() {

    }
}