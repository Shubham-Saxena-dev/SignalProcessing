package com.db.challenge.test.medium;


import com.db.challenge.model.Signal;
import com.db.challenge.repository.SignalRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class SignalControllerTest extends AbstractMediumTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SignalRepository signalRepository;

    @Before
    public void before() {
        signalRepository.deleteAll();
    }

    @Test
    public void givenUser_whenValidInput_thenSucceed() throws Exception {
        // given
        Signal signal = new Signal.Builder().setSignal(new Random().nextInt(5)).setParam1(10).setParam2(20).build();

        //when
        this.mockMvc.perform(post("/api/db/signal").header(HEADER_NAME, HEADER_VALUE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(signal)))
                .andExpect(status().isOk());
        //then
        List<Signal> signals = this.signalRepository.findAll();
        assertEquals(signals.get(0).getSignal(), signal.getSignal());
        assertEquals(signals.get(0).getParam1(), signal.getParam1());
        assertEquals(signals.get(0).getParam2(), signal.getParam2());
    }

    @Test
    public void givenUser_whenNoHeader_thenUnAuthorize() throws Exception {
        // given
        Signal signal = new Signal.Builder().setSignal(new Random().nextInt(3)).setParam1(10).setParam2(20).build();
        //when
        this.mockMvc.perform(post("/api/db/signal")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(signal)))
                .andExpect(status().isUnauthorized());
    }
}