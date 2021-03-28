package Autocar;

import java.util.Random;

public class Brake extends Thread{
	private String eventName[] = {"Red Traffic Light", "Animal", "Pedestrian"};
	private int event;
	private int newSpeed;
	private DriveMediator med;
	
	public Brake(DriveMediator mediator) {
		med = mediator;
	}
	
	public void run() {
		giveTime(1500);
		
		System.out.println("Brake Control at Work.");
		
		for(int i = 0; i<15; i++) {
			detectEvent();
			
			if(event == 3) {
				med.generation(eventName[0]);
				
				giveTime(1000);
				
				med.spot(eventName[0]);
				slowDown(event);
				
				giveTime(1000);
				
				newSpeed = med.decrease();
				decreasedSpeed(event, newSpeed);
				
				giveTime(1000);
				
				newSpeed = med.waitSignal(event, eventName[0]);
				increasedSpeed(event, newSpeed);
			}else if(event == 4) {
				med.generation(eventName[1]);
				
				giveTime(1000);
				
				med.spot(eventName[1]);
				slowDown(event);
				
				giveTime(1000);
				
				newSpeed = med.decrease();
				decreasedSpeed(event, newSpeed);
				
				giveTime(1000);
				
				newSpeed = med.waitSignal(event, eventName[1]);
				increasedSpeed(event, newSpeed);
			}else if(event == 5) {
				med.generation(eventName[2]);
				
				giveTime(1000);
				
				med.spot(eventName[2]);
				slowDown(event);
				
				giveTime(1000);
				
				newSpeed = med.decrease();
				decreasedSpeed(event, newSpeed);
				
				giveTime(1000);
				
				newSpeed = med.waitSignal(event, eventName[2]);
				increasedSpeed(event, newSpeed);
			}
			giveTime(3000);
		}
	}
	
	private void detectEvent() {
		Random rand = new Random();
		event = rand.nextInt(6);
	}
	
	private void giveTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void slowDown(int detected) {
		if(detected == 3) {
			System.out.println("Slow Down to Stop at " + eventName[0] + "...");
		}else if(detected == 4) {
			System.out.println("Slow Down to Stop at " + eventName[1] + "...");
		}else if(detected == 5) {
			System.out.println("Slow Down to Stop at " + eventName[2] + "...");
		}
	}
	
	private void decreasedSpeed(int detected, int speed) {
		if(detected == 3) {
			System.out.println("Currently Decreased Speed infront of " + eventName[0] + " : " + speed + " KM");
		}else if(detected == 4) {
			System.out.println("Currently Decreased Speed infront of " + eventName[1] + " : " + speed + " KM");
		}else if(detected == 5) {
			System.out.println("Currently Decreased Speed infront of " + eventName[2] + " : " + speed + " KM");
		}
	}
	
	private void increasedSpeed(int detected, int speed) {
		if(detected == 3) {
			System.out.println("Currently Increased Speed infront of " + eventName[0] + " : " + speed + " KM");
		}else if(detected == 4) {
			System.out.println("Currently Increased Speed infront of " + eventName[1] + " : " + speed + " KM");
		}else if(detected == 5) {
			System.out.println("Currently Increased Speed infront of " + eventName[2] + " : " + speed + " KM");
		}
	}
}
