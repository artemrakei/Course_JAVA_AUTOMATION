import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringOperationsTest {

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testStringToUpperCase() {
        String str = "java automation";
        StringOperations stringOperations = new StringOperations();
        String actualResult = stringOperations.stringToUpperCase(str);
        String expectedResult = "JAVA AUTOMATION";
        Assert.assertEquals(expectedResult,actualResult);


    }
    @DataProvider
    public Object [] [] replaceSymb () {
        return new Object[][] {
                {"asd","osd"},
                {"aaadaaa","ooodooo"},
                {"art","ort"}
        };
    }
    @Test (dataProvider = "replaceSymb")
    public void testStringReplaceAll(String str1, String expectedResult) {
        StringOperations stringOperations = new StringOperations();
        String actualResult = stringOperations.stringReplaceAll(str1);
        Assert.assertEquals(expectedResult,actualResult);
    }


}