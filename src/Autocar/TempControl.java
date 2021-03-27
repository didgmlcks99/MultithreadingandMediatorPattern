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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Air Conditioner at Work.");
		
		for(int i = 0; i<5; i++) {
			detectEvent();
			if(event == 1) {
				
				newTemp = med.checkSpeed();
				System.out.println("Thread for Air Condintioner, current Temperature : " + newTemp);
				
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(newTemp > med.getInitSpeed() + 3) {
					newTemp = med.balanceTemp();
					System.out.println("Turn on AirCon to Lower Temperature, current Temperature : " + newTemp);
				}else if(newTemp < med.getInitSpeed() - 3) {
					newTemp = med.balanceTemp();
					System.out.println("Turn on Heater to Higher Temperature, current Temperature : " + newTemp);
				}
			}
		}
	}
	
	private void detectEvent() {
		Random rand = new Random();
		event = rand.nextInt(2);
	}
}
