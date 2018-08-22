package automato;

import java.util.ArrayList;
import java.util.LinkedList;

public class AFN {

	public void Verifica(String palavra) {
		// Realiza a Leitura do Arquivo de Entrada
		Leitura anaLe = new Leitura("entradaN.txt");

		// Esse valor armazena o numero de Nos
		int nNos = anaLe.getNumDeEstados();

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

		boolean aux = false;

		aux = VerificaPalavra(palavra, vetorNos, anaLe.getSimbolos(), noInicial);

		if (aux) {
			System.out.printf("A palavra '%s' é aceita pelo automato!\n", palavra);
		} else {
			System.out.printf("A palavra '%s' não é aceita pelo automato!\n", palavra);
		}
	}

	private boolean VerificaPalavra(String palavra, NoN[] vetorNos, ArrayList<String> alfabeto, NoN noInicial) {
		// Listas que armazenarão os Nós Temporariamente
		LinkedList<NoN> A = new LinkedList<NoN>();
		LinkedList<NoN> B = new LinkedList<NoN>();

		boolean flag = true;

		char[] vetPalavra = new char[palavra.length()];

		vetPalavra = palavra.toCharArray();
		System.out.println(vetPalavra);

		// Verificacao por Simbolos Invalidos
		for (int i = 0; i < palavra.length(); i++) {
			// Verifica se todos os símbolos estao contidos no alfabeto
			if (alfabeto.contains(Character.toString(vetPalavra[i])) || palavra.equals("$")) {
				System.out.println("Caracter Valido: " + vetPalavra[i]);
				continue;
			}
			// Se algum caractere estranho for encontrado, a verificacao é
			// terminada e a palavra não é aceita
			else {
				System.out.println("Caracter INVALIDO: " + vetPalavra[i]);
				System.out.printf("\nO simbolo %s não pertence ao alfabeto!\n", vetPalavra[i]);
				flag = false;
				return flag;
			}
		}

		// Verificacao de Palavra Vazia
		if (palavra.equals("$") && noInicial.getEstadoFinal() == 1) {
			System.out.println("Palavra Vazia!");
			flag = true;
			return flag;
		} else if (palavra.equals("$") && noInicial.getEstadoFinal() == 0) {
			System.out.println("Palavra Vazia!");
			flag = false;
			return flag;
		}

		// Verificacao de Palavra com 1 Simbolo

		// Se o estado inicial é final, o tamanho da palavra é 1 e o No tem um
		// transição com o simbolo
		if (palavra.length() == 1 && noInicial.getEstadoFinal() == 1 && HasTransWithSymbol(noInicial, palavra)) {
			System.out.println("\nPalavra Valida de um simbolo!");
			flag = true;
			// Aceitar
			return flag;
			// Senao, se o símbolo não estiver no alfabeto e
		} else if (palavra.length() == 1 && alfabeto.contains(palavra) != true) {
			System.out.println("\nPalavra Invalida de um simbolo!");
			flag = false;
			return flag;
		}

		return false;
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

	// Verifica se existe uma transição com um determinado simbolo
	public boolean HasTransWithSymbol(NoN no, String simbolo) {
		for (int i = 0; i < no.getLTrans().size(); i++) {
			if (no.getLTrans().get(i).getSimbolo().equals(simbolo)) {
				return true;
			}
		}

		return false;

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