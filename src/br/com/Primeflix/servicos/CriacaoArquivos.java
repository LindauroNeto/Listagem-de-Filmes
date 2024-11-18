package br.com.Primeflix.servicos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.Primeflix.modelos.Filme;

public class CriacaoArquivos {

	public static void versaoJson(String nomeArquivo, List<Filme> listaFilmes) throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		FileWriter docEscrito = new FileWriter(nomeArquivo + ".json");
		docEscrito.write(gson.toJson(listaFilmes));
		docEscrito.close();
	}
}
