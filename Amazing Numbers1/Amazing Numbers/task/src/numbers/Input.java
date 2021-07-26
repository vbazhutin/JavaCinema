package numbers;

import java.util.Scanner;

public class Input {

    public static String[] inputProps() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter a request:");
        return in.nextLine().split(" ");
    }
}