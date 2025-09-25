package com.etrackhis.autoproject.config;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * description :
 * author : 徐为强
 * date : 2025-09-25 10:23
 */
@Data
@Component
public class AutoTaskConfig {
    private List<String> interIdList;
}
