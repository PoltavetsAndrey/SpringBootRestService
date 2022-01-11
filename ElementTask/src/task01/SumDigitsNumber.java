package task01;

// Задание 5
public class SumDigitsNumber {

    public static void main(String[] args) {
        int a = 367;
        int sum = 0;
        while (a > 0) {
            sum += a % 10;
            a = a / 10;
        }
        System.out.println("Сумма цифр числа = " + sum);
    }
}
