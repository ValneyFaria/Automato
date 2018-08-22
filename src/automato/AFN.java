package automato;

import java.util.ArrayList;
import java.util.HashMap;

public class AFN {

	public void Verifica(String palavra) {
		// Realiza a Leitura do Arquivo de Entrada
		Leitura anaLe = new Leitura("entradaN.txt");

		// Esse valor armazena o numero de Nos
		int nNos = anaLe.getNumDeEstados();

		// Esse valor armazena o numero de transicoes
		int nTransicoes = anaLe.getNumDeTransicoes();

		// Vetor que armazena todos os Nos
		NoN[] vetorNos = new NoN[nNos];

		// No Inicial
		NoN noInicial = new NoN();

		// Lista de Vetor que armazena os simbolos do alfabeto
		System.out.println("Alfabeto:" + anaLe.getSimbolos());

		// Simbolo do alfabeto
		String chave = null;

		// Seta todos os estados como não-finais e não-iniciais
		for (int i = 0; i < vetorNos.length; i++) {
			vetorNos[i] = new NoN();
			vetorNos[i].setEstadoInicial(0);
			vetorNos[i].setEstadoFinal(0);
			vetorNos[i].setNome(anaLe.getEstados().get(i));
			System.out.println("No na pos " + i + ": " + vetorNos[i].getNome());
		}

		// Define o estado inicial
		for (int i = 0; i < vetorNos.length; i++) {
			if (vetorNos[i].getNome().equals(anaLe.getEstadoInicial())) {
				vetorNos[i].setEstadoInicial(1);
				noInicial = vetorNos[i];
			}
		}

		// Define os estados finais
		for (int i = 0; i < vetorNos.length; i++) {
			for (int j = 0; j < anaLe.getNumDeEstadosFinais(); j++) {
				if (vetorNos[i].getNome().equals(anaLe.getEstadosFinais().get(j))) {
					vetorNos[i].setEstadoFinal(1);
				}
			}
		}

		// Definir as transicoes para cada No
		String[][] trans = new String[anaLe.getNumDeTransicoes()][3];

		String s[] = new String[3];

		for (int i = 0; i < anaLe.getNumDeTransicoes(); i++) {
			s = anaLe.getTransicoes().get(i).split(",");
			for (int j = 0; j < 3; j++) {
				trans[i][j] = s[j];
				System.out.printf("I: %d J: %d\n", i, j);
				System.out.println("Trans: " + trans[i][j]);
			}

			int NoPosition = BuscaPosByName(vetorNos, trans[i][0]);

			// Cria uma transição
			Transition t = new Transition();
			t.setSimbolo(trans[i][1]);
			t.setEstadoOrigem(trans[i][0]);
			t.setEstadoDestino(trans[i][2]);

			// Adiciona a Transicao ao No
			vetorNos[NoPosition].getLTrans().add(t);
		}

		// Exibir a lista de transições de todos os Nos
		for (int i = 0; i < vetorNos.length; i++) {
			ShowTransList(vetorNos[i]);
		}

		System.out.println("Nos:");
		for (int i = 0; i < vetorNos.length; i++) {
			System.out.println(vetorNos[i].getEstadoFinal());
		}
	}

	// Busca a Posicao de um nome num dado vetor
	public int BuscaPosByName(NoN vetor[], String nome) {
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i].getNome().equals(nome)) {
				return i;
			}
		}

		return 0;
	}

	// Exibe a Lista de Transições do Nó
	public void ShowTransList(NoN no) {

		System.out.println("Lista de Transições do No " + no.getNome() + ":");
		if (no.getLTrans().size() == 0) {
			System.out.println("Lista Vazia!\n");
			return;
		}

		for (int i = 0; i < no.getLTrans().size(); i++) {
			System.out.print(i + ": " + no.getLTrans().get(i).getEstadoOrigem() + ",");
			System.out.print(no.getLTrans().get(i).getSimbolo() + ",");
			System.out.println(no.getLTrans().get(i).getEstadoDestino());
		}
		System.out.println("");
	}

	// Verifica se algum dos estados duma lista é final
	public boolean HasFinalState(ArrayList<NoN> Lista) {
		for (int i = 0; i < Lista.size(); i++) {
			// Se algum No na Lista é estado Final
			if (Lista.get(i).getEstadoFinal() == 1) {
				// Retornar Verdadeiro
				return true;
			}
		}
		// Senao, retornar Falso
		return false;

	}
}