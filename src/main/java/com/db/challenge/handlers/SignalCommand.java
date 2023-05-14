package com.db.challenge.handlers;

import com.db.challenge.model.Command;
import com.db.challenge.model.SignalType;
import com.db.challenge.utilis.SignalHandler;
import org.springframework.stereotype.Component;

@Component
public abstract class SignalCommand implements SignalHandler {

    public abstract void execute(Command command);

    private Command command;

    @Override
    public void handleSignal(int signal) {
        SignalCommand handler = SignalType.getHandler(signal);
        handler.execute(command);
        command.getAlgo().doAlgo();
    }

    public SignalCommand setCommand(Command command) {
        this.command = command;
        return this;
    }
}
