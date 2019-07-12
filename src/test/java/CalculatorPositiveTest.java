import org.junit.jupiter.api.*;

class CalculatorPositiveTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName ("Расчет Суммы")
    @Test
    void calcSum() {
        int a=5, b=12;
        Calculator calculator = new Calculator();
        int actualResult = calculator.calcSum(a,b);
        int expectedResult = 17;
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @DisplayName ("Расчет Разности")
    @Test
    void calcDifference() {
        int a=19, b=12;
        Calculator calculator = new Calculator();
        int actualResult = calculator.calcDifference(a,b);
        int expectedResult = 7;
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @DisplayName ("Расчет Умножения")
    @Test
    void calcMultiplication() {
        int a=20, b=12;
        Calculator calculator = new Calculator();
        int actualResult = calculator.calcMultiplication(a,b);
        int expectedResult = 240;
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @DisplayName ("Расчет Деления")
    @Test
    void calcDivision() {
        int a=24, b=12;
        Calculator calculator = new Calculator();
        double actualResult = calculator.calcDivision(a,b);
        double expectedResult = 2.0;
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @DisplayName ("Расчет возведения в степень")
    @Test
    void calcExponentiation() {
        int a=12, b=2;
        Calculator calculator = new Calculator();
        int actualResult = calculator.calcExponentiation(a,b);
        int expectedResult = 144;
        Assertions.assertEquals(expectedResult,actualResult);

    }
}