public class Methods {
    public static void main(String[] args) {
        System.out.println(minNumber(1, 5));
        System.out.println(evenNumber(5));
        System.out.println(square(5));
        System.out.println(qube(2));
    }

    public static int minNumber(int a, int b) {
        int c = 0;
        if (a > b) {
            c = b;
        } else {
            c = a;
        }
        return c;
    }
    public static boolean evenNumber (int a) {
        boolean b;
        if (a%2==0) {
            b=true;
        } else {
            b=false;
        }
        return b;
    }
    public static int square (int a) {
        a=a*a;
        return a;
    }
    public static  int qube (int a) {
        a=square(a)*a;
        return a;
    }
}
