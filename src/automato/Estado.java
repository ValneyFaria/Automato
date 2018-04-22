package automato;

import java.util.ArrayList;

public class Estado {
	private String nome;
	private ArrayList < Estado > destinos = new ArrayList<>();
	
	private ArrayList < String > transicoes = new ArrayList<>();
	
	public Estado(String s) {
		setNome(s);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Estado> getDestinos() {
		return destinos;
	}

	public void setDestinos(ArrayList<Estado> destinos) {
		this.destinos = destinos;
	}

	public ArrayList<String> getTransicoes() {
		return transicoes;
	}

	public void setTransicoes(ArrayList<String> transicoes) {
		this.transicoes = transicoes;
	}

}
