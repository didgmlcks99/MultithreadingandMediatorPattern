package Autocar;

import java.util.Random;
import java.util.Scanner;

public class AutoCar {
	public int speed;
	public int brake;
	public int temp;
	
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();

	public void drive() {
		System.out.println("Self Driving Car Control");
		
		while(true){
			System.out.print("Car speed between 60 and 100 : ");
			this.speed = scan.nextInt();
			
			if(this.speed>100 || this.speed<60) {
				System.out.println("SPEED ERROR ! SPEED SHOULD BE BETWEEN 60 AND 100!");
			}else {
				break;
			}
		}
		this.brake = 0;
		this.temp = rand.nextInt(4) + 23;
		
		DriveMediator mediator = new DriveMediator();
		
		SpeedControl speed = new SpeedControl(mediator);
		Brake brake = new Brake(mediator);
		TempControl temp = new TempControl(mediator);
		DistLane distLane = new DistLane(mediator);
		
		speed.setPriority(10);
		brake.setPriority(9);
		temp.setPriority(3);
		distLane.setPriority(7);
		
		speed.start();
		brake.start();
		temp.start();
		distLane.start();
		
		scan.close();
	}
}