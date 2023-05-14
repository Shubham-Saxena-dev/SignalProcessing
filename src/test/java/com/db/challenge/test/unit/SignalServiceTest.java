package com.db.challenge.test.unit;

import com.db.challenge.handlers.SignalCommand;
import com.db.challenge.model.Command;
import com.db.challenge.model.Signal;
import com.db.challenge.repository.SignalRepository;
import com.db.challenge.services.SignalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Random;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SignalServiceTest {

    @Mock
    private SignalCommand signalCommand;

    @Mock
    private SignalRepository signalRepository;

    @InjectMocks
    private SignalService signalService;

    @Test
    public void givenSignal_whenSignalService_thenSuccess() {
        //given
        Signal signal = new Signal.Builder().setSignal(new Random().nextInt(5)).setParam1(10).setParam2(20).build();
        when(signalCommand.setCommand(any(Command.class))).thenReturn(signalCommand);

        //when
        signalService.handleSignal(signal);

        //then
        verify(signalRepository, atLeastOnce()).save(signal);
        verify(signalCommand, atLeastOnce()).setCommand(any(Command.class));
        verify(signalCommand, times(1)).handleSignal(signal.getSignal());
    }
}
