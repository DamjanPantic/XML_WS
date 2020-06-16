package com.programatori.rentalservice.tasks;

import com.programatori.rentalservice.repository.RentalRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;

@EnableAsync
public class ScheduledRentalRequestClearing {

    @Autowired
    RentalRequestRepository rentalRequestRepository;

    @Async
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTaskAsync() throws InterruptedException {
        System.out.println(
                "Fixed rate task async - " + System.currentTimeMillis() / 1000);
        Thread.sleep(2000);
    }
}
