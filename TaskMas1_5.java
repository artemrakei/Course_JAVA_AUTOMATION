import java.util.*;

public class TaskMas1_5 {
    public static void main(String[] args) {
        int size;
        int result = 1;
        Scanner in = new Scanner(System.in);
        size = in.nextInt();
        int[] mas = new int[size];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * 20);
            System.out.print(mas[i] + " ");
            result = result * mas[i];
        }
        System.out.println(" ");
        System.out.println(result);
    }
}
