import java.util.*;

public class TaskMas1_6 {
    public static void main(String[] args) {
        int size;
        int result = 1;
        Scanner in = new Scanner(System.in);
        size = in.nextInt();
        int[] mas = new int[size];
        int[] mas1 = new int[size];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * 20);
            mas1[i] = mas[i];
            System.out.print(mas[i] + " ");
        }
        System.out.println();
        for (int i = 2; i < mas.length; i = i + 3) {
            mas[i] = mas[i] * 2;
            System.out.print(mas[i] + " ");
        }
        System.out.println();
        for (int i = 1; i < mas1.length; i++) {
            if ((i+1) % 3 == 0) {
                mas1[i] = mas1[i] * 2;
                System.out.print(mas1[i] + " ");
            }
        }
    }
}