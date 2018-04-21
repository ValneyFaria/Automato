///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package automato;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//
///**
// *
// * @author valney
// */
//public class Automato {
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
//			}
//			
//		}
//    	
//        imprimeMatriz(matriz);
//        
//        ArrayList<String> lista = new ArrayList<String>();
//        lista.add("Manoel");
//        lista.add("Joaquim");
//        lista.add("Maria");
//        
//    }
//    
//}
