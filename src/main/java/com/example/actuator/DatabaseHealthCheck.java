package com.example.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("database")
public class DatabaseHealthCheck implements HealthIndicator {
    @Override
    public Health health() {
        if (true) {
            return Health.up().withDetail("storage", "enough").build();
        } else {
            return Health.down().withDetail("storage", "not enough").build();
        }
    }
}
