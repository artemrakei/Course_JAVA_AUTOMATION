import java.util.Scanner;

public class TaskMas1_14 {
    public static void main(String[] args) {
        int size;
        Scanner in = new Scanner(System.in);
        size = in.nextInt();
        int[] mas = new int[size];
        int[] mas1 = new int[size];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * 20);
            System.out.print(mas[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < mas.length; i++) {
            if (i == 0) {
                mas1[i] = (mas[i + 1] + mas[mas.length - 1]) / 2;
            } else if (i == mas.length - 1) {
                mas1[i] = (mas[0] + mas[i - 1]) / 2;
            } else {
                mas1[i] = (mas[i - 1] + mas[i + 1]) / 2;
            }
            System.out.print(mas1[i] + " ");
        }

    }
}
