package sensorRequests;

import java.util.Timer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Timer timer1 = new Timer();
		timer1.schedule(new GetRequest(), 0, 30000);
	}

}
