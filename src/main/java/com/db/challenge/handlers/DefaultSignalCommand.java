package com.db.challenge.handlers;

import com.db.challenge.model.Command;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DefaultSignalCommand extends SignalCommand {

    @Override
    public void execute(Command command) {
        command.getAlgo().cancelTrades();
    }
}
