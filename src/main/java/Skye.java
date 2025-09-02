import java.util.Scanner;
import java.util.ArrayList;

public class Skye {
    ArrayList<String> tasks = new ArrayList<>();
    /**
     * Prints a string of characters as given
     * @param line String to output
     */
    public static void printString(String line) {
        System.out.println(line);
    }

    /**
     * Adds a task to the list of tasks
     * @param task The given task
     */
    public void addTask(String task) {
        printString("added: " + task);
        tasks.add(task);
    }

    /**
     * Prints the current list of tasks
     */
    public void listTask() {
        printString("Here are the list of tasks:");
        for (int i=0; i<tasks.size(); i++) {
            printString(i+1 + ": " + tasks.get(i));
        }
    }

    /**
     * Exits the program
     */
    public static void exitProgram() {
        System.out.println("Goodbye. Hope to see you again soon!");
        System.exit(0);
    }

    public static void main(String[] args) {
        Skye inst = new Skye();
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
            } else if (line.equals("list")) {
                inst.listTask();
            } else {
                inst.addTask(line);
            }
        }
    }
}
