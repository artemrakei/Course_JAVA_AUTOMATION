import java.util.*;

public class TaskMas1_8 {
    public static void main(String[] args) {
        int size;
        int j = 0;
        int result = 1;
        Scanner in = new Scanner(System.in);
        size = in.nextInt();
        int[] mas = new int[size];
        int[] mas1 = new int[size];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * 20);
            System.out.print(mas[i] + " ");
            if (mas[i] == 0) {
                mas1[j] = i;
                j++;

            }
        }
        System.out.println();
        if (j != 0) {
            for (int i = 0; i < j; i++) {
                System.out.print(mas1[i] + " ");
            }

        } else {
            System.out.println("Нулей нет");
        }
    }
}