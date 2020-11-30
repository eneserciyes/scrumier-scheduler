package tr.com.ogedik.scheduler.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tr.com.ogedik.commons.rest.response.model.WorklogContainer;
import tr.com.ogedik.scrumier.proxy.clients.IntegrationProxy;
import tr.com.ogedik.scrumier.proxy.clients.TimeTrackerProxy;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @author enes.erciyes
 */
@Component
public class EmailNotificationScheduler {

    @Autowired
    TimeTrackerProxy timeTrackerProxy;

    @Scheduled(fixedRate = 1000)
    public void writeToConsole(){
        System.out.println("Scheduled job working");
    }

    @Scheduled(fixedRate = 1000)
    public void sendReminderMail(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(new Date());
        WorklogContainer container = timeTrackerProxy.getWorklogs("",today,today, "false");

        System.out.println(container);
    }
}
