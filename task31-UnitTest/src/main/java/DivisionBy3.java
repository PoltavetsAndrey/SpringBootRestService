import com.sun.tools.javac.Main;

public class DivisionBy3 {

    public static String dividend = "123"; // Вводимое проверяемое число

    public static void main(String[] args) {
        DivisionBy3 main = new DivisionBy3();
        main.divisionBy3(dividend);
    }

    public static boolean divisionBy3(String dividend) {

        int sum = 0;
        int private3 = 0; // Частное от деления на 3
        for (int i = 0; i < dividend.length(); i++) {
            int number = dividend.charAt(i);
            sum += number;
        }
        private3 = sum / 3;
        if (private3 * 3 == sum) {
            System.out.println("Введённое число: " + dividend +
                    " делится на 3 без остатка");
            return true;
        }
        else {
            System.out.println("Введённое число: " + dividend +
                    " не делится на 3 без остатка");
            return false;
        }
    }
}
