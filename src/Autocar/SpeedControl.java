package Autocar;

import java.util.Random;

public class SpeedControl extends Thread{
	private int event;
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
			if(detectEvent() == 1) {
				
			}
		}
	}
	
	private int detectEvent() {
		Random rand = new Random();
		event = rand.nextInt(1);
		return event;
	}
}
