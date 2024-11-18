package br.com.Primeflix.modelos;

import br.com.Primeflix.excecoes.ErroDeConversaoDeAnoException;

public class Filme {
	private String nome;
	private int anoDeLancamento;
	private int tempoDeDuracao;
	private String genero;
	private String diretor;
	private String sinopse;
	
	public Filme(FilmeOmdb filmeOmdb) {
		this.nome = filmeOmdb.title();
		if (filmeOmdb.year().length() > 4) {
			throw new ErroDeConversaoDeAnoException("Nao foi possivel converter o numero por ter mais de 04 caracteres.");
		}
		
		this.anoDeLancamento = Integer.parseInt(filmeOmdb.year());
		this.tempoDeDuracao = Integer.parseInt(filmeOmdb.runtime().replace(" min", ""));
		this.genero = filmeOmdb.genre();
		this.diretor = filmeOmdb.director();
		this.sinopse = filmeOmdb.plot();
	}

	
	public String getNome() {
		return nome;
	}

	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public int getTempoDeDuracao() {
		return tempoDeDuracao;
	}

	public String getGenero() {
		return genero;
	}

	public String getDiretor() {
		return diretor;
	}

	public String getSinopse() {
		return sinopse;
	}


	@Override
	public String toString() {
		return "[Nome do filme: " + getNome() + ", Ano de lançamento: " + getAnoDeLancamento() + ", Diretor: " + getDiretor() + "]";
	}
	
}
