package com.example.employeetraining.service.cronjob;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Component
@Slf4j
public class CronJobExample {

    private final TaskExecutor taskExecutor;

    public CronJobExample(@Qualifier("taskExecutor") TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    @Scheduled(cron = "${cron.expression}")
    public void sendAsync() {
        taskExecutor.execute(() -> log.info("Method executed at every 2 weeks. Current time is: {}", new Date()));
    }
}
