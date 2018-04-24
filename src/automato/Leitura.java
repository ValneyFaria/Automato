package automato;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Leitura {
	private int numDeSimbolos = 0;
	private ArrayList <String> simbolos = new ArrayList<>();
	private int numDeEstados = 0;
	private ArrayList <String> estados = new ArrayList<String>();
	private int numDeTransicoes = 0;
	private ArrayList <String> transicoes = new ArrayList<>();
	private String estadoInicial = new String();
	private int numDeEstadosFinais = 0;
	private ArrayList <String> estadosFinais = new ArrayList<>();
	
	public Leitura() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("entrada.txt")); //utiliza-se para ler o arquivo desejado
			String linha;
			 
			int i = 0;
			try {
				while(br.ready()) {
					 linha = br.readLine();
					 System.out.println("Linha: " + linha);
					 this.numDeSimbolos = Integer.valueOf(linha);
					 System.out.println("NumSImbolos: " + this.numDeSimbolos);
					 i = 0;
					 while(i < this.numDeSimbolos) {
						 linha = br.readLine();
						 this.simbolos.add(linha);
						 i++;
					 }
					 linha = br.readLine();
					 this.numDeEstados = Integer.valueOf(linha);
					 i = 0;
					 while(i < this.numDeEstados) {
						 linha = br.readLine();
						 this.estados.add(linha);
						 i++;
						 
					 }
					 linha = br.readLine();
					 this.numDeTransicoes = Integer.valueOf(linha);
					 i = 0;
					 while(i < this.numDeTransicoes) {
						 linha = br.readLine();
						 transicoes.add(linha);
						 i++;
						 
					 }
					 linha = br.readLine();
					 estadoInicial = linha;
					 linha = br.readLine();
					 numDeEstadosFinais = Integer.valueOf(linha);
					 i = 0;
					 while(i < numDeEstadosFinais) {
						 linha = br.readLine();
						 this.estadosFinais.add(linha);
						 i++;
						 
					 }
				 }
				 System.out.println(this.numDeSimbolos);
				 for(i = 0; i< this.numDeSimbolos; i++) {
					 System.out.println(this.simbolos.get(i));
				 }
				 System.out.println(this.numDeEstados);
				 for(i = 0; i< this.numDeEstados; i++) {
					 System.out.println(this.estados.get(i));
				 }
				 System.out.println(this.numDeTransicoes);
				 for(i = 0; i< this.numDeTransicoes; i++) {
					 System.out.println(transicoes.get(i));
				 }
				 System.out.println(estadoInicial);
				 System.out.println(numDeEstadosFinais);
				 for(i = 0; i< numDeEstadosFinais; i++) {
					 System.out.println(this.estadosFinais.get(i));
				 }
				 
			 }catch(IOException e) {
				 System.out.println(e);
			
			 }catch(StringIndexOutOfBoundsException o) {
				 System.out.println(o);
			 }
		} catch (FileNotFoundException o) {
			System.out.println(o);
		}
	}

	public int getNumDeSimbolos() {
		return numDeSimbolos;
	}

	public void setNumDeSimbolos(int numDeSimbolos) {
		this.numDeSimbolos = numDeSimbolos;
	}

	public ArrayList<String> getSimbolos() {
		return simbolos;
	}

	public void setSimbolos(ArrayList<String> simbolos) {
		this.simbolos = simbolos;
	}

	public int getNumDeEstados() {
		return numDeEstados;
	}

	public void setNumDeEstados(int numDeEstados) {
		this.numDeEstados = numDeEstados;
	}

	public ArrayList<String> getEstados() {
		return estados;
	}

	public void setEstados(ArrayList<String> estados) {
		this.estados = estados;
	}

	public int getNumDeTransicoes() {
		return numDeTransicoes;
	}

	public void setNumDeTransicoes(int numDeTransicoes) {
		this.numDeTransicoes = numDeTransicoes;
	}

	public ArrayList<String> getTransicoes() {
		return transicoes;
	}

	public void setTransicoes(ArrayList<String> transicoes) {
		this.transicoes = transicoes;
	}

	public String getEstadoInicial() {
		return estadoInicial;
	}

	public void setEstadoInicial(String estadoInicial) {
		this.estadoInicial = estadoInicial;
	}

	public int getNumDeEstadosFinais() {
		return numDeEstadosFinais;
	}

	public void setNumDeEstadosFinais(int numDeEstadosFinais) {
		this.numDeEstadosFinais = numDeEstadosFinais;
	}

	public ArrayList<String> getEstadosFinais() {
		return estadosFinais;
	}

	public void setEstadosFinais(ArrayList<String> estadosFinais) {
		this.estadosFinais = estadosFinais;
	}
	
	
	
}
		
		
		
	
