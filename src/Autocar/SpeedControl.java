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
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Speed Controller at Work.");
		
		for(int i = 0; i<5; i++) {
			
			detectEvent();
			
			if(event == 1) {
				
				newSpeed = med.checkSpeed();
				System.out.println("Thread for Speed Control, current Speed : " + newSpeed);
				
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(newSpeed > med.getInitSpeed() + 3) {
					newSpeed = med.balanceSpeed();
					System.out.println("Push brake to slow down Speed, current Speed : " + newSpeed);
				}else if(newSpeed < med.getInitSpeed() - 3) {
					newSpeed = med.balanceSpeed();
					System.out.println("Push accel to pick up Speed, current Speed : " + newSpeed);
				}
			}
		}
	}
	
	private void detectEvent() {
		Random rand = new Random();
		event = rand.nextInt(2);
	}
}
