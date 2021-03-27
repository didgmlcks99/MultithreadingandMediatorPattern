package Autocar;

import java.util.Scanner;
import java.util.Random;

public class CarBlackBox {
	public int event;
	public int speed;
	public int brake;
	public int temp;
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	public void start() {
		System.out.println("Self Driving Car Control");
		
		while(true){
			System.out.print("Car speed between 60 and 100 : ");
			speed = scan.nextInt();
			
			if(speed>100 || speed<60) {
				System.out.println("SPEED ERROR ! SPEED SHOULD BE BETWEEN 60 AND 100!");
			}else {
				break;
			}
		}
		
		DriveMediator mediator = new DriveMediator();
		
		new SpeedControl(mediator).start();
		new Brake(mediator).start();
		new TempCont(mediator).start();
		new DistLane(mediator).start();
	}
}
