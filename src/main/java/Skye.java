import java.util.Scanner;

public class Skye {
    /**
     * Prints a string of characters as given
     * @param line String to output
     */
    public static void printString(String line) {
        System.out.println(line);
    }

    /**
     * Exits the program
     */
    public static void exitProgram() {
        System.out.println("Goodbye. Hope to see you again soon!");
        System.exit(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String logo = " ____  _               \n"
                + "/ ___|| | ___   _  ___ \n"
                + "\\___ \\| |/ / | | |/ _ \\\n"
                + " ___) |   <| |_| |  __/\n"
                + "|____/|_|\\_\\\\__, |\\___|\n"
                + "            |___/      \n";
        System.out.println("Hello from\n" + logo);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("bye")) {
                exitProgram();
            } else {
                printString(line);
            }
        }
    }
}
