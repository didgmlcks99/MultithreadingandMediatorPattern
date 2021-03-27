package Autocar;

public class Brake extends Thread{
	private DriveMediator med;
	
	public Brake(DriveMediator mediator) {
		med = mediator;
	}
	
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Brake Control at Work.");
		
		for(int i = 0; i<5; i++) {
			
		}
	}
	
}
