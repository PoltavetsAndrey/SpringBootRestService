package task01;

// Задание 2
public class Age {

    public static void main(String[] args) {
        int year = 1998;
        int age;
        if (year % 100 == 0) {
            age = year / 100;
        } else {
            age = year / 100 + 1;
        }
        System.out.println(year + " год - это " + age + "-й век");
    }
}
