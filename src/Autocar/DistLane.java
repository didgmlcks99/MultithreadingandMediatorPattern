package Autocar;

public class DistLane extends Thread{
	private DriveMediator med;
	
	public DistLane(DriveMediator mediator) {
		med = mediator;
	}
	
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Distance/Lane controller at Work.");
		
		for(int i = 0; i<5; i++) {
			
		}
	}

}
