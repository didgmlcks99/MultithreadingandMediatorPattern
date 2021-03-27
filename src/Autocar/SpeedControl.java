package Autocar;

//import java.util.Random;
//import java.lang.Math;

public class SpeedControl extends Thread{
	private DriveMediator med;
	private int currentSpeed;
	
	public SpeedControl(DriveMediator mediator) {
		med = mediator;
	}
	
	public void run() {}
}
