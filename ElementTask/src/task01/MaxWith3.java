package task01;

// Задание 1
public class MaxWith3 {

    static double a = 3.6;
    static double b = 10;
    static double c = 10000;
    static double max;

    public static void main(String[] args) {
        if (a > b) {
            max = a;
            if (a > c) {
                max = a;
            } else {
                max = c;
            }
        } else if (b > c) {
            max = b;
        } else {
            max = c;
        }
        System.out.println("Максимальное число: " + max);
    }
}
