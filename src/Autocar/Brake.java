package Autocar;

public class Brake extends Thread{
	private DriveMediator med;
	private int event;
	
	public Brake(DriveMediator mediator) {
		med = mediator;
	}
	
	public void run() {}
	
}
