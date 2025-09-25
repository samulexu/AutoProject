package com.etrackhis.autoproject.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.config.CronTask;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Component
@Slf4j
public class CronTaskRegister {

    private final Map<Runnable, ScheduledTask> scheduledTasks = new ConcurrentHashMap<>(16);

    @Autowired
    private TaskScheduler taskScheduler;

    public TaskScheduler getScheduler() {
        return this.taskScheduler;
    }

    public void addCronTask(Runnable task, String cronExpression) {
        addCronTask(new CronTask(task, cronExpression));
    }

    public void addCronTask(CronTask cronTask) {
        if (cronTask != null) {
            Runnable task = cronTask.getRunnable();
            if (this.scheduledTasks.containsKey(task)) { removeCronTask(task); }
            this.scheduledTasks.put(task, scheduleCronTask(cronTask));
        }
    }

    public boolean containTask(Runnable task){
        return this.scheduledTasks.containsKey(task);
    }

    public Runnable getTask(Runnable task){
        if (this.scheduledTasks.containsKey(task)){
            return task;
        }else {
            return null;
        }
    }


    public void removeCronTask(Runnable task) {
        ScheduledTask scheduledTask = this.scheduledTasks.remove(task);
        if (scheduledTask != null){scheduledTask.cancel();}
    }

    public ScheduledTask scheduleCronTask(CronTask cronTask) {
        ScheduledTask scheduledTask = new ScheduledTask();
        scheduledTask.future = this.taskScheduler.schedule(cronTask.getRunnable(), cronTask.getTrigger());
        return scheduledTask;
    }

    public boolean clearTask(){
        try {
            scheduledTasks.forEach((runnable, scheduledTask) -> {
                this.removeCronTask(runnable);
            });
        }catch (Exception e){
            log.error("清除所有任务时发生错误：",e);
            return false;
        }
        return true;
    }

    public void destroy() {
        for (ScheduledTask task : this.scheduledTasks.values()) { task.cancel(); }
        this.scheduledTasks.clear();
    }
}
