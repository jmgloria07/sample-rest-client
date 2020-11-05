package coffee.pudding.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpGetCall {
	
	public static void main(String[] args) throws IOException {
		//create a URL object
		URL url = new URL("https://gracenote-1602933751897.azurewebsites.net/users/10001/graces");
		
		//open connection
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		
		//print status
		System.out.println("Status code: " + conn.getResponseCode());
		
		//get response
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
		
		//print output
		System.out.println("Output:");
		String output;
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();
	}
}
