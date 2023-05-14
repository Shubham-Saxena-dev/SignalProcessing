package com.db.challenge.handlers;

import com.db.challenge.model.Command;
import org.springframework.stereotype.Component;

@Component
public class SignalTwoCommand extends SignalCommand {

    @Override
    public void execute(Command command) {
        command.getAlgo().reverse();
        command.getAlgo().setAlgoParam(1, command.getParam1());
        command.getAlgo().submitToMarket();
    }
}
