package numbers;

public class Request {

    public static void submitRequest(String[] args) {
        switch (args.length) {
            case 1:
                Properties.processProperties(Long.parseLong(args[0]));
                break;
            case 2:
                Properties.processProperties(Long.parseLong(args[0]), Long.parseLong(args[1]));
                break;
            case 3:
                Properties.processProperties(Long.parseLong(args[0]), Long.parseLong(args[1]), args[2]);
                break;
        }
    }
}
