package Autocar;

import java.util.Random;

public class SpeedControl extends Thread{
	private int event;
	private int newSpeed;
	private DriveMediator med;
	
	public SpeedControl(DriveMediator mediator) {
		med = mediator;
	}
	
	public void run() {
		giveTime(1000);
		System.out.println("Speed Controller at Work.");
		
		for(int i = 0; i<15; i++) {
			detectEvent();
			
			if(event == 1) {
				newSpeed = med.check(event);
				
				if(newSpeed >((med.getInitSpeed()*3)/4)) {
					if(newSpeed > med.getInitSpeed() + 3) {
						newSpeed = med.balance(event);
						System.out.println("Push brake to slow down Speed, current Speed : " + newSpeed + " KM");
					}else if(newSpeed < med.getInitSpeed() - 3) {
						newSpeed = med.balance(event);
						System.out.println("Push accel to pick up Speed, current Speed : " + newSpeed + " KM");
					}
				}
			}
			
			giveTime(3000);
		}
	}
	
	private void detectEvent() {
		Random rand = new Random();
		event = rand.nextInt(2);
	}
	
	private void giveTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
