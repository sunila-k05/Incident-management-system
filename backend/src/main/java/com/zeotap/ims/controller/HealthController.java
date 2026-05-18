package com.zeotap.ims.controller;

import com.zeotap.ims.engine.SignalBuffer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/health")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class HealthController {

    private final SignalBuffer signalBuffer;

    @GetMapping
    public ResponseEntity<Map<String, Object>> health() {

        Map<String, Object> health = new LinkedHashMap<>();

        health.put("status", "UP");
        health.put("timestamp", Instant.now().toString());

        health.put("bufferSize", signalBuffer.getCurrentSize());
        health.put("bufferCapacity", signalBuffer.getCapacity());
        health.put("totalSignalsReceived", signalBuffer.getTotalReceived());

        return ResponseEntity.ok(health);
    }
}
