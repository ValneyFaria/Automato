package automato;

import java.util.HashMap;

public class No{
	HashMap<String, No> hMap = new HashMap<String, No>();
	private int estadoInicial;
	private int estadoFinal;
	private String nome;

	public void setEstadoInicial(int estadoInicial) {
		this.estadoInicial = estadoInicial;
	}

	public int getEstadoInicial() {
		return this.estadoInicial;
		
	}

	public void setEstadoFinal(int estadoFinal) {
		this.estadoFinal = estadoFinal;
	}

	public int getEstadoFinal() {
		return this.estadoFinal;
	}
	
	public String getNome() {
		return this.nome;	
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}