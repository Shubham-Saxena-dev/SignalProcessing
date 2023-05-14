package com.db.challenge.controllers;

import com.db.challenge.model.Signal;
import com.db.challenge.services.SignalService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/db")
@OpenAPIDefinition(info = @Info(title = "Deutsche Bank Exercise", description = "Signal Processor", version = "v1.0"))
public class SignalController {

    private static final String SIGNAL_PATH = "/signal";
    private final SignalService signalService;

    public SignalController(SignalService tradingService) {
        this.signalService = tradingService;
    }

    @Operation(summary = "Process a signal")
    @ApiResponse(responseCode = "200", description = "Signal Processed")
    @PostMapping(value = SIGNAL_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> receiveSignal(@RequestBody Signal signal) {
        signalService.handleSignal(signal);
        return ResponseEntity.ok().build();
    }
}
