package task01;

// Задание 4
import java.util.Arrays;

public class FillerArray {

    static int length = 10;
    static int[] array = new int[length];
    static int start = 2;

    public static void main(String[] args) {
        for (int i = 0; i < length; i++) {
           array[i] = start  + i;
        }
        System.out.println("Содержимое массива: " + Arrays.toString(array));
    }
}
