import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String text = input.nextLine();
        int index = input.nextInt();

        if (index < 0 || index > text.length() - 1) {
            System.out.println("Out of bounds!");
        } else {
            System.out.println(text.charAt(index));
        }
    }
}