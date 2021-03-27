package Autocar;

public class TempControl extends Thread{
	private DriveMediator med;
	
	public TempControl(DriveMediator mediator) {
		med = mediator;
	}
	
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Air Conditioner at Work.");
		
		for(int i = 0; i<5; i++) {
			
		}
	}

}
