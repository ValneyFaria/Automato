package automato;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		int opt = 0;
		String palavra;
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Escolha uma opcao:");
		System.out.println("1 - AFD\n2 - AFN");
		
		opt = ler.nextInt();
		
		while (opt == 0) {
			if (opt == 1) {

			} else if (opt == 2) {

			} else {
				System.out.println("Opcao Invalida!");
				opt = 0;
			}
		}

		System.out.println("Insira a Palavra a ser conferida pelo automato:");
		palavra = ler.next();
		
		if(opt == 1) {
			AFD.Verifica(palavra);
		}
		else if (opt == 2) {
			/*AFN.Verifica(palavra);*/
		}
		
		ler.close();
		
	}

}
