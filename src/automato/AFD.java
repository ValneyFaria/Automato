package automato;

import java.util.ArrayList;
import java.util.HashMap;

public class AFD {

	public void Verifica(String palavra) {

		Leitura anaLe = new Leitura("entrada.txt");

		// Esse valor armazena o numero de Nos do Automato
		int nNos = anaLe.getNumDeEstados();

		// Esse valor armazena o numero de transicoes
		int nTransicoes = anaLe.getNumDeTransicoes();

		// Vetor que armazena todos os Nos
		No[] vetorNos = new No[nNos];

		// No Inicial
		No noInicial = new No();

		// Simbolo do alfabeto
		String chave = null;

		// Colocar os nos num vetor e num for, verificar
		// qual deles � o estado inicial e quais sao estados finais
		for (int i = 0; i < vetorNos.length; i++) {
			vetorNos[i] = new No();
			vetorNos[i].setEstadoInicial(0);
			vetorNos[i].setEstadoFinal(0);
			vetorNos[i].setNome(anaLe.getEstados().get(i));
			vetorNos[i].hMap = new HashMap<String, No>();
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

		// Se a transicao do no inicial for a, vai para o no1
		// Transicao (q0, a, q1)

		// LEITURA DO ARQUIVO
		// Esse vetor recebera os valores lidos do arquivo para
		// preencher o vetor armazenado na memoria
		// [nome_do_no][letra]
		String[][] trans = new String[anaLe.getNumDeTransicoes()][3];

		String s[] = new String[3];

		for (int i = 0; i < anaLe.getNumDeTransicoes(); i++) {
			s = anaLe.getTransicoes().get(i).split(",");
			for (int j = 0; j < 3; j++) {
				trans[i][j] = s[j];
			}
		}

		System.out.println("\nTRANSICOES");
		// Dentre as transicoes lidas do arquivo
		for (int i = 0; i < nTransicoes; i++) {
			// Busca da Chave que se refere ao estado de saida

			// Atribui o texto da primeira posicao para a busca
			String busca = trans[i][0];
			int aux = 0;

			for (int j = 0; j < vetorNos.length; j++) {
				if (vetorNos[j].getNome().equals(busca)) {
					aux = j;
					break;
				}
			}

			// Busca da Chave que se refere ao estado alvo

			// Atribui o texto da segunda posicao para a busca
			busca = trans[i][2];

			int aux2 = 0;
			for (int j = 0; j < vetorNos.length; j++) {
				if (vetorNos[j].getNome().equals(busca)) {
					aux2 = j;
					break;
				}
			}
			chave = trans[i][1];
			vetorNos[aux].hMap.put(chave, vetorNos[aux2]);
		}

		// Exibe as chaves armazenadas em cada Hash de cada NO do vetorNos
		for (int i = 0; i < vetorNos.length; i++) {
			for (String key : vetorNos[i].hMap.keySet()) {

				// Capturamos o valor a partir da chave
				No value = vetorNos[i].hMap.get(key);
				System.out.println(vetorNos[i].getNome() + "," + key + "," + value.getNome());
			}
		}

		boolean aux = false;

		aux = VerificaPalavra(palavra, vetorNos, anaLe.getSimbolos(), noInicial);

		if (aux) {
			System.out.printf("\nA palavra '%s' é aceita pelo automato!\n", palavra);
		} else {
			System.out.printf("\nA palavra '%s' não é aceita pelo automato!\n", palavra);
		}
	}

	public void imprimeVNos(No[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			System.out.println(vetor[i].getNome());
		}
	}

	public void imprimeNo(No no) {
		System.out.println(no.getNome());
	}

	public void ImprimeHashNo(No n) {
		for (String key : n.hMap.keySet()) {

			// Capturamos o valor a partir da chave
			No value = n.hMap.get(key);
			System.out.println(n.getNome() + "->" + value.getNome() + "," + key);
		}
	}

	// Verifica se existe uma transição com um determinado simbolo
	public boolean HasTransWithSymbol(No noAtual, String simbolo) {
		for (int i = 0; i < noAtual.hMap.size(); i++) {
			if (noAtual.hMap.containsKey(simbolo)) {
				No value = noAtual.hMap.get(simbolo);
				if (value.getNome().equals(noAtual.hMap.values())) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean VerificaPalavra(String palavra, No[] vetorNos, ArrayList<String> alfabeto, No noInicial) {
		boolean flag = true;
		No noAtual;

		noAtual = noInicial;

		char[] vetPalavra = new char[palavra.length()];

		vetPalavra = palavra.toCharArray();

		// Verificacao por Simbolos Invalidos
		System.out.println("\nVALIDANDO CARACTERES DA PALAVRA INSERIDA");
		for (int i = 0; i < palavra.length(); i++) {
			// Verifica se todos os caracteres da palavra estao contidos no
			// alfabeto
			if (alfabeto.contains(Character.toString(vetPalavra[i])) || palavra.equals("$")) {
				System.out.println("Caracter Válido: " + vetPalavra[i]);
				continue;
			}
			// Se algum caractere estranho for encontrado, a verificacao �
			// terminada
			else {
				System.out.println("Caracter INVÁLIDO: " + vetPalavra[i]);
				System.out.printf("\nO simbolo %s não pertence ao alfabeto!\n", vetPalavra[i]);
				flag = false;
				return flag;
			}
		}
		System.out.println("VALIDACAO DE CARACTERES CONCLUÍDA!");

		// Verificacao de Palavra Vazia
		System.out.println("\nVERIFICANDO PALAVRA VAZIA");
		if (palavra.equals("$") && noInicial.getEstadoFinal() == 1) {
			System.out.println("Palavra Vazia!");
			flag = true;
			return flag;
		} else if (palavra.equals("$") && noInicial.getEstadoFinal() == 0) {
			System.out.println("Palavra Vazia!");
			flag = false;
			return flag;
		}
		System.out.println("NÃO É PALAVRA VAZIA!");

		// Verificacao de Palavra com 1 Simbolo
		if (palavra.length() == 1 && noAtual.getEstadoFinal() == 1 && HasTransWithSymbol(noAtual, palavra)) {
			System.out.println("\nPalavra Valida de um simbolo!");
			flag = true;
			return flag;
		} else if (palavra.length() == 1 && alfabeto.contains(palavra) != true) {
			System.out.println("\nPalavra Invalida de um simbolo!");
			flag = false;
			return flag;
		}

		// Verificacao de Palavras
		System.out.println("\nINICIANDO VERIFICAÇÃO DE PALAVRA");

		for (int i = 0; i < vetPalavra.length; i++) {
			String pal = Character.toString(vetPalavra[i]);
			System.out.println("\n::ANALISANDO SIMBOLO: " + pal);

			// Verifica a existencia do simbolo no hash do estado atual
			if (noAtual.hMap.containsKey(pal)) {
				// No atual recebe o no destino
				System.out.println(i + " NO ATUAL: " + noAtual.getNome());
				noAtual = noAtual.hMap.get(pal);
				System.out.println(i + " NO DESTINO: " + noAtual.getNome());
			} else {
				System.out.println("Palavra Rejeitada!");
				flag = false;
				return flag;
			}

			// Se a palavra foi toda percorrida e o estado atual é final,
			// aceite
			if (i == (vetPalavra.length - 1) && noAtual.getEstadoFinal() == 1) {
				System.out.println("Palavra Percorrida e estado atual é final!");
				flag = true;
				return flag;
			}
			// Se a palavra foi toda percorrida e o estado atual não é final,
			// rejeite
			else if (i == (vetPalavra.length - 1) && noAtual.getEstadoFinal() == 0) {
				System.out.println("Palavra Percorrida e estado atual não é final!");
				flag = false;
				return flag;
			}
		}

		return flag;
	}
}