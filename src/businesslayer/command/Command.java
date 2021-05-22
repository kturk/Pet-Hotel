package businesslayer.command;

public interface Command {

    void execute();

    void undo(); // This command is for miss clicking in the UI while execute.

}
