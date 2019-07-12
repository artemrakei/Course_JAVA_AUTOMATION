import java.util.*;

public class TaskMas1_10 {
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

        for (int i = 0; i < mas.length / 2; i++) {
            a = mas[i];
            mas[i] = mas[mas.length - (i+1)];
            mas[mas.length - (i+1)] = a;
        }
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
    }
}