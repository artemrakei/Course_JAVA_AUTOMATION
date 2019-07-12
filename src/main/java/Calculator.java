public class Calculator {

    //Сумма
    public int calcSum(int a, int b) {
        int result = a + b;
        return result;
    }

    //Разность
    public int calcDifference(int a, int b) {
        int result = a - b;
        return result;
    }

    // Умножение
    public int calcMultiplication(int a, int b) {
        int result = a * b;
        return result;
    }

    //Деление
    public double calcDivision(int a, int b) {
        double result = a / b;
        return result;
    }

    //Возведение в степень
    public int calcExponentiation(int a, int b) {
        int result = (int) (Math.pow(a, b));
        return result;
    }

}
