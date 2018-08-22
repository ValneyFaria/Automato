package automato;

import java.util.ArrayList;

public class NoN {
	private String nome;
	private int estadoFinal;
	private int estadoInicial;
	// Lista de Transições do No
	private ArrayList<Transition> LTrans = new ArrayList<Transition>();

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

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

	public ArrayList<Transition> getLTrans() {
		return LTrans;
	}

	public void setLTrans(ArrayList<Transition> lTrans) {
		LTrans = lTrans;
	}
}