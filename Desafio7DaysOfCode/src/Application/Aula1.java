package Application;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Aula1 {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

		
		String key = "k_r240ona8";
		
		
		
		
		HttpRequest request = HttpRequest
	            .newBuilder()
	            .uri(new URI("https://imdb-api.com/en/API/Top250Movies/"+key ))
	            .GET()
	            .build();
		
		HttpClient client =  HttpClient.newBuilder().build();
		
		HttpResponse<String> response =
			      client.send(request, BodyHandlers.ofString());
			System.out.println(response.statusCode());
			System.out.println(response.body());
		
	}

}
