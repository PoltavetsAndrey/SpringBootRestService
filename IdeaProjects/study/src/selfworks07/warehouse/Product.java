package selfworks07.warehouse;

public class Product {
    //public static class Product {
        String name;
        int number;
        double weight;

        public Product() {
            name = "Кирпич";
            number = 2000;
            weight = 1.5;
        }

        public double calculateTotalWeight() {
            return number * weight;
        }

   // }
}
