package estructuras;

import depurador.Depurador;

public class Pila {
	
	private String[] array; //Array que sustenta la pila.
	private int tamanioInicial;//Tamaño inicial de array.
	private int fin;
		
	/**
	 * Constructor de una Pila
	 * @param tamanioInicial Espacio que tendrá el array que usaremos para
	 * implementar la pila inicialmente. Cuando la pila esté a punto de llenarse,
	 * se añadirán "tamanioInicial" posiciones extra al array; cuando decrezca,
	 * se redimensionará el array a "tamanioInicial" posiciones menos.
	 */
	public Pila(int tamanioInicial) {
		this.tamanioInicial=tamanioInicial;
		array=new String[tamanioInicial];
		fin=0; //Al crear una pila, esta está vacía, y su fin es =0.
	}
	
	/**
	 * Inserta en la pila un String
	 * @param s String a introducir.
	 */
	public void push(String s) {
		if(fin==array.length) {
			Depurador.trazar("Se ha llegado al límite del array. Se incrementa su tamaño.");
			String[] arrayNuevo=new String[array.length+tamanioInicial];
			clonar(array,arrayNuevo);
			array=arrayNuevo;			
		}
		Depurador.trazar("Se añade " + s + " a la pila.");
		array[fin]=s;
		fin++; // Se incrementa el valor del puntero al final de la cola
		Depurador.trazar("Valor del puntero 'fin':" + fin);
	}
	
	private void clonar(String[] arrayOrigen, String[] arrayDestino)  {
		Depurador.trazar("Se procede a clonar el array.");
		int tamanioMenor=0;
		if(arrayOrigen.length>arrayDestino.length)
			tamanioMenor=arrayDestino.length;
		else
			tamanioMenor=arrayOrigen.length;
		for(int i=0;i<tamanioMenor;i++)
			arrayDestino[i]=arrayOrigen[i];
	}
	
	public String pop() throws Exception {
		if(fin==0)
			throw new Exception("No puedes sacar elementos de una pila vacía.");
		fin--; //Se decrementa el valor del puntero al final de la cola
		Depurador.trazar("Valor del puntero 'fin':"+fin);
		Depurador.trazar("Se saca un elemento de la pila.");
		String resultado=array[fin];
		array[fin]=null;
		//Si el array se ha "quedado grande", lo recorto.
		if(fin==array.length-tamanioInicial) {
			Depurador.trazar("Se recorta el array");
			String[] arrayNuevo=new String[array.length-tamanioInicial];
			clonar(array,arrayNuevo);
			array=arrayNuevo;
		}	
		return resultado;
	}
	
	public String consultar() throws Exception {
		if(fin==0)
			throw new Exception("La pila que intentas consultar está vacía");
		return array[fin-1];
	}
	
	public String toString() {
		String cadena="{";
		for(int i=0;i<array.length;i++) {
			cadena+=array[i];
			if(i<array.length-1)
				cadena+=",";
		}
		cadena+="}";
		return cadena;
	}
}
