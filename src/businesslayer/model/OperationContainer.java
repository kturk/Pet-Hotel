package businesslayer.model;

import businesslayer.command.Command;

import java.util.ArrayList;
import java.util.List;

public class OperationContainer {
    private List<Command> operationContainer;

    public OperationContainer() {
        this.operationContainer = new ArrayList<Command>();
    }

    public void addCommand(Command c) {
        operationContainer.add(c);
    }

    public boolean removeCommand(Command c) {
        return operationContainer.remove(c);
    }

    public boolean isEmpty() {
        return operationContainer.isEmpty();
    }
}
