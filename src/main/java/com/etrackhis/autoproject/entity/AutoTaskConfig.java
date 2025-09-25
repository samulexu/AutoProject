package com.etrackhis.autoproject.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
@ConfigurationProperties(prefix = "etrack.auto")
@Data
public class AutoTaskConfig {
    private List<Task> taskList;

    @Data
    public static class Task {
        private String interId;
        private String cron;
    }
}
