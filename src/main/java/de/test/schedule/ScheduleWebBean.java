package de.test.schedule;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class ScheduleWebBean {
    @EJB
    private ScheduledIntf service;

    private String timers;

    public String getTimers() {
        if (timers == null ) {
            timers = service.getScheduledTasks();
        }
        return timers;
    }

    public void schedule(){
        service.schedule();
    }
}
