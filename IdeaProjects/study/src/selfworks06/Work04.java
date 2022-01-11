package selfworks06;

public class Work04 {
    public static StringBuilder name;

    public static void main(String[] args) {
        name = input();
        System.out.println("Была: " + name);
        name = markdown();
        System.out.println("Стала: " + name);
    }

    static StringBuilder input() {
        StringBuilder name = new StringBuilder("Груша");
        return name;
    }

    static StringBuilder markdown() {
        name.insert(0, "Уценка ");
        return name;
    }

}
