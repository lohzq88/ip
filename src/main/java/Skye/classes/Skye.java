package Skye.classes;
import Skye.errors.IncompleteCommandException;
import Skye.errors.MissingFieldException;
import Skye.errors.SkyeException;
import Skye.errors.UnknownCommandException;

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
    public void addTask(Task task) {
        tasks.add(task);
        printString("Got it. I've added this task:");
        printString("  " + task.toString());
        printString("Now you have " + this.tasks.size() + " tasks in the list.");
    }

    /**
     * Prints the current list of tasks
     */
    public void listTask() {
        printString("Here are the list of tasks:");
        for (int i = 0; i < this.tasks.size(); i++) {
            printString((i + 1) + ". " + this.tasks.get(i));
        }
    }

    /**
     * Marks a task as complete
     */
    public void markTask(int number) {
        Task task = this.tasks.get(number - 1);
        task.setTaskComplete();
        printString("Well done! The task below has been completed:");
        printString(String.valueOf(task));
    }

    /**
     * Marks a task as incomplete
     */
    public void unmarkTask(int number) {
        printString("Ok, I have marked the task below as incomplete:");
        Task task = this.tasks.get(number - 1);
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
            try {
                String userInput = scanner.nextLine();
                String[] userInputContent = userInput.split(" ", 2);
                if (userInput.equals("bye")) {
                    exitProgram();
                } else if (userInput.equals("list")) {
                    inst.listTask();
                } else if (userInput.startsWith("unmark")) {
                    if (userInputContent.length < 2) {
                        throw new IncompleteCommandException("unmark");
                    }
                    int number = Integer.parseInt(userInputContent[1]);
                    inst.unmarkTask(number);
                } else if (userInput.startsWith("mark")) {
                    if (userInputContent.length < 2) {
                        throw new IncompleteCommandException("mark");
                    }
                    int number = Integer.parseInt(userInputContent[1]);
                    inst.markTask(number);
                } else if (userInput.startsWith("todo")) {
                    if (userInputContent.length < 2) {
                        throw new MissingFieldException("todo", "description");
                    }
                    inst.addTask(new ToDo(userInputContent[1]));
                } else if (userInput.startsWith("deadline")) {
                    if (userInputContent.length < 2) {
                        throw new MissingFieldException("deadline", "description");
                    }
                    String[] content = userInputContent[1].split(" /by ");
                    if (content.length == 1) {
                        throw new MissingFieldException("deadline", "by");
                    }
                    inst.addTask(new Deadline(content[0], content[1]));
                }
                else if (userInput.startsWith("event")) {
                    if (userInputContent.length < 2) {
                        throw new MissingFieldException("event", "description");
                    }
                    String[] eventDetails = userInputContent[1].split(" /from ");
                    if (eventDetails.length == 1) {
                        throw new MissingFieldException("event", "from");
                    }
                    String[] time = eventDetails[1].split(" /to ");
                    if (time.length == 1) {
                        throw new MissingFieldException("event", "to");
                    }
                    inst.addTask(new Event(eventDetails[0], time[0], time[1]));
                } else {
                    throw new UnknownCommandException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid task number!");
            } catch (SkyeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
