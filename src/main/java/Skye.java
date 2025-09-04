import java.util.Scanner;
import java.util.ArrayList;

public class Skye {
    ArrayList<Task> tasks = new ArrayList<>();
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
        tasks.add(new Task(task));
    }

    /**
     * Prints the current list of tasks
     */
    public void listTask() {
        printString("Here are the list of tasks:");
        for (int i=0; i<tasks.size(); i++) {
            printString(i+1 + ". " + String.valueOf(tasks.get(i)));
        }
    }

    /**
     * Marks a task as complete
     */
    public void markTask(int number) {
        Task task = tasks.get(number - 1);
        task.setTaskComplete();
        printString("Well done! The task below has been completed:");
        printString(String.valueOf(task));
    }

    /**
     * Marks a task as incomplete
     */
    public void unmarkTask(int number) {
        printString("Ok, I have marked the task below as incomplete:");
        Task task = tasks.get(number - 1);
        task.setTaskIncomplete();
        printString(String.valueOf(task));
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
            } else if (line.startsWith("unmark")) {
                try {
                    int number = Integer.parseInt(line.split(" ", 2)[1]);
                    inst.unmarkTask(number);
                } catch (IndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("Invalid task number!");
                }
            }
            else if (line.startsWith("mark")) {
                try {
                    int number = Integer.parseInt(line.split(" ", 2)[1]);
                    inst.markTask(number);
                } catch (IndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("Invalid task number!");
                }
            } else {
                inst.addTask(line);
            }
        }
    }
}
