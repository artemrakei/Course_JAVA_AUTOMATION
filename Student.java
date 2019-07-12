public class Student extends Person {
    private static int number1(int a) {
        a = a + a;
        return a;
    }

    protected static String name(String yoursName) {
        yoursName = "No! Yours name is Gena";
        return yoursName;
    }

    static String hello(String name) {
        String hello1 = "Hello" + name;
        return hello1;
    }

    public static String friend(String name) {
        String friend1 = "My friend" + name;
        return friend1;
    }
}
