package testProject;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AppTest {
    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }
    @Test
    public void testStringSubstring() {
        String str = "expected";
        App stringOperations = new App();
        String actualResult = stringOperations.stringSubstring(str);
        String expectedResult = "xpect";
        Assert.assertEquals(expectedResult,actualResult.toLowerCase());
    }

    @Test
    public void testStringEquals () {
        String str1 = "ABC";
        String str2 = "abc";
        App stringOperations = new App();
        boolean actualResult = stringOperations.stringEquals(str1,str2.toLowerCase());
        Assert.assertTrue(actualResult);
    }

    @Test
    public void testStringToUpperCase() {
        String str = "java automation";
        App stringOperations = new App();
        String actualResult = stringOperations.stringToUpperCase(str);
        String expectedResult = "JAVA AUTOMATION";
        Assert.assertEquals(expectedResult,actualResult);


    }
    @DataProvider
    public Object [] [] replaceSymb () {
        return new Object[][] {
                {"p","qw"},
        };
    }
    @Test (dataProvider = "replaceSymb")
    public void testStringReplaceAll(String str1, String expectedResult) {
        App stringOperations = new App();
        String actualResult = stringOperations.stringReplaceAll(str1);
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test (expectedExceptions = NumberFormatException.class)
    public void testStringToNumber() {
        String str ="a";
        App stringOperations = new App();
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
        App stringOperations = new App();
        int actualResult = stringOperations.stringToNumber(str1);
        Assert.assertEquals(expectedResult, actualResult);
    }


    @Test (enabled = false)
    public void testStringEquals_1() {

    }
    @DataProvider
    public Object [] [] replaceSymb_1 () {
        return new Object[][] {
                {"pp","qwqw"},
                {"papa","qwaqwa"},
                {"pip","qwiqw"}
        };
    }
    @Test (dataProvider = "replaceSymb_1")
    public void testStringReplaceAll_1(String str1, String expectedResult) {
        App stringOperations = new App();
        String actualResult = stringOperations.stringReplaceAll(str1);
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testStringToNumber_1() {
        String str ="500";
        App stringOperations = new App();
        int actualResult = stringOperations.stringToNumber(str);
        int expectedResult = 500;
        Assert.assertEquals(expectedResult,actualResult);
    }

}