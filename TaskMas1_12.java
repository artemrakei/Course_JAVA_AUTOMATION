import java.util.Scanner;

public class TaskMas1_12 {
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
        int maxCalc = 0;
        int minCalc = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == max && maxCalc == 0) {
                System.out.print("max = " + max + " номер максимального элемента - " + i + " ");
                maxCalc++;
            } else if (mas[i] == max) {
                System.out.print(i + " ");
            }

        }

        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == min && minCalc == 0) {
                System.out.print("min = " + min + " номер минимального элемента - " + i + " ");
                minCalc++;
            } else if (mas[i] == min) {
                System.out.print(i + " ");
            }
        }
    }
}