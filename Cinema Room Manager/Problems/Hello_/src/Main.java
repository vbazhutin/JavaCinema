import java.util.Scanner;
class Main {
    public static void main(String[] args) {


        //initialize scanner
        Scanner input = new Scanner(System.in);

        //initialize variables
        int bridgeCount = 1;

        //Input height of the bus and the amount of bridges
        int busHeight = input.nextInt();
        int numOfBridges = input.nextInt();

        //Input height for the all the bridges
        Scanner bridges = new Scanner(System.in);

        //Calculate if the bus will pass through the bridge
        while (bridges.hasNext()) {
            bridgeCount++;
            int bridgeHeight = bridges.nextInt();
            if (busHeight >= bridgeHeight) {
                System.out.println("Will crash on bridge " + bridgeCount);
                break;
            } else if (bridgeCount == numOfBridges) {
                System.out.println("Will not crash");
            }
        }
    }
}