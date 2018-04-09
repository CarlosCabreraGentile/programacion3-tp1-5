package TP1_Ej5;
import java.util.Iterator;

import TP1_Ej5.MySimpleLinkedList.MyIterator;
 
public class MySimpleLinkedList implements Iterable<Object>{
	protected Node first;
	protected Node cursor;
	protected int nodeCount;
	protected int size;
	
	
	public class MyIterator implements Iterator<Object>{
		private Node cursor;
		 
		public MyIterator (Node primero){
			cursor = primero;
		}    

		@Override
		public boolean hasNext() {
			return cursor != null;
		}

		@Override
		public Object next() { 
			Node tmp = cursor;
			cursor = cursor.getNext();
			return tmp.getInfo();
		}
		
		public void resetCursor() {
			cursor = first;
		}
		
//		@Override
//		public void remove() {
//			// TODO Auto-generated method stub
//		}
		
	// MyIterator(Node first) {
	// cursor = first;
	// }
	}

	public MySimpleLinkedList() {
		size = 0;
		first = null;
//		last = null;
		nodeCount = 0;
	}

	public void insertarOrdenado(Object numeroLista2) {
		boolean exit = false;
		
		if(this.isEmpty()) {  
			this.insert(numeroLista2);  
		}  
		else {			
			while (!exit) {
				Node tmp = cursor;
				Object auxiliar = this.getNodo();
				Node tmp2 = new Node(numeroLista2, null);//NODO QUE VIENE COMO PARAMETRO
				
				//CASO QUE INSERTO UN NUMERO MENOR AL PRIMERO DE LA LISTA
				if (((int) numeroLista2 < (int) auxiliar) && (tmp == first)) {
					this.insert(numeroLista2);
					exit = true;
				}
				else if (((int) numeroLista2 > (int) auxiliar) && !(this.cursorHasNext())) {//PREGUNTO SI AL CURSOR QUE QUEDAN ESPACIOS
					tmp.setNext(tmp2);
					exit = true;
					size++;
				}
				//NUMERO POR PARAMETRO MAYOR QUE AUXILIAR Y SIGUIENTE A AUXILIAR MAYOR QUE EL QUE VIENE POR PARAMETRO
				else if (((int) numeroLista2 > (int) auxiliar) && ((int) tmp.getNext().getInfo() > (int) numeroLista2)) {
					tmp.setNext(tmp2);
					tmp2.setNext(cursor);
					exit = true;
					size++;
				}
				//CASO SI QUIERO AGREGAR UN NUMERO QUE YA ESTA EN LA LISTA
				else if((int) numeroLista2 == (int)auxiliar) {
					exit = true;
				}
			} 
		}
		//REINICIO CURSOR
		this.resetCursor();
		}

	public void resetCursor() {
		cursor = first;
	}

	/**
	 * @return Devuelve un objeto en la posicion cursor
	 */
	public Object get() {
		Object element = cursor.getInfo();
		cursor = cursor.getNext();
		return element;
	}

	/**
	 * @return Pregunta si el cursor tiene un elemento siguiente
	 */
	public boolean cursorHasNext() {
		return cursor != null;
	}

	/**
	 * @param o
	 * Inserta un objeto
	 */
	public void insert(Object o) {
		Node tmp = new Node(o, null);
		tmp.setNext(first);
		first = tmp;
		cursor = first;
		size++;
	}

	public void insertXCantidadDeNodos(int n) {
		for (int i = 0; i < n; i++) {
			Node tmp = new Node(i, null);
			tmp.setNext(first);
			first = tmp;
			size++;
		}
	}

	/**
	 * @return Extrae siempre el primero
	 */
	public Object extract() {
		Node tmp = first;// tmp ese vuelve el primer nodo
		first = first.getNext();// el que le sigue al primero
		size--;
		return tmp.getInfo(); // devuelvo la info del nodo que elimine
	}

	public Object getNodo() {
		Node tmp = cursor;// tmp ese vuelve el primer nodo
		cursor = cursor.getNext();// el que le sigue al primero
		return tmp.getInfo(); // devuelvo la info del nodo que elimine
	}

	public void print(int n) {
		Node nodo = first;
		if (n > size) {
			System.out.println("Error");
		} else {
			for (int i = 0; i < n; i++) {
				System.out.println("Info del nodo: " + nodo.getInfo() + " Siguiente nodo: " + nodo.getNext());
				nodo = nodo.getNext();
			}
		}
	}

	public void printNodoEspecifico(int n) {
		Node nodo = first;
		int contador = 0;
		if (n > size) {
			System.out.println("Error");
		} else {
			while (contador <= size) {
				if (n == contador) {
					System.out.println("Info del nodo: " + nodo.getInfo());
					contador++;
				} else {
					contador++;
					nodo = nodo.getNext();
				}
			}

		}
	}

	/**
	 * @return Devuelve true o false dependiendo si esta vacio o no
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	public int size() {
		return size;
	}

	public void printAll() {
		Node nodo = first;
		int tamaño = this.size();
		for (int i = 0; i < tamaño; i++) {
			System.out.println("Info del nodo: " + nodo.getInfo() + " Siguiente nodo: " + nodo.getNext());
			nodo = nodo.getNext();
		}
	} 
	
	public void printAllIterator() {
		int contador = 1;
		MyIterator iteradorListaSimple = this.iterator();
		while(iteradorListaSimple.hasNext()) {
			System.out.println("Nodo " + contador + ": " + (int)iteradorListaSimple.next());
			contador++;
		}
	}

	@Override
	public MyIterator iterator() {
		return new MyIterator(first);
	}


}
