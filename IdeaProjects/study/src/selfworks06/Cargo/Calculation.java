package selfworks06.Cargo;

public class Calculation {


    public static double calculationTax(float weight, double x, double y,
                                        float tax1, float tax2, float tax3) {
        if (weight <= x) {
            return weight * tax1;
        }
        else if (weight > y) {
            return weight * tax3;
        }
        else {
            return weight * tax2;
        }
    }
}
