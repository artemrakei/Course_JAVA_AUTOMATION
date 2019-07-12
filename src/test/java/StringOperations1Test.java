import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringOperations1Test {

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }


    @Test
    public void testStringSubstring() {
        String str = "ABCdefghij";
        StringOperations stringOperations = new StringOperations();
        String actualResult = stringOperations.stringSubstring(str);
        String expectedResult = "cde";
        Assert.assertEquals(expectedResult,actualResult.toLowerCase());
    }

    @Test
    public void testStringEquals () {
        String str1 = "ABC";
        String str2 = "abc";
        StringOperations stringOperations = new StringOperations();
        boolean actualResult = stringOperations.stringEquals(str1,str2.toLowerCase());
        Assert.assertTrue(actualResult);
    }


}