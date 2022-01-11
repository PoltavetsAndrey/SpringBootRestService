package selfworks06.Cargo;

import java.util.Scanner;

public class Inout {
    static float weight;
    static double x;
    static double y;
    static double pay;
    public static float tax1;
    static float tax2;
    static float tax3;

    public static void main(String[] args) {
        input();
        pay = Calculation.calculationTax(weight, x, y, tax1, tax2, tax3);
        output();
    }

    static void input() {
        x = 25;
        y = 50;
        tax1 = 3f;
        tax2 = 4;
        tax3 = 5;
        System.out.println("Введите вес груза в кг");
        Scanner scanner = new Scanner(System.in);
        weight = scanner.nextFloat();
    }

    static void output() {
        System.out.println("Плата за груз составляет: " + Rounder.roundValue(pay) + " грн.");
    }
}
