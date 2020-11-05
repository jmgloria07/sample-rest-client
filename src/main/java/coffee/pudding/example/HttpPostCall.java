package coffee.pudding.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpPostCall {

	public static void main(String[] args) throws IOException {

		//create a URL object
		URL url = new URL("https://gracenote-1602933751897.azurewebsites.net/users/10001/graces");
		
		//open connection
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");

		//set parameters, json string
		String postParams 
			= "{\"opening\": 50004, \"displayText\": \"I can create a POST via HttpsURLConnection\"}";
		
		OutputStream outputStream = conn.getOutputStream();
		outputStream.write(postParams.getBytes());
		outputStream.flush();
		
		System.out.println("Status: " + conn.getResponseCode());

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		
		String output;
		System.out.println("Output from Server .... \n");
		while ((output = bufferedReader.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();
	}

}
