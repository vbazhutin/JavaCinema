package numbers;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Welcome.greetings();
        Welcome.printInstructions();

        while (true) {
            String[] props = Input.inputProps();
            if (props[0].equals("0")) {
                System.out.println("Goodbye!");
                break;
            } else if (!props[0].matches("\\d+")) {
                System.out.println("The first parameter should be a natural number or zero.");
            } else if (props.length > 1 && !props[1].matches("\\d+")) {
                System.out.println("The second parameter should be a natural number.");
            } else if (props.length > 2 && !Arrays.asList(Number.numberProperties).
                    contains(props[2].toUpperCase())) {
                System.out.printf("The property [%s] is wrong.\n" +
                                "Available properties: [%s]",
                        props[2].toUpperCase(), Arrays.asList(Number.numberProperties));
            } else {
                Request.submitRequest(props);
            }
        }
    }
}