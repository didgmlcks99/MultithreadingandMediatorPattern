package Autocar;

public class DriveMediator {
	public int event;
	public int speed;
	public int brake;
	public int temp;
	public boolean eventFull = false;
	
	public DriveMediator() {
	}
	
	public synchronized int detectEvent() {
//		while(!eventFull) {
//			try {
//				wait();
//			}catch(InterruptedException e) {}
//		}
		
		return event;
	}

	public void setEvent(int event) {
		this.event = event;
	}
}
