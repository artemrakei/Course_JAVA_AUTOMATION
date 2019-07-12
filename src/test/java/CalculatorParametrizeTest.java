import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorParametrizeTest {


   @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @RunWith(Parameterized.class)
    public class ParameterizeTest {
        private int valA;
        private int valB;
        private int expectedResult;

        public ParameterizeTest(int valA, int valB, int expectedResult) {
            this.valA = valA;
            this.valB = valB;
            this.expectedResult = expectedResult;
        }


        @Parameterized.Parameters()
        public Iterable<Object[]> dataForTest() {
            return Arrays.asList(new Object[][]{
                    {1, 1, 1},
                    {2, 2, 4},
                    {3, 3, 9}

            });
        }

        @Test
        public void calcMultiplication() {
            assertEquals(expectedResult, new Calculator().calcMultiplication(valA, valB));
        }
    }

    @Disabled
    @Test
    void calcExponentiation() {
    }
}