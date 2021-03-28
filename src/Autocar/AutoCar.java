package Autocar;

import java.util.Random;
import java.util.Scanner;

public class AutoCar {
	public int speed;
	public int temp;
	
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();

	public void drive() {
		System.out.println("Self Driving Car Control");
		
		BlackBox blackBox = new BlackBox();
		
		String strSpeed;
		while(true) {
			System.out.print("Car speed between 60 and 100 : ");
			strSpeed = scan.next();
			
			try {
				this.speed = Integer.parseInt(strSpeed);
				if(this.speed > 100 || this.speed < 60) {
					throw new ArithmeticException("Access denied - it must be between 60 and 100");
				}
				break;
			}catch(Exception e){
				System.out.println("[ERROR] speed should be between 60 and 100!");
			}
		}
		this.temp = rand.nextInt(4) + 23;
		
		DriveMediator mediator = new DriveMediator(this);
		
		SpeedControl speed = new SpeedControl(mediator);
		Brake brake = new Brake(mediator);
		TempControl temp = new TempControl(mediator);
		DistLane distLane = new DistLane(mediator);
		
		speed.setPriority(6);
		brake.setPriority(10);
		temp.setPriority(3);
		distLane.setPriority(8);
		
		speed.start();
		brake.start();
		temp.start();
		distLane.start();
		
		while(speed.isAlive() || brake.isAlive() || temp.isAlive() || distLane.isAlive()) {}
		blackBox = mediator.getBlackBox();
		blackBox.printBlackBoxData();
		
		scan.close();
	}
}