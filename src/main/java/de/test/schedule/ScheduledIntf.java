package de.test.schedule;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Timeout;


@Local
public interface ScheduledIntf {
    @Timeout
    void scheduleMe();

    void schedule();

    String getScheduledTasks();
}
