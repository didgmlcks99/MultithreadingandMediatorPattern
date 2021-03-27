package Autocar;

public class TempCont extends Thread{
	private DriveMediator med;
	
	public TempCont(DriveMediator mediator) {
		med = mediator;
	}
	
	public void run() {}

}
