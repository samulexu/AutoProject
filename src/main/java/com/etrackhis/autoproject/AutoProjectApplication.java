package com.etrackhis.autoproject;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AutoProjectApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AutoProjectApplication.class);
        application.setApplicationStartup(new BufferingApplicationStartup(2048));
        application.run(args);

        System.out.println("(♥◠‿◠)ﾉﾞ自动任务服务启动成功 ლ(´ڡ`ლ)ﾞ  ");
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AutoProjectApplication.class);
    }
}