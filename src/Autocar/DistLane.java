package Autocar;

import java.util.Random;

public class DistLane extends Thread{
	private int event;
	private DriveMediator med;
	
	public DistLane(DriveMediator mediator) {
		med = mediator;
	}
	
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Distance/Lane controller at Work.");
		
		for(int i = 0; i<5; i++) {
			detectEvent();
			
			if(event == 1) {
				System.out.println("Event Generated -- Not In Lane Center");
				
				med.spotLane();
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				med.correctLane();
			}
		}
	}
	
	private void detectEvent() {
		Random rand = new Random();
		event = rand.nextInt(2);
	}
}
