package selfworks06.Avia;

import java.util.Scanner;

public class Calculation {

    static final int weight1 = 25;
    static final int weight2 = 50 ;

    static double tax1 = 2.5;
    static double tax2 = 2;
    static double tax3 = 1.5;

    public static double calculationTax(float weight) {
        if (weight <= weight1) {
            return weight * tax1;
        }
            else if (weight > weight2) {
                return weight * tax3;
            }
                else {
                    return weight * tax2;
                }
    }
}
