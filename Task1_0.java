public class Task1_0 {

    public static void main(String[] args) {
        int i;
        int j;
        //++i увеличит значение i, а затем вернет увеличенное значение
        i = 1;
        j = ++i;
        System.out.println("++i увеличит значение i, а затем вернет увеличенное значение");
        System.out.println("i = " + i + "; j = " + j + ";");
        System.out.println(" ");
        /*i++ увеличит значение i, но вернет исходное значение,
        которое i удерживает до того, как будет увеличено */
        i = 1;
        j = i++;
        System.out.println("i++ увеличит значение i, но вернет исходное значение, которое i удерживает до того, как будет увеличено");
        System.out.println("i = " + i + "; j = " + j + ";");
    }
}
