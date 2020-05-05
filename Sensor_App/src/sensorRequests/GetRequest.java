package sensorRequests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.TimerTask;

import org.json.JSONObject;

public class GetRequest extends TimerTask{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			GetRequest.call_me();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void call_me() throws Exception{
		
		URL urlForGetRequest = new URL("http://localhost:8080/getAll");
	    String readLine = null;
	    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
	    conection.setRequestMethod("GET");
	    conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample here
	    int responseCode = conection.getResponseCode();
	    if (responseCode == HttpURLConnection.HTTP_OK) {
	        BufferedReader in = new BufferedReader(
	            new InputStreamReader(conection.getInputStream()));
	        StringBuffer response = new StringBuffer();
	        String output = null;
	        while ((readLine = in.readLine()) != null) {
	        	
	        JSONObject myResponse = new JSONObject(readLine.toString());
	   	     
	   	     int floorNo = myResponse.getInt("floorNo");
	   	     int roomNo = myResponse.getInt("roomNo");
	   	  System.out.println("");
	   	     
	   	     PostRequest postRequest = new PostRequest();
	   	     
	   	     postRequest.call_me(floorNo, roomNo);
	   	     
	            response.append(readLine);
	        } in .close();
	        
	     //print in String
	     System.out.println(response.toString());
	     //Read JSON response and print
	     
	    
	   }
}


}