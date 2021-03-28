package Autocar;

import java.util.Random;

public class TempControl extends Thread{
	private int event;
	private int newTemp;
	private DriveMediator med;
	
	public TempControl(DriveMediator mediator) {
		med = mediator;
	}
	
	public void run() {		
		giveTime(5000);
		System.out.println("Air Conditioner at Work.");
		
		for(int i = 0; i<15; i++) {
			detectEvent();
			
			if(event == 10) {
				newTemp = med.check(event);
				
				giveTime(2000);
				
				if(newTemp > 26) {
					newTemp = med.balance(event);
					System.out.println("Turn on AirCon to Lower Temperature, current Temperature : " + newTemp + " degrees");
				}else if(newTemp < 23) {
					newTemp = med.balance(event);
					System.out.println("Turn on Heater to Higher Temperature, current Temperature : " + newTemp + " degrees");
				}
			}
			giveTime(3000);
		}
	}
	
	private void detectEvent() {
		Random rand = new Random();
		event = rand.nextInt(2) + 9;
	}
	
	private void giveTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
