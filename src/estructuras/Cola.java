package estructuras;

public class Cola {
	
	private String[] array;
	private int tamanioOriginal;
	private static boolean DEPURACION=true;
	private final String[] malsonantes= {"CULO","CACA","PEDO","PIS","PIS "};

	public Cola(int tamanioOriginal) {
		this.tamanioOriginal=tamanioOriginal;
		array=new String[tamanioOriginal];
	}
	
	public void encolar(String s) throws Exception { //Meter en la cola
		if(esMalsonante(s))
			throw new Exception("No se admiten palabras malsonantes.");
		if(!estaLlena()) {
			array[getFinal()]=s;
			imprimirTraza("Cola con espacio disponible");
			imprimirTraza("Se mete "+s+" en la cola.");
			imprimirTraza("Estado de la cola: "+this.toString());
		}
		else {
			imprimirTraza("Cola llena. Se amplía su tamaño.");
			String[] arrayMayor=new String[array.length+tamanioOriginal];
			clonar(array,arrayMayor);
			array=arrayMayor;
			imprimirTraza("Se mete "+s+" en la cola.");
			array[getFinal()]=s;
			imprimirTraza("Estado de la cola: "+this.toString());
		}
	}
	
	public String desencolar() throws Exception { // Sacar de la cola
		if (array[0] == null) {
			Exception e=new Exception("Se está intentando desencolar de una cola vacía.");
			throw e;
			//throw new Exception("Se está intentando..");
		}
		else {
			imprimirTraza("Se desencola y se obtiene el elemento " + array[0]);
			String cadenaRetorno = array[0];
			imprimirTraza("Se comprime el array");
			for (int i = 0; i < array.length - 1; i++)
				array[i] = array[i + 1];
			if (getFinal() < array.length - tamanioOriginal) {
				imprimirTraza("Se libera espacio en memoria");
				String[] arrayMenor = new String[array.length - tamanioOriginal];
				arrayMenor = clonar(array, arrayMenor);
				array = arrayMenor;
			}
			imprimirTraza("Estado de la cola " + this.toString());
			return cadenaRetorno;
		}
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
		imprimirTraza("Se clona origen (ID del objeto='"+origen+"') en destino (ID del objeto='"+destino+"'");
		int menorTamanio;
		if(origen.length<destino.length)
			menorTamanio=origen.length;
		else
			menorTamanio=destino.length;
		//Suponemos que el origen es más pequeño que el destino
		for(int i=0;i<menorTamanio;i++)
			destino[i]=origen[i];
		return destino;
	}
	
	private boolean esMalsonante(String palabra) {
		boolean esMalsonante=false;
		for(int i=0;i<this.malsonantes.length;i++)
			if(palabra.toUpperCase().equals(malsonantes[i])) {
				//No puedo usar == para comparar Strings.
				esMalsonante=true;
				break;
			}
		return esMalsonante;
	}
	
	private static void imprimirTraza(String mensaje) {
		if(DEPURACION==true)
			System.out.println("[TRAZA] "+mensaje);
	}
}
