package automato;

import java.util.ArrayList;
import java.util.HashMap;

public class AFD {
	
	public static void imprimeVNos(No[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			System.out.println(vetor[i].getNome());
		}
	}
	
	public static void imprimeNo(No no) {
		System.out.println(no.getNome());
	}

	public static void ImprimeHashNo(No n) {
		for (String key : n.hMap.keySet()) {
            
            //Capturamos o valor a partir da chave
            No value = n.hMap.get(key);
            System.out.println(n.getNome() + "->" + value.getNome() + "," + key);
		}
	}

	public static void main(String[] args) {
		
		String palavra = "baba";
		
		Leitura anaLe = new Leitura();
		
		// Esse valor armazena o numero de Nos
		int nNos = anaLe.getNumDeEstados();
		
		// Esse valor armazena o numero de transicoes
		int nTransicoes = anaLe.getNumDeTransicoes();
		
		// Vetor que armazena todos os Nos
		No[] vetorNos = new No[nNos];

		// No Inicial
		No noInicial = new No();

		// Lista de Vetor que armazena os simbolos do alfabeto
		System.out.println("Alfabeto:" + anaLe.getSimbolos());
		
		// Simbolo do alfabeto
		String chave = null;
		
		// Colocar os nos num vetor e num for, verificar
		// qual deles eh o estado inicial e quais sao estados finais
		for (int i = 0; i < vetorNos.length; i++) {
			vetorNos[i] = new No();
			vetorNos[i].setEstadoInicial(0);
			vetorNos[i].setEstadoFinal(0);
			vetorNos[i].setNome(anaLe.getEstados().get(i));
			vetorNos[i].hMap = new HashMap<String, No>();
			System.out.println("Nome do No na pos " + i + ": " + vetorNos[i].getNome());
		}
		
		System.out.println("Nos:");
		imprimeVNos(vetorNos);
		
		System.out.println("tam do vetor: " + vetorNos.length);
		
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
		
		System.out.println("No Inicial " + vetorNos[0].getNome() + " : " + vetorNos[0].getEstadoInicial());
		System.out.println("No Final " + vetorNos[vetorNos.length - 1].getNome() + " : " + vetorNos[vetorNos.length - 1].getEstadoFinal());
		
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
		
		System.out.println("\n\nBUSCAS NAS TRANSICOES\n");
		// Dentre as transicoes lidas do arquivo
		for (int i = 0; i < nTransicoes; i++) {
			// Busca da Chave que se refere ao estado de saida

			// Atribui o texto da primeira posicao para a busca
			String busca = trans[i][0];
			System.out.println("Busca: " + busca);
			int aux = 0;
			for (int j = 0; j < vetorNos.length; j++) {
				if (vetorNos[j].getNome().equals(busca)) {
					aux = j;
					break;
				}
			}
			
			imprimeNo(vetorNos[aux]);
			
			
			// Busca da Chave que se refere ao estado alvo

			// Atribui o texto da segunda posicao para a busca
			busca = trans[i][2];
			
			System.out.println("Busca2: " + trans[i][2]);
			
			int aux2 = 0;
			for (int j = 0; j < vetorNos.length; j++) {
				if (vetorNos[j].getNome().equals(busca)) {
					aux2 = j;
					break;
				}
			}
			
			imprimeNo(vetorNos[aux2]);
			
			chave = trans[i][1];
			vetorNos[aux].hMap.put(chave, vetorNos[aux2]);
		}
		
		// Exibe as chaves armazenadas em cada Hash de cada NO do vetorNos
		for (int i = 0; i < vetorNos.length; i++) {
			for (String key : vetorNos[i].hMap.keySet()) {
	            
	            //Capturamos o valor a partir da chave
	            No value = vetorNos[i].hMap.get(key);
	            System.out.println(vetorNos[i].getNome() + "->" + value.getNome() + "," + key);
			}
		}
		ImprimeHashNo(vetorNos[1]);
		
		boolean aux = false;
		
		aux = VerificaPalavra(palavra, vetorNos, anaLe.getSimbolos(), noInicial);
		
		if(aux) {
			System.out.println("A palavra " + palavra + " eh aceita pelo automato!");
		}
		else {
			System.out.println("A palavra " + palavra + " nao eh aceita pelo automato!");
		}
	}

	public static boolean VerificaPalavra(String palavra, No[] vetorNos, ArrayList<String> alfabeto, No noInicial) {
		boolean flag = true;
		No noAtual;
		
		noAtual = noInicial;
		
		char[] vetPalavra = new char[palavra.length()];
		
		vetPalavra = palavra.toCharArray();
		System.out.println(vetPalavra);
		
		// Verificacao por Simbolos Invalidos
		for (int i = 0; i < palavra.length(); i++) {
			// Verifica se todos os caracteres da palavra estao contidos no alfabeto				
			if (alfabeto.contains(Character.toString(vetPalavra[i])) || palavra.equals("$")) {
				System.out.println("Caracter Validado");
				continue;
			}
			// Se algum caractere estranho for encontrado, a verificacao eh terminada
			else{
				System.out.println("Algum simbolo nao foi encontrado no alfabeto!");
				flag = false;
				return flag;
			}
		}
		
		// Verificacao de Palavra Vazia
		if (palavra.equals("$") && noInicial.getEstadoFinal() == 1) {
			System.out.println("Palavra Vazia!");
			flag = true;
			return flag;
		}
		else if(palavra.equals("$") && noInicial.getEstadoFinal() == 0) {
			System.out.println("Palavra Vazia!");
			flag = false;
			return flag;
		}
		
		// Verificacao de Palavra com 1 Simbolo
		if (palavra.length() == 1 && alfabeto.contains(palavra) && noAtual.getEstadoFinal() == 1) {
			System.out.println("Palavra Valida de um simbolo!");
			flag = true;
			return flag;
		}
		else if (palavra.length() == 1 && alfabeto.contains(palavra) != true){
			System.out.println("Palavra Invalida de um simbolo!");
			flag = false;
			return flag;
		}
		
		// Verificacao de Palavras
		for (int i = 0; i < vetPalavra.length; i++) {
			System.out.println("\nVERIFICACAO DE PALAVRAS: " + i);
			String pal = Character.toString(vetPalavra[i]);
			
			System.out.println("SIMBOLO: " + pal);
			
			// Verifica a existencia do simbolo no hash do estado atual
			if (noAtual.hMap.containsKey(pal)) {
				// No atual recebe o no destino
				System.out.println(i + " NO ATUAL: " + noAtual.getNome());
				noAtual = noAtual.hMap.get(pal);
				System.out.println(i + " NO DESTINO: " + noAtual.getNome());
			}
			else{
				System.out.println("Palavra Rejeitada!");
				flag = false;
				return flag;
			}
			
			// Se a palavra foi toda percorrida e o estado atual eh final, aceite
			if (i == (vetPalavra.length - 1) && noAtual.getEstadoFinal() == 1) {
				System.out.println("Palavra Percorrida e estado atual eh final!");
				flag = true;
				return flag;
			}
			// Se a palavra foi toda percorrida e o estado atual nao eh final, rejeite
			else if (i == (vetPalavra.length - 1) && noAtual.getEstadoFinal() == 0) {
				System.out.println("Palavra Percorrida e estado atual nao eh final!");
				flag = false;
				return flag;
			}
		}
		
		return flag;
	}
}
