package estructuras;

public class Aplicacion {
	
	public Aplicacion() {
		Cola unaCola=new Cola(3);
		System.out.println(unaCola);
		unaCola.encolar("A");
		unaCola.encolar("B");
		unaCola.encolar("C");
		System.out.println(unaCola);
		unaCola.encolar("D");
		System.out.println(unaCola);
		unaCola.encolar("E");
		unaCola.encolar("F");
		System.out.println(unaCola);
		unaCola.encolar("G");
		System.out.println(unaCola);
	}

	public static void main(String[] args) {
		Aplicacion a=new Aplicacion();
	}

}
