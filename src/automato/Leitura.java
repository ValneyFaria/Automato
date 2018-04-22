
package automato;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class Leitura {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("teste.txt")); //utiliza-se para ler o arquivo desejado
		HashMap<String,String> hash = new HashMap<>(); //utiliza uma hash de string para string
		 
		 String linha;
		 String instrucoes[] = new String[2]; //o que queremos esta no indice [2]
		 try {
			 while(br.ready()) {
				 linha = br.readLine();
				 instrucoes = linha.split(" - "); //split eh a funcao utilizada para quebra
				 hash.put(instrucoes[1], instrucoes[0]);
				 
			 }
			 
		 }catch(IOException e) {
		
		 }catch(StringIndexOutOfBoundsException o) {
			 
		 }
		 Set<String> chaves = hash.keySet(); 
		 for(String chave : chaves) { //percorre um vetor de chaves
			 if(chave != null) {
				 System.out.println(chave + hash.get(chave)); //imprime a hash com o que eh necessario do arquivo
			 }
		 }
		 
		 br.close();
	}
}
		
		
		
		
	
