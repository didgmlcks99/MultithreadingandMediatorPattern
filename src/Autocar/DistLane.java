package Autocar;

public class DistLane extends Thread{
	private DriveMediator med;
	
	public DistLane(DriveMediator mediator) {
		med = mediator;
	}
	
	public void run() {}

}
