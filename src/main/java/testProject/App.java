package testProject;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public String stringToUpperCase(String str) {
        return str.toUpperCase();
    }

    public boolean stringEquals(String str1, String str2) {
        return str1.equalsIgnoreCase(str2);
    }

    public String stringReplaceAll(String str) {
        return str.replaceAll("p", "qw");
    }

    public String stringSubstring(String str) {

        return str.substring(1, (str.length()-2));
    }

    public int stringToNumber(String str1) {
        int number = Integer.parseInt(str1);
        return number;
    }
}

