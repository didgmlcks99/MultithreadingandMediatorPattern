package Autocar;

import java.util.Random;

public class Brake extends Thread{
	private int event;
	private int newSpeed;
	private DriveMediator med;
	
	public Brake(DriveMediator mediator) {
		med = mediator;
	}
	
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Brake Control at Work.");
		
		for(int i = 0; i<5; i++) {
			detectEvent();
			
			if(event == 1) {
				System.out.println("Event Generated -- Red Traffic Light");
				
				med.spotRed();
				System.out.println("Slow Down to Stop at Red Light...");
				
				newSpeed = med.decreaseRed();
				System.out.println("Currently Decreased Speed infront of Red Traffic Light : " + newSpeed);
				
				newSpeed = med.waitSignal();
				System.out.println("Currently Increased Speed infront of Green Traffic Light : " + newSpeed);
			}else if(event == 2) {
				System.out.println("Event Generated -- Animal");
				
				med.spotAnimal();
				
				newSpeed = med.decreaseAnimal();
				System.out.println("Currently Decreased Speed infront of Animal : " + newSpeed);
				
				newSpeed = med.waitAnimal();
				System.out.println("Currently Increased Speed infront of Animal : " + newSpeed);
			}else if(event == 3) {
				System.out.println("Event Generated -- Pedestrian");
				
				med.spotPed();
				System.out.println("Slow Down to Stop at Pedestrian...");
				
				newSpeed = med.decreasePed();
				System.out.println("Currently Decreased Speed infront of Pedestrian : " + newSpeed);
				
				newSpeed = med.waitPed();
				System.out.println("Currently Increased Speed infront of Pedestrian : " + newSpeed);
			}
		}
	}
	
	private void detectEvent() {
		Random rand = new Random();
		event = rand.nextInt(4);
	}
}
