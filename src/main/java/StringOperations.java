public class StringOperations {

    public String stringToUpperCase (String str) {
        return str.toUpperCase();
    }

    public boolean stringEquals (String str1, String str2) {
        return str1.equalsIgnoreCase(str2);
    }

    public String stringReplaceAll (String str) {
        return str.replaceAll("a","o");
    }

    public String stringSubstring (String str) {
        return str.substring(2,5);
    }
    public int stringToNumber (String str1) {
        int number=Integer.parseInt(str1);
        return number;
    }
}
