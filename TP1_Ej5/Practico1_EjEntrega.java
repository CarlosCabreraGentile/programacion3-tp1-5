package TP1_Ej5;

import TP1_Ej5.MySimpleLinkedList.MyIterator;

public class Practico1_EjEntrega {

	public static void main(String[] args) {
		MySimpleLinkedList listaSimple = new MySimpleLinkedList();
		MySimpleLinkedList listaSimple1 = new MySimpleLinkedList();
		MySimpleLinkedList listaSimple2 = new MySimpleLinkedList();
		
		listaSimple1.insert(5);
		listaSimple1.insert(2);
		listaSimple1.insert(8);
		listaSimple1.insert(1);
		listaSimple1.insert(9);
		listaSimple1.insert(7);
		listaSimple1.insert(2);
		listaSimple1.insert(1);
		listaSimple1.insert(14);
						 
		listaSimple2.insert(5);
		listaSimple2.insert(14);
		listaSimple2.insert(8); 
		listaSimple2.insert(1);
		listaSimple2.insert(9);
		listaSimple2.insert(7); 
		listaSimple2.insert(6); 
		listaSimple2.insert(4); 
		listaSimple2.insert(2); 
		
		cargarNumeroComun(listaSimple, listaSimple1, listaSimple2);
		listaSimple.printAllIterator();
		
		
//		listaSimple1.insert(20);
//		listaSimple1.insert(16);
//		listaSimple1.insert(14);
//		listaSimple1.insert(12);
//		listaSimple1.insert(10);
//		listaSimple1.insert(7);
//		listaSimple1.insert(4);
//		listaSimple1.insert(3);
//		listaSimple1.insert(1);
//						 
//		listaSimple2.insert(50);
//		listaSimple2.insert(14);
//		listaSimple2.insert(12); 
//		listaSimple2.insert(11);
//		listaSimple2.insert(10);
//		listaSimple2.insert(7); 
//		listaSimple2.insert(6); 
//		listaSimple2.insert(5); 
//		listaSimple2.insert(3); 
//		
//		cargarNumeroComunOrdenado(listaSimple, listaSimple1, listaSimple2);
//		listaSimple.printAllIterator();

	}
	
	/**
	 * EJERCICIO 5 INCISO A
	 * @param listaSimple
	 * @param listaSimple1
	 * @param listaSimple2
	 * Carga a una listaSimple los numeros que hay en
	 * comun entre la listaSimple1 y la listaSimple2
	 */
	public static void cargarNumeroComun(MySimpleLinkedList listaSimple, MySimpleLinkedList listaSimple1, MySimpleLinkedList listaSimple2) {
		boolean exit = false;
		
		MyIterator iteradorLista1 = listaSimple1.iterator();
		MyIterator iteradorLista2 = listaSimple2.iterator();
		
		while(iteradorLista1.hasNext()) { 
			Object numeroLista1 = iteradorLista1.next();  
			while(iteradorLista2.hasNext() && (!exit)) {
				Object numeroLista2 = iteradorLista2.next();
				
				if(numeroLista1.equals(numeroLista2)) {
					listaSimple.insertarOrdenado(numeroLista2);
				}
			}
			iteradorLista2.resetCursor();
		}
	}
	
	/**
	 * EJERCICIO 5 INCISO B
	 * @param listaSimple
	 * @param listaSimple1
	 * @param listaSimple2
	 * Carga a una listaSimple los numeros que hay en
	 * comun entre la listaSimple1 y la listaSimple2
	 */
	public static void cargarNumeroComunOrdenado(MySimpleLinkedList listaSimple, MySimpleLinkedList listaSimple1, MySimpleLinkedList listaSimple2) {
		boolean exit = false;
		
		MyIterator iteradorLista1 = listaSimple1.iterator();
		MyIterator iteradorLista2 = listaSimple2.iterator();
		
		while(iteradorLista1.hasNext()) { 
			Object numeroLista1 = iteradorLista1.next();  
			while(iteradorLista2.hasNext() && (!exit)) {
				Object numeroLista2 = iteradorLista2.next();
				
				if(numeroLista1.equals(numeroLista2)) {
					listaSimple.insert(numeroLista2);
				}
			}
			iteradorLista2.resetCursor();
		}
	}
}
