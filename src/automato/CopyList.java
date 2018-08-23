package automato;

import java.util.LinkedList;

public class CopyList {

	public static void main(String[] args) {
		LinkedList<String> A = new LinkedList<String>();
		LinkedList<String> B = new LinkedList<String>();

		A.add("a");
		A.add("B");

		System.out.println("Exibindo A:");
		for (String string : A) {
			System.out.println(string);
		}

		System.out.println("\nCopiando A para B!\n");
		for (String s : A) {
			B.add(s);
		}

		System.out.println("Exibindo B:");
		for (String string : B) {
			System.out.println(string);
		}

	}

}
