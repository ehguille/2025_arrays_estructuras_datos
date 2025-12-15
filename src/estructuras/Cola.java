package estructuras;

public class Cola {
	
	private String[] array;

	public Cola() {
		array=new String[6];
	}
	
	public void encolar(String s) { //Meter en la cola
		System.out.println("Se inserta una cadena en la cola");
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
}
