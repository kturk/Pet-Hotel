package businesslayer.command;

import businesslayer.model.OperationType;

public interface ICommandFactory {

    Command getCommand(OperationType operationType);
}
