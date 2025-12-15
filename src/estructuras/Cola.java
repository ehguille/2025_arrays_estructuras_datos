package estructuras;

public class Cola {
	
	private String[] array;

	public Cola() {
		array=new String[6];
	}
	
	public void encolar(String s) { //Meter en la cola
		if(!estaLlena())
			array[getFinal()]=s;
		else {
			//Crear un array de longitud array.lenght+6
			//Clonar el array original en el nuevo
			//Sobreescribir el viejo con el nuevo
		}
	}
	
	public String desencolar() { //Sacar de la cola
		return "Se devuelve una cadena";
	}
	
	public int getLongitud() {
		return 0; //Devuelve el número de cadenas en la cola
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
	
	private void clonar(String[] origen,String[] destino) {
		//Suponemos que el origen es más pequeño que el destino
		for(int i=0;i<origen.length;i++)
			destino[i]=origen[i];
	}
}
