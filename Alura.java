package alura;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Alura {
	
	public static void main(String[] args) throws IOException, InterruptedException {
			
		// pegar os dados da http
		
		String url = "https://api.mocki.io/v2/549a5d8b";
		URI endereco = URI.create(url);
		HttpClient client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		
		
		
		// Pegar dados ( titulo, poster....)
		var parser = new Jsonparser();
		List<Map<String, String>> ListaDeFilmes = parser.parse(body);
		
		//exibir e manipular os dados
		
		for (Map<String,String> filme : ListaDeFilmes) {
			System.out.println(filme.get("title"));
		}
		
		
	}

}
