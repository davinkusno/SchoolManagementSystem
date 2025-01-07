package command;

/**
 * Invoker for executing commands.
 * It manages the execution of commands by calling their execute() method.
 */
public class Invoker {
    public void executeCommand(SchoolCommand command) {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Command is null, nothing to execute.");
        }
    }
}
