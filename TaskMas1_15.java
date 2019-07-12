import java.util.Scanner;

public class TaskMas1_15 {
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
            if (i > mas.length - 3) {
                if (i == mas.length - 2) {
                    mas1[i] = mas[0];
                    System.out.print(mas1[i] + " ");
                } else {
                    mas1[i] = mas[1];
                    System.out.print(mas1[i] + " ");
                    break;
                }
            } else {
                mas1[i] = mas[i + 2];
                System.out.print(mas1[i] + " ");
            }
        }
    }

}
