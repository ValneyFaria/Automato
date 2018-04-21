///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package automato;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Scanner;
//
///**
// *
// * @author valney
// */
//public class Automato1 {
//    public static void imprimeMatriz(LinkedList[][] matriz) {
//    	for (int i = 0; i < matriz.length ; i++) {
//    		for (int j = 0; j < matriz.length; j++) {
//    			System.out.print(matriz[i][j] + " ");
//    		}
//    		System.out.print("\n");
//    		
//    	}
//    }
//    
//    private static void imprimeLista(LinkedList[][] matriz) {
//		for (int i = 0; i < matriz.length; i++) {
//			for (int j = 0; j < matriz.length; j++) {
////				for (int j2 = 0; j2 != null; j2 = matriz[i][j].get(j2)) {
////					System.out.println(matriz[i][j].get(j2));
////				}
//				
//			}
//			
//		}
//		
//	}
//    
//    private static String pesquisar(){
//      Scanner entrada = new Scanner(System.in); 
//      System.out.println("Informe a key");
//      Integer key = entrada.nextInt();
////      if(mapaNomeClientes.containsKey(key)){
////          return String.valueOf(mapaNomeClientes.get(key));
////      }
//      return null;
//  }
//    
//    
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//    	LinkedList[][] matriz = new LinkedList[3][3]; // declaracao combinada
//        
//    	for (int i = 0; i < matriz.length; i++) {
//    		for (int j = 0; j < matriz.length; j++) {
//    			matriz[i][j] = new LinkedList();
//				matriz[i][j].addLast(i + j);
//				matriz[i][j].addLast(i + j);
//				
//			}
//			
//		}
//    	
//        imprimeMatriz(matriz);
//        
//        imprimeLista(matriz);
//        
//        ArrayList<String> lista = new ArrayList<String>();
//        lista.add("Manoel");
//        lista.add("Joaquim");
//        lista.add("Maria");
//        
//    }
// 
//}
