package Autocar;

import java.util.Random;

public class DistLane extends Thread{
	private String eventName[] = {"Not In Lane Center", "Distance Getting Closer from the Front Car"};
	private int event;
	private int newSpeed;
	private DriveMediator med;
	
	public DistLane(DriveMediator mediator) {
		med = mediator;
	}
	
	public void run() {
		giveTime(4000);
		
		System.out.println("Distance/Lane controller at Work.");
		
		for(int i = 0; i<15; i++) {
			detectEvent();
			
			if(event == 7) {
				med.generation(eventName[0]);
				giveTime(2000);
				
				med.carPosition(event);
				giveTime(2000);
			
				med.correctPosition();
				giveTime(2000);
				
				System.out.println("Car succesfully back in Lane Center");
			}else if(event == 8) {
				med.generation(eventName[1]);
				giveTime(800);
				
				med.carPosition(event);
				giveTime(800);
				
				newSpeed = med.decrease();
				System.out.println("Current Decreased Speed for Distance from the Car Ahead : " + newSpeed + " KM");
				giveTime(800);
				
				newSpeed = med.balance(event);
				System.out.println("Current Increased Speed Following the Front Car Increasing Speed : " + newSpeed + " KM");
			}
			giveTime(3000);
		}
	}
	
	private void detectEvent() {
		Random rand = new Random();
		event = rand.nextInt(4) + 6;
	}
	
	private void giveTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
