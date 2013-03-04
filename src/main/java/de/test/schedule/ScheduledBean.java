package de.test.schedule;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.*;
import java.util.Collection;
import java.util.Date;

@Stateless
public class ScheduledBean implements ScheduledIntf {
    private static Logger log = LoggerFactory.getLogger(ScheduledBean.class);

    @Resource
    private TimerService timerService;

    @Override
    @Timeout
    public void scheduleMe() {
        log.warn("Scheduled method executed. " + new Date().toString());
    }

    @Override
    public void schedule() {
        ScheduleExpression schedule = new ScheduleExpression();
        schedule.hour("*");
        schedule.minute("*");
        schedule.second("*");
        timerService.createCalendarTimer(schedule, new TimerConfig(null, true));
    }

    @Override
    public String getScheduledTasks() {
        Collection<Timer> timers = timerService.getTimers();
        StringBuilder builder = new StringBuilder();
        for (Timer timer : timers) {
            builder
                    .append("Timer: remaining: ")
                    .append(timer.getTimeRemaining())
                    .append(" next timeout: ")
                    .append(timer.getNextTimeout())
                    .append("\n");
        }
        return builder.toString();
    }
}
