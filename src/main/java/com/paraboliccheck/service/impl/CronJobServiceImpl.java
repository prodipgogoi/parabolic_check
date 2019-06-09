package com.paraboliccheck.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.paraboliccheck.service.CronJobService;
import com.paraboliccheck.service.DataCollectorService;

@Service
public class CronJobServiceImpl implements CronJobService {

	@Autowired
	private DataCollectorService dataCollectorService;

	private String symbol = "FUTCOM_CRUDEOIL_19JUN2019__0";

	private boolean isRunning = true;

	@Override
	public void startCronJob() {

		while (isRunning) {
			int hours = java.time.LocalTime.now().getHour();
			if (hours <= 23 && hours >= 9) {
				new Thread(() -> {
					System.out.println("start processing.");
					dataCollectorService.getCurrentFeeds(symbol, "5");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					dataCollectorService.getCurrentFeeds(symbol, "30");
				}).start();
				try {
					Thread.sleep(1000 * 60 * 5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				isRunning = false;
			}
		}
	}

	public void setIsRunning() {
		this.isRunning = true;
	}

}
