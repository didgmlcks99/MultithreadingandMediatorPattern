package Autocar;

import java.util.Random;

public class DriveMediator {
	public int initSpeed;
	public int speed;
	public int brake;
	public int initTemp;
	public int temp;
	public int event;
	public boolean eventFull = false;
	
	public Random rand = new Random();
	
	public DriveMediator(AutoCar benz) {
		this.initSpeed = benz.speed;
		this.speed = benz.speed;
		
		System.out.println("Speed set to : " + initSpeed);
		
		this.brake = benz.brake;
		this.initTemp = benz.temp;
		this.temp = benz.temp;
		
		System.out.println("Temp set to : " + initTemp);
	}
	
	public synchronized int checkSpeed() {
		while(eventFull == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		eventFull = true;
		
		int increase, decrease;
		
		increase = rand.nextInt(16) + (initSpeed - 10);
		decrease = rand.nextInt(16) + (initSpeed - 10);
		
		speed += +increase -decrease;
		
		eventFull = false;
		notifyAll();
		
		return speed;
	}
	
	public synchronized int balanceSpeed() {
		while(eventFull == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		eventFull = true;
		
		speed = rand.nextInt(7) + (initSpeed-3);
		
		eventFull = false;
		notifyAll();
		return speed;
	}
	
	public synchronized void spotRed() {
		while(eventFull == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		eventFull = true;
		
		System.out.println("Red Traffic Light Sensed...");
		
		eventFull = false;
		notifyAll();
	}
	
	public synchronized int decreaseRed() {
		while(eventFull == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		eventFull = true;
		
		speed = rand.nextInt(5) + 8;
		
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		eventFull = false;
		notifyAll();
		return speed;
	}
	
	public synchronized int waitSignal() {
		while(eventFull == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		eventFull = true;
		
		speed = 0;
		
		System.out.println("Now the car made a complete stop infront of Red Light : "+ speed);
		
		for(int i=0; i<rand.nextInt(10); i++) {
			
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.print(".");
		}System.out.println("Green Light Sensed..");
		
		speed += rand.nextInt(16) + 30;
		
		eventFull = false;
		notifyAll();
		
		return speed;
	}
	
	public synchronized void spotAnimal() {
		while(eventFull == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		eventFull = true;
		
		System.out.println("Animal Crossing Sensed, Slow Down : SLOW DOWN!!!");
		
		eventFull = false;
		notifyAll();
	}
	
	public synchronized int decreaseAnimal() {
		while(eventFull == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		eventFull = true;
		
		speed = rand.nextInt(5) + 8;
		
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		eventFull = false;
		notifyAll();
		return speed;
	}
	
	public synchronized int waitAnimal() {
		while(eventFull == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		eventFull = true;
		
		speed = 0;
		
		System.out.println("Now the car made a complete stop infront of Aninmal : "+ speed);
		
		for(int i=0; i<rand.nextInt(10); i++) {
			
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.print(".");
		}System.out.println("Animal cleared out the way.");
		
		speed += rand.nextInt(16) + 30;
		
		eventFull = false;
		notifyAll();
		
		return speed;
	}
	
	public synchronized void spotPed() {
		while(eventFull == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		eventFull = true;
		
		System.out.println("Pedestrian Crossing Sensed, Slow Down : SLOW DOWN!!!");
		
		eventFull = false;
		notifyAll();
	}
	
	public synchronized int decreasePed() {
		while(eventFull == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		eventFull = true;
		
		speed = rand.nextInt(6) + 8;
		
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		eventFull = false;
		notifyAll();
		return speed;
	}
	
	public synchronized int waitPed() {
		while(eventFull == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		eventFull = true;
		
		speed = 0;
		
		System.out.println("Now the car made a complete stop infront of Pedestrian : "+ speed);
		
		for(int i=0; i<rand.nextInt(10); i++) {
			
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.print(".");
		}System.out.println("Pedestrian cleared out the way.");
		
		speed += rand.nextInt(16) + 30;
		
		eventFull = false;
		notifyAll();
		
		return speed;
	}
	
	public synchronized void spotLane() {
		while(eventFull == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		eventFull = true;
		
		System.out.println("Sensed Car not in Lane Center..");
		
		eventFull = false;
		notifyAll();
	}
	
	public synchronized void correctLane() {
		while(eventFull == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		eventFull = true;
		
		System.out.println("Correcting car position to Lane Center");
		
		eventFull = false;
		notifyAll();
	}
	
	public synchronized int checkTemp() {
		while(eventFull == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		eventFull = true;
		
		int increase, decrease;
		
		increase = rand.nextInt(8) + 23;
		decrease = rand.nextInt(8) + 23;
		
		temp += +increase -decrease;
		
		eventFull = false;
		notifyAll();
		
		return temp;
	}
	
	public synchronized int balanceTemp() {
		while(eventFull == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		eventFull = true;
		
		temp = rand.nextInt(4) + (23);
		
		eventFull = false;
		notifyAll();
		return temp;
	}
	
	public int getInitSpeed() {
		return initSpeed;
	}
	
	public int getInitTemp() {
		return initTemp;
	}
}
