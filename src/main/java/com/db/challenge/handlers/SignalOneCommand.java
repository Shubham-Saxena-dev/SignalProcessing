package com.db.challenge.handlers;

import com.db.challenge.model.Command;
import org.springframework.stereotype.Component;

@Component
public class SignalOneCommand extends SignalCommand {

    @Override
    public void execute(Command command) {
        command.getAlgo().setUp();
        command.getAlgo().setAlgoParam(1, command.getParam1());
        command.getAlgo().performCalc();
        command.getAlgo().submitToMarket();
    }
}
