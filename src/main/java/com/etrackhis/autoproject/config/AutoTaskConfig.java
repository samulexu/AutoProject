package com.etrackhis.autoproject.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * description :
 * author : 徐为强
 * date : 2025-09-25 10:23
 */
@Data
@Component
@Configuration
@ConfigurationProperties(prefix = "etrack.auto")
public class AutoTaskConfig {
    private List<String> interIdList;

    @Data
    public static class Task {
        private String interId;
        private String cron;
    }
}
