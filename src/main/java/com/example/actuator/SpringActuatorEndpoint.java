package com.example.actuator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id="spring")
@Slf4j
public class SpringActuatorEndpoint {
    private Map<String, String> map;

    public SpringActuatorEndpoint() {
        map = new HashMap<>();
        map.put("memory", "1024KB");
        map.put("disk", "1024GB");

    }
    @ReadOperation
    public Map<String, String> readSpringNote() {
        return map;
    }

    @WriteOperation
    public Map<String, String> writeSpringNote(@Selector String key, @Selector String value) {
        map.put(key, value);
        return map;
    }

    @DeleteOperation
    public Map<String, String> deleteSpringNote(@Selector String key) {
        map.remove(key);
        return map;
    }
}
