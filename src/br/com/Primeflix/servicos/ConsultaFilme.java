package br.com.Primeflix.servicos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.Primeflix.modelos.FilmeOmdb;

public class ConsultaFilme {

	public FilmeOmdb buscaDeFilme(String nomeFilme) throws IOException, InterruptedException {
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("http://www.omdbapi.com/?t="+ nomeFilme + "&apikey=" + System.getenv("API_KEY_OMDB")))
				.build();
		
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		return gson.fromJson(response.body(), FilmeOmdb.class);
	}
}
