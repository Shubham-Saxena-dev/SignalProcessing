package com.db.challenge.services;

import com.db.challenge.handlers.SignalCommand;
import com.db.challenge.model.Command;
import com.db.challenge.repository.SignalRepository;
import com.db.challenge.model.Signal;
import com.db.challenge.utilis.AlgoProvider;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignalService {

    private final SignalCommand signalCommand;
    private final SignalRepository signalRepository;

    public SignalService(SignalCommand signalCommand, SignalRepository signalRepository) {
        this.signalCommand = signalCommand;
        this.signalRepository = signalRepository;
    }

    public void handleSignal(Signal signal) {
        this.saveToRepo(signal);
        this.signalCommand
                .setCommand(this.buildCommand(signal.getParam1(), signal.getParam2()))
                .handleSignal(signal.getSignal());
    }

    @Transactional
    private void saveToRepo(Signal signal) {
        this.signalRepository.save(signal);
    }

    private Command buildCommand(int param1, int param2) {
        return new Command.Builder()
                .setAlgo(AlgoProvider.INSTANCE.getAlgo())
                .setParam1(param1)
                .setParam2(param2)
                .build();
    }
}
