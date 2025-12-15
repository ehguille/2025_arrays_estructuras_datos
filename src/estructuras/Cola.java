package estructuras;

public class Cola {
	
	private String[] array;
	private int tamanioOriginal;

	public Cola(int tamanioOriginal) {
		this.tamanioOriginal=tamanioOriginal;
		array=new String[tamanioOriginal];
	}
	
	public void encolar(String s) { //Meter en la cola
		if(!estaLlena())
			array[getFinal()]=s;
		else {
			String[] arrayMayor=new String[array.length+tamanioOriginal];
			clonar(array,arrayMayor);
			array=arrayMayor;
			array[getFinal()]=s;
		}
	}
	
	public String desencolar() { //Sacar de la cola
		return "Se devuelve una cadena";
	}
	
	public int getLongitud() {
		return getFinal()-1;
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
	
	private int getFinal() {
		for(int i=0;i<array.length;i++)
			if(array[i]==null)
				return i;
		return -1;
	}
	
	private boolean estaLlena() {
		if(getFinal()==-1)
			return true;
		else
			return false;			
	}
	
	private String[] clonar(String[] origen,String[] destino) {
		//Suponemos que el origen es más pequeño que el destino
		for(int i=0;i<origen.length;i++)
			destino[i]=origen[i];
		return destino;
	}
}
