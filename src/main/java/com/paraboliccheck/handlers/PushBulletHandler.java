package com.paraboliccheck.handlers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.github.sheigutn.pushbullet.Pushbullet;
import com.github.sheigutn.pushbullet.items.push.sendable.defaults.SendableNotePush;
import com.github.sheigutn.pushbullet.items.push.sent.Push;
import com.paraboliccheck.model.PushBulletModel;

@Component
public class PushBulletHandler {

	public void sendBullet(String message) {
		String url =  "https://api.pushbullet.com/v2/pushes";
		String accessKey = "o.Q2KIXMDJtqVfn6kTICA2IWV5onS7PxKE";
		pushBulletSends(message);
	}
	
	
	private void pushBulletSends(String message) {
		String apiToken = "o.Q2KIXMDJtqVfn6kTICA2IWV5onS7PxKE";
		Pushbullet pushbullet = new Pushbullet(apiToken);
		
		SendableNotePush push = new SendableNotePush("Order message", message);
		pushbullet.push(push);
	}
}
