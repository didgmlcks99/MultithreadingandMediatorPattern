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
		
		BlackBox blackBox = new BlackBox();
		
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