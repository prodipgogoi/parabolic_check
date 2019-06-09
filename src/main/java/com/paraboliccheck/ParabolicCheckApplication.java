package com.paraboliccheck;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.paraboliccheck.data.CommonData;
import com.paraboliccheck.entity.OrderModel;
import com.paraboliccheck.handlers.PushBulletHandler;
import com.paraboliccheck.handlers.RestHandlers;
import com.paraboliccheck.model.OrderRes;
import com.paraboliccheck.model.OrderedReq;
import com.paraboliccheck.repository.OrderRepository;
import com.paraboliccheck.service.CronJobService;

@SpringBootApplication
@EnableScheduling
public class ParabolicCheckApplication {

	@Autowired
	private CronJobService cronJobService;
	
	@Autowired
	private PushBulletHandler pushBullet;
	
	@Autowired
	private RestHandlers restHandlers;
	
	@Autowired
	private OrderRepository orderRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ParabolicCheckApplication.class, args);
	}
	
	
	
	@PostConstruct
	private void checkOreder() {
		OrderedReq req = new OrderedReq("b", "MCX_FO", "CRUDEOILM19JUNFUT", 10, "m", "i");
		OrderRes orderRes=restHandlers.placeOrder(req);
		OrderModel model = orderRes.getData();
		orderRepository.save(model);
	}

//	@PostConstruct
//	@Scheduled(cron = "0 0 9 * * ?")
//	public void startCrons() {
//		CommonData.clearLists();
//		pushBullet.sendBullet("Starting the server");
//		System.out.println("Running the thread.");
//		new Thread(()-> {
//			cronJobService.setIsRunning();
//			
//			cronJobService.startCronJob();
//		}).start();		
//	}

}
