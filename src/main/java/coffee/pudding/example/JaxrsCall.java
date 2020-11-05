package coffee.pudding.example;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class JaxrsCall {
	
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://gracenote-1602933751897.azurewebsites.net:443/openings/50001");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		
		System.out.println("response status: " + response.getStatus());
		System.out.println(response);
		
		Opening opening = response.readEntity(Opening.class);
		System.out.println(opening.getId());
		System.out.println(opening.getDisplayText());
	}
}
