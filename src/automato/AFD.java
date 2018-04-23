package automato;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import javax.print.attribute.standard.Chromaticity;

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

	@SuppressWarnings({ "unused", "resource" })
	private static String pesquisar(){
		Scanner entrada = new Scanner(System.in); 
		System.out.println("Informe a key");
		Integer key = entrada.nextInt();
		return null;
		
	}
	
	

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Esse valor armazena o numero de Nos
		int nNos = 2;
		
		// Esse valor armazena o numero de transicoes
		int nTransicoes = 4;
		
		// Vetor que armazena todos os Nos
		No[] vetorNos = new No[nNos]; 

		// No Inicial
		No noInicial = new No();
		// No Atual
		No noAtual = new No();

		// Lista Encadeada que armazena os simbolos do alfabeto
		LinkedList<String> alfabeto = new LinkedList<>();
		
		alfabeto.add("a");
		alfabeto.add("b");
		
		System.out.println("Alfabeto:" + alfabeto);
		
		// Simbolo do alfabeto
		String chave = null;
		
		// Colocar os nos num vetor e num for, verificar
		// qual deles eh o estado inicial e quais sao estados finais
		for (int i = 0; i < vetorNos.length; i++) {
			vetorNos[i] = new No();
			vetorNos[i].setEstadoInicial(0);
			vetorNos[i].setEstadoFinal(0);
			vetorNos[i].setNome("q" + i);
			vetorNos[i].hMap = new HashMap<String, No>();
			System.out.println("Nome do No na pos " + i + ": " + vetorNos[i].getNome());
		}
		
		System.out.println("Nos:");
		imprimeVNos(vetorNos);
		
		System.out.println("tam do vetor: " + vetorNos.length);
		
		vetorNos[0].setEstadoInicial(1); // q0 eh estado inicial
		vetorNos[vetorNos.length - 1].setEstadoFinal(1); // q1 eh estado final
		
		System.out.println("No Inicial " + vetorNos[0].getNome() + " : " + vetorNos[0].getEstadoInicial());
		System.out.println("No Final " + vetorNos[vetorNos.length - 1].getNome() + " : " + vetorNos[vetorNos.length - 1].getEstadoFinal());
		
		noInicial = vetorNos[0];
		
		// Se a transicao do no inicial for a, vai para o no1
		// Transicao (q0, a, q1)
		
		// LEITURA DO ARQUIVO
		// Esse vetor recebera os valores lidos do arquivo para
		// preencher o vetor armazenado na memoria
		// [nome_do_no][letra]
		String[][] trans = new String[nTransicoes][3];
		
		trans[0][0] = "q0";
		trans[0][1] = "b";
		trans[0][2] = "q0";

		trans[1][0] = "q0";
		trans[1][1] = "a";
		trans[1][2] = "q1";
		
		trans[2][0] = "q1";
		trans[2][1] = "a";
		trans[2][2] = "q1";

		trans[3][0] = "q1";
		trans[3][1] = "b";
		trans[3][2] = "q1";
		
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
		System.out.println("as");
		ImprimeHashNo(vetorNos[1]);

		String palavra = "abba";
		
		boolean aux = false;
		
		aux = VerificaPalavra(palavra, vetorNos, alfabeto, noInicial);
		
		if(aux) {
			System.out.println("A palavra " + palavra + " eh aceita pelo automato!");
		}
		else {
			System.out.println("A palavra " + palavra + " nao eh aceita pelo automato!");
		}
	}

	public static boolean VerificaPalavra(String palavra, No[] vetorNos, LinkedList<String> alfabeto, No noInicial) {
		boolean flag = true;
		No noAtual;
		
		char[] vetPalavra = new char[palavra.length()];
		
		vetPalavra = palavra.toCharArray();
		System.out.println(vetPalavra);
		
		// Verificacao por Simbolos Invalidos
		for (int i = 0; i < palavra.length(); i++) {
			// Verifica se todos os caracteres da palavra estao contidos no alfabeto				
			if (alfabeto.contains(Character.toString(vetPalavra[i])) || palavra.equals("$")) {
				System.out.println("Entrou");
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
		if (palavra == "$" && noInicial.getEstadoFinal() == 1) {
			System.out.println("Palavra Vazia!");
			flag = true;
			return flag;
		}
		else if(noInicial.getEstadoFinal() == 0) {
			System.out.println("Palavra Vazia!");
			flag = false;
			return flag;
		}
		
		// Verificacao de Palavra com 1 Simbolo
		if (palavra.length() == 1 && alfabeto.contains(palavra)) {
			flag = true;
			return flag;
		}
		else if (palavra.length() == 1 && alfabeto.contains(palavra) != true){
			flag = false;
			return flag;
		}
		
//		// Verificacao de Palavras
//		noAtual = noInicial;
//		for (int i = 0; i < vetPalavra.length; i++) {
//			String pal = Character.toString(vetPalavra[i]);
//			
//			System.out.println(noAtual.getNome());
//			System.out.println(noAtual.hMap.keySet());
//		}
		
		return flag;
	}
}
