package Autocar;

public class BlackBox {
	public int redLight;
	public int animal;
	public int pedestrian;
	public int lane;
	public int distance;
	public int aircon;
	public int heater;
	
	public void setInit() {
		redLight = 0;
		animal = 0;
		pedestrian = 0;
		lane = 0;
		distance = 0;
		aircon = 0;
		heater = 0;
	}
	
	public void printBlackBoxData() {
		System.out.println("=== Black Box Data ===");
		System.out.println("Speed Control Terminating.");
		System.out.println("Number of Animals Sensed : " + animal);
		System.out.println("Number of Pedestrian Sensed : " + pedestrian);
		System.out.println("Number of Red Traffic Light Sensed : " + redLight);
		System.out.println("Number of Distance Control : " + distance);
		System.out.println("Number of Lane Control : " + lane);
		System.out.println("Number of Heater Turned On : " + heater);
		System.out.println("Number of Aircon Turned On : " + aircon);
		System.out.println("=== Black Box in Sleep Mode ===");
	}
}
