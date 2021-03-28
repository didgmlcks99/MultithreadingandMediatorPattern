package Autocar;

import java.util.Random;

public class DriveMediator {
	public int initSpeed;
	public int speed;
	public int brake;
	public int temp;
	public int event;
	public BlackBox blackBox = new BlackBox();
	public boolean eventFull = false;
	
	public Random rand = new Random();
	
	public DriveMediator(AutoCar benz) {
		blackBox.setInit();
		
		this.initSpeed = benz.speed;
		this.speed = benz.speed;
		
		System.out.println("Speed set to : " + initSpeed + " KM");
		
		this.brake = benz.brake;
		this.temp = benz.temp;
		
		System.out.println("Temp set to : " + temp + " degrees");
	}
	
	public synchronized void generation(String eventName) {
		while(eventFull == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		eventFull = true;
		
		giveTime(600);
		eventFull = false;
		notifyAll();
		
		System.out.println("Event Generated -- " + eventName);
	}
	
	public synchronized int check(int detected) {
		while(eventFull == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		eventFull = true;
		
		int increase, decrease;
		
		if(detected == 1) {
			increase = rand.nextInt(15) + (initSpeed - 10);
			decrease = rand.nextInt(10) + (initSpeed - 10);
			
			speed += +increase -decrease;
		}else if(detected == 10) {
			increase = rand.nextInt(10) + 23;
			decrease = rand.nextInt(10) + 23;
			
			temp += +increase -decrease;
		}
		
		giveTime(600);
		eventFull = false;
		notifyAll();
		
		if(detected == 1) {
			System.out.println("Thread for Speed Control, current Speed : " + speed + " KM");
			return speed;
		}else if(detected == 10) {
			System.out.println("Thread for Air Condintioner, current Temperature : " + temp + " degrees");
			return temp;
		}
		return 0;
	}
	
	public synchronized int balance(int detected) {
		while(eventFull == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		eventFull = true;
		
		if(detected == 1) {
			speed = rand.nextInt(7) + (initSpeed-3);
		}else if(detected == 10) {
			if(temp > 26) {
				blackBox.heater++;
			}else if(temp < 23) {
				blackBox.aircon++;
			}
			temp = rand.nextInt(4) + (23);
		}else if(detected == 8) {
			speed += rand.nextInt(10) + (((initSpeed*3)/4) - 10);
		}
		
		giveTime(600);
		eventFull = false;
		notifyAll();
		
		if(detected == 1 || detected == 8) {
			return speed;
		}else if(detected == 10) {
			return temp;
		}
		return 0;
	}
	
	public synchronized void spot(String eventName) {
		while(eventFull == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		eventFull = true;
		
		System.out.println(eventName + " Sensed, Slow Down : SLOW DOWN!!!");
		
		giveTime(600);
		eventFull = false;
		notifyAll();
	}
	
	public synchronized int decrease() {
		while(eventFull == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		eventFull = true;
		
		speed = rand.nextInt(6) + 8;
		
		giveTime(600);
		eventFull = false;
		notifyAll();
		
		return speed;
	}
	
	public synchronized int waitSignal(int detected, String eventName) {
		while(eventFull == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		eventFull = true;
		
		speed = 0;
		
		System.out.println("Now the car made a complete stop infront of " + eventName + " : "+ speed + " KM");

		for(int i=0; i<rand.nextInt(30) + 5; i++) {
			giveTime(800);
			System.out.print(".");
		}
		
		if(detected == 3) {
			blackBox.redLight++;
			System.out.print("Green Light Sensed... ");
		}else if(detected == 4) {
			blackBox.animal++;
			System.out.print("Animal cleared out the way... ");
		}else if(detected == 5) {
			blackBox.pedestrian++;
			System.out.print("Pedestrian crossed the road... ");
		}
		
		giveTime(1000);
		
		System.out.println("Start Driving.");
		
		speed += rand.nextInt(10) + (((initSpeed*3)/4) - 10);
		
		giveTime(600);
		eventFull = false;
		notifyAll();
		
		return speed;
	}
	
	public synchronized void carPosition(int detected) {
		while(eventFull == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		eventFull = true;
		
		if(detected == 7) {
			blackBox.lane++;
			System.out.println("Sensed Car not in Lane Center");
		}else if(detected == 8) {
			blackBox.distance++;
			System.out.println("The Speed of Front Car Dropping Fast : Slow to Keep Distance");
		}
		
		giveTime(600);
		eventFull = false;
		notifyAll();
	}
	
	public synchronized void correctPosition() {
		while(eventFull == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		eventFull = true;
		

		System.out.println("Correcting car position to Lane Center");

		
		giveTime(600);
		eventFull = false;
		notifyAll();
	}
	
	public int getInitSpeed() {
		return initSpeed;
	}
	
	private void giveTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public BlackBox getBlackBox() {
		return blackBox;
	}
}
