package estructuras;

public class ListaEnlazada <T> {
	
	private class Nodo <T> {
		T contenido;
		Nodo<T> siguiente;
		
		private Nodo(T contenido) {
			this.contenido=contenido;
			this.siguiente=null;
		}
	}
	
	private Nodo<T> cabecera;
	
	public ListaEnlazada() {
		cabecera=null;
	}
	
	public void insertar(T contenido) {
		Nodo<T> unNodo=new Nodo<T>(contenido);
		if(cabecera==null)
			cabecera=unNodo;
		else {
			Nodo<T> nodoParaIterar=cabecera;
			while(nodoParaIterar.siguiente!=null) {
				nodoParaIterar=nodoParaIterar.siguiente;
			}
			nodoParaIterar.siguiente=unNodo;			
		}
	}
	
	public String toString() {
		String resultado="[";
		Nodo<T> nodoParaIterar=cabecera;
		while(nodoParaIterar!=null) {
			resultado+=nodoParaIterar.contenido.toString();
			if(nodoParaIterar.siguiente!=null)
				resultado+=",";
			nodoParaIterar=nodoParaIterar.siguiente;
		}
		return resultado+"]";
	}

}
