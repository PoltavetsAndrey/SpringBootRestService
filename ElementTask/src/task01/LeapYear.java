package task01;

// Задание 3
public class LeapYear {

    public static void main(String[] args) {
        int year = 2003;
        if (year % 4 == 0) {
            System.out.println("Высокосный");
        } else {
            System.out.println("Не высокосный");
        }
    }
}
