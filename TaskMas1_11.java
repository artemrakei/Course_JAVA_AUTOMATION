import java.util.Scanner;

public class TaskMas1_11 {
    public static void main(String[] args) {
        int size;
        Scanner in = new Scanner(System.in);
        size = in.nextInt();
        int[] mas = new int[size];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * 20);
            System.out.print(mas[i] + " ");
        }
        int max = mas[0];
        int min = mas[0];
        System.out.println();

        for (int i = 0; i < mas.length - 1; i++) {
            if (max < mas[i]) {
                max = mas[i];
            }
            if (min > mas[i]) {
                min = mas[i];
            }
        }
        System.out.println("max = " + max + ", min = " + min);
    }
}