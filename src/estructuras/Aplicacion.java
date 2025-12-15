package estructuras;

public class Aplicacion {
	
	public Aplicacion() {
		Cola unaCola=new Cola();
		System.out.println(unaCola);
		unaCola.encolar("A");
		unaCola.encolar("B");
		unaCola.encolar("C");
		unaCola.encolar("D");
		unaCola.encolar("E");
		unaCola.encolar("F");
		unaCola.encolar("G");
		System.out.println(unaCola);
	}

	public static void main(String[] args) {
		Aplicacion a=new Aplicacion();
	}

}
