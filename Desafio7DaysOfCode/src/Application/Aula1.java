package Application;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Aula1 {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		// 7 - nota 4- ano
		String[] moviesArray = parseJsonMovies(recebeJson());

		
		ArrayList<Filme> listaFilmes = new ArrayList<>();
		
		
		List<String> titles = parseTitles(moviesArray);
		
		
			
			//listaFilmes.forEach(System.out::println);
			
//		//titles.forEach(System.out::println);
//
		List<String> urlImages = parseUrlImages(moviesArray);
//		//urlImages.forEach(System.out::println);
//		
		List<String> nota = parseNota(moviesArray);
//		nota.forEach(System.out::println);
//		
		List<String> ano = parseAno(moviesArray);
//		ano.forEach(System.out::println);

		
		for (int i= 0 ; i< titles.size();i++) {
			Filme aux = new Filme();
			aux.setTitulo(titles.get(i));
			aux.setAno(ano.get(i));
			aux.setTitulo(titles.get(i));
			aux.setNota(nota.get(i));
			aux.setUrlIamgem(urlImages.get(i));
			listaFilmes.add(aux);
		}
		
	
		listaFilmes.forEach(System.out::println);
	}

	private static String recebeJson() throws URISyntaxException, IOException, InterruptedException {

		String key = "k_r240ona8";

		HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://imdb-api.com/en/API/Top250Movies/" + key))
				.GET().build();

		HttpClient client = HttpClient.newBuilder().build();

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

		return response.body();
	}

	private static String[] parseJsonMovies(String json) {
		Matcher matcher = Pattern.compile(".*\\[(.*)\\].*").matcher(json);

		if (!matcher.matches()) {
			throw new IllegalArgumentException("no match in " + json);
		}

		String[] moviesArray = matcher.group(1).split("\\},\\{");
		moviesArray[0] = moviesArray[0].substring(1);
		int last = moviesArray.length - 1;
		String lastString = moviesArray[last];
		moviesArray[last] = lastString.substring(0, lastString.length() - 1);
		return moviesArray;
	}

	private static List<String> parseTitles(String[] moviesArray) {
		return parseAttribute(moviesArray, 3);
	}

	private static List<String> parseUrlImages(String[] moviesArray) {
		return parseAttribute(moviesArray, 5);
	}
	
	private static List<String> parseAno(String[] moviesArray) {
		return parseAttribute(moviesArray, 4);
	}

	private static List<String> parseNota(String[] moviesArray) {
		return parseAttribute(moviesArray, 7);
	}

	private static List<String> parseAttribute(String[] moviesArray, int pos) {
		return Stream.of(moviesArray).map(e -> e.split("\",\"")[pos]).map(e -> e.split(":\"")[1])
				.map(e -> e.replaceAll("\"", "")).collect(Collectors.toList());
	}
}
