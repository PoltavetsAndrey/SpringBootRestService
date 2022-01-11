package selfworks07.warehouse;

public class Output {

    public static void main(String[] args) {
        Product name = new Product();
        System.out.println("Товар: " + name.name +
               "\n имеется на складе в кол-ве: " + name.number +
               "\n его общий вес = " + name.calculateTotalWeight() + " кг" );
    }
}
