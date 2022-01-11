package selfworks06.Avia;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Inout {

    static Scanner scanner;
    static float weight;
    static double pay;


    public static void main(String[] args) {
        input();
        pay = Calculation.calculationTax(weight);
        output();
    }

    static void input() {
        System.out.println("Введите вес багажа");
        scanner = new Scanner(System.in);
        weight = scanner.nextFloat();
    }

    static void output() {
        System.out.println("Плата за багаж составляет: " + roundValue(pay) + " грн.");
    }

    static String roundValue(double value) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(value);
    }
}
