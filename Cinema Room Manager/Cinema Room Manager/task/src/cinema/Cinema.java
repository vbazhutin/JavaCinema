package cinema;
import java.util.Scanner;

public class Cinema {
    public static final Scanner input = new Scanner(System.in);
    public static int numberOfRows;
    public static int numberOfSeatsInRow;
    public static int rowNumber;
    public static int seatNumber;
    public static int totalSeats;
    public static int ticketCost;
    public static int totalTickets;
    public static int currentIncome;
    public static int totalIncomePossible;
    public static float totalTicketsPercentage;



    private static String[][] cinema;
    private static final String EMPTY_SEAT = "S";
    private static final String BUSY_SEAT = "B";

    public static void main(String[] args) {

        showMenu();

    }

    /* Show cinema statistics on the screen */
    public static void showStatistics() {

        System.out.println("Number of purchased tickets: " + totalTickets);
        System.out.printf("Percentage: %.2f%%%n", totalTicketsPercentage);
        System.out.printf("Current income: $%d%n", currentIncome);
        System.out.printf("Total income: $%d%n", totalIncomePossible);

    }

    /**
     * Showing the menu on the screen with 3 different options
     */
    public static void showMenu() {

        arrangeSeats();
        buildCinema();
        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    showSeats();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    showStatistics();
                    break;
                case 0:
                    exit = true;
                    return;
            }
        }
    }

    /**
     * Arranging cinema with the start of the program
     * by choosing the amount of rows (max-9) and seat(max-9)
     */
    public static void  arrangeSeats() {
        //Manual input of rows and rows
        System.out.println("Enter the number of rows: ");
        numberOfRows = input.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        numberOfSeatsInRow = input.nextInt();
        totalSeats = numberOfSeatsInRow * numberOfSeatsInRow;
        if (totalSeats <= 60) {
            totalIncomePossible = totalSeats * 10;
        } else {
            totalIncomePossible = (numberOfRows / 2 + 1) * 8 * numberOfSeatsInRow + numberOfRows / 2 * 10 * numberOfSeatsInRow;
        }

        cinema = new String[numberOfRows + 1][numberOfSeatsInRow + 1];
    }

    /**
     * Assigning values to an array to build cinema rows and seat later
     * so we can render it afterwards
     */

    public static void buildCinema() {
        for (int i = 0; i < numberOfRows + 1; i++) {
            for (int j = 0; j < numberOfSeatsInRow + 1; j++) {
                if (i == 0 && j == 0) {
                    cinema[i][j] = " ";
                } else if (i == 0) {
                    cinema[i][j] = String.valueOf(j);
                } else if (j == 0) {
                    cinema[i][j] = String.valueOf(i);
                } else {
                    cinema[i][j] = EMPTY_SEAT;
                }
            }
        }
    }

    /**
     * Rendering cinema rows and sets on the display
     */
    public static void showSeats() {
        System.out.println("\nCinema: ");
        for (int i = 0; i < numberOfRows + 1; i++) {
            for (int j = 0; j < numberOfSeatsInRow + 1; j++) {
                System.out.print(cinema[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Buying ticket includes reassign of base cinema array to show
     * the bought seat and ticket price output
     *
     */
    public static void buyTicket() {

        while (true) {
            System.out.println("\nEnter a row number: ");
            rowNumber = input.nextInt();
            System.out.println("Enter a seat number in that row: ");
            seatNumber = input.nextInt();

            if (rowNumber > numberOfRows || rowNumber < 1 || seatNumber > numberOfSeatsInRow || numberOfSeatsInRow < 1) {
                System.out.println("Wrong input!");
                continue;
            } else if (cinema[rowNumber][seatNumber] == EMPTY_SEAT) {
                calculateTicketCost();
                System.out.println("Ticket price: $" + ticketCost);
                currentIncome += ticketCost;
                totalTickets++;
                cinema[rowNumber][seatNumber] = BUSY_SEAT;
                totalTicketsPercentage = (float) totalTickets / totalSeats * 100;
                break;
            } else {
                System.out.println("That ticket has already been purchased!");
                continue;
            }
        }
    }

    /**
     * Calculating the ticket price based on the cinema size and row number
     *
     */
    public static void calculateTicketCost() {

        if (totalSeats <= 60) {
            ticketCost = 10;
        } else {
            ticketCost = rowNumber <= 4 ? 10 : 8;
        }
    }
}