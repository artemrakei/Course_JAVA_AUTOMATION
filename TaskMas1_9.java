import java.util.*;

public class TaskMas1_9 {
    public static void main(String[] args) {
        int size;
        int a = 0;
        Scanner in = new Scanner(System.in);
        size = in.nextInt();
        int[] mas = new int[size];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * 20);
            System.out.print(mas[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < mas.length - 1; i = i + 2) {
            a = mas[i];
            mas[i] = mas[i + 1];
            mas[i + 1] = a;
        }
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
    }
}