import java.util.*;

public class TaskMas1_4 {
    public static void main(String[] args) {
        int size;
        Scanner in = new Scanner(System.in);
        size = in.nextInt();
        int[] mas = new int[size];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * 20);
            System.out.print(mas[i] + " ");
        }
        System.out.println(" ");
        for (int i = mas.length - 1; i >= 0; i--) {
            System.out.print(mas[i] + " ");
        }
    }
}
