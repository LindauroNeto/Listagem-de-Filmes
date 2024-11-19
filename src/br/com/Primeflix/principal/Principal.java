package br.com.Primeflix.principal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.Primeflix.excecoes.ErroDeConversaoDeAnoException;
import br.com.Primeflix.modelos.Filme;
import br.com.Primeflix.servicos.ConsultaFilme;
import br.com.Primeflix.servicos.CriacaoArquivos;

public class Principal {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException, InterruptedException {
		String nomeDoFilme = "";
		List<Filme> listaFilmesFavoritos = new ArrayList<>();
		
		System.out.println("Crie sua lista de filmes favoritos!");
		
		while (!nomeDoFilme.equalsIgnoreCase("sair")) {
			
			System.out.println("Digite o nome do filme a colocar na lista: (digite \"sair\" para terminar)");
			nomeDoFilme = scanner.nextLine().toLowerCase().replace(" ", "+");
			if (nomeDoFilme.equalsIgnoreCase("sair")) {
				break;
			}
			
			ConsultaFilme consultaFilme = new ConsultaFilme();
			try {
				Filme filme = new Filme(consultaFilme.buscaDeFilme(nomeDoFilme));
				System.out.println(filme.toString() + "\n");
				listaFilmesFavoritos.add(filme);
			} catch (NumberFormatException | ErroDeConversaoDeAnoException e) {
				System.err.println("\nAconteceu um erro: " + e.getMessage());
			}
		}
		System.out.println("\nEscolha um nome para sua lista!");
		String nomeArquivo = scanner.nextLine();
		CriacaoArquivos.versaoJson(nomeArquivo, listaFilmesFavoritos);
		// Versao txt
//		CriacaoArquivos.versaoTxt(nomeArquivo, listaFilmesFavoritos);

	}

}
