package sensorRequests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;
import java.util.Random;
import java.util.TimerTask;

import org.json.JSONObject;

public class PostRequest {


	public static void call_me(int floorNo,int roomNo) throws Exception {
		 

		Random rand = new Random(); 
		int smoke1 = rand.nextInt(10); 
        int co21 = rand.nextInt(10);
		
		
		
	    URL url = new URL("http://localhost:8080/update");
	    Map<String,Object> params = new LinkedHashMap<>();
	    params.put("floorNo", floorNo);
	    params.put("roomNo", roomNo);
	    params.put("smoke", smoke1);
	    params.put("CO2", co21);
	    
	    
	    StringBuilder postData = new StringBuilder();
	    for (Map.Entry<String,Object> params1 : params.entrySet()) {
	        if (postData.length() != 0) postData.append('&');
	        postData.append(URLEncoder.encode(params1.getKey(), "UTF-8"));
	        postData.append('=');
	        postData.append(URLEncoder.encode(String.valueOf(params1.getValue()), "UTF-8"));
	    }
	    byte[] postDataBytes = postData.toString().getBytes("UTF-8");
	    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	    conn.setRequestMethod("POST");
	    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	    conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
	    conn.setDoOutput(true);
	    conn.getOutputStream().write(postDataBytes);
	    Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	    StringBuilder sb = new StringBuilder();
	    for (int c; (c = in.read()) >= 0;)
	        sb.append((char)c);
	    String response = sb.toString();
	    System.out.println(response);
	   

	   
	}
	
}
