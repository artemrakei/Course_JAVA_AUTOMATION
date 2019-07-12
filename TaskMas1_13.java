import java.util.Scanner;

public class TaskMas1_13 {
    public static void main(String[] args) {
        int size;
        Scanner in = new Scanner(System.in);
        size = in.nextInt();
        int[] mas = new int[size];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * 20);
            System.out.print(mas[i] + " ");
        }
        int a=0;
        for (int i=0; i<mas.length-1; i++) {
            if (mas[i]<mas[i+1]) {
                a++;
            }
        }
        if (a==mas.length-1) {
            System.out.println("Является возрастающей последовательностью");
        } else {
            System.out.println("Не является возрастающей последовательностью");
        }
    }
}