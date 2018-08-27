package automato;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		String opt = "0";
		String palavra;
		Scanner le = new Scanner(System.in);
		
		System.out.println("MONTADOR E SIMULADOR DE AFD E AFN\n");
		System.out.println("Escolha uma opção:");
		System.out.println("1 - AFD\n2 - AFN");

		while (opt.equals("0")) {
			opt = le.next();
			if (opt.equals("1")) {

			} else if (opt.equals("2")) {

			} else {
				System.out.println("Opcao Invalida! Escolha outra:");
				opt = "0";
			}
		}

		System.out.println("Insira a Palavra a ser conferida pelo automato:");
		palavra = le.next();

		if (opt.equals("1")) {
			AFD afd = new AFD();
			afd.Verifica(palavra);
		} else if (opt.equals("2")) {
			AFN afn = new AFN();
			afn.Verifica(palavra);
		}

		le.close();
		System.out.println("\nTHE END");

	}
}