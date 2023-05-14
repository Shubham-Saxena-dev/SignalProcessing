package com.db.challenge.model;


import com.db.challenge.handlers.SignalCommand;
import com.db.challenge.handlers.SignalOneCommand;
import com.db.challenge.handlers.SignalThreeCommand;
import com.db.challenge.handlers.SignalTwoCommand;
import com.db.challenge.handlers.DefaultSignalCommand;

public enum SignalType {

    SIGNAL_1(1, new SignalOneCommand()),
    SIGNAL_2(2, new SignalTwoCommand()),
    SIGNAL_3(3, new SignalThreeCommand()),
    DEFAULT(0, new DefaultSignalCommand());

    private final int signal;
    private final SignalCommand command;

    SignalType(int signal, SignalCommand command) {
        this.signal = signal;
        this.command = command;
    }

    public int getSignal() {
        return signal;
    }

    public static SignalCommand getHandler(int signal) {
        for (SignalType signalType : SignalType.values()) {
            if (signalType.getSignal() == signal) {
                return signalType.command;
            }
        }
        return DEFAULT.command;
    }
}
