import org.junit.jupiter.api.*;

class CalculatorNegativeTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void calcDifference() {

            int a = 2147483647;
            int b = -1;
            Calculator calculator = new Calculator();
            int actualResult = calculator.calcDifference(a, b);
            long expectedResult = -2147483648l;
            Assertions.assertEquals(expectedResult, actualResult);
        }


    @Test
    void calcMultiplication() {

    }

    @Test
    void calcDivision() {
        int a = 24, b = 0;
        Calculator calculator = new Calculator();
        double actualResult = calculator.calcDivision(a, b);
        double expectedResult = 2.0;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void calcExponentiation() {
    }
}