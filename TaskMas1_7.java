import java.util.*;

public class TaskMas1_7 {
    public static void main(String[] args) {
        int size;
        int sum = 0;
        Scanner in = new Scanner(System.in);
        size = in.nextInt();
        int[] mas = new int[size];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * 20);
            System.out.print(mas[i] + " ");
            if (mas[i] == 0) {
                sum++;
            }
        }
        System.out.println();
        if (sum == 0) {
            System.out.println("Нулей нет");
        } else {
            System.out.println("Количество 0 = " + sum);
        }
    }
}