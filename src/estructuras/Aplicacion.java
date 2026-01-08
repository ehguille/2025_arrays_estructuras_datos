package estructuras;

import java.util.Scanner;

public class Aplicacion {

	public Aplicacion() throws Exception {
		this.mostrarMenu();
	}

	public void mostrarMenu() throws Exception {
		this.mostrarMenuGestionPilas();
	}
	
	public void mostrarMenuGestionPilas() {
		Pila pila=new Pila(3);
		Scanner s=new Scanner(System.in);
		int opcion=0;
		do {
			System.out.println("Gestión de pilas. Escoge una opción:");
			System.out.println("1) Meter un String en la pila");
			System.out.println("2) Sacar un String de la pila");
			System.out.println("Otra opción: salir");
			opcion=s.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("Introduce una cadena para encolar:");
				String cadena=s.next();
				pila.push(cadena);
				break;
			case 2:
				System.out.println(pila.pop());
				break;
			default:
				System.out.println("Volviendo al menú anterior...");	
			}
		} while(opcion==1||opcion==2);
	}
	
	public void mostrarMenuGestionColas() throws Exception {
		Cola cola=new Cola(3);
		Scanner s=new Scanner(System.in);
		int opcion=0;
		do {
			System.out.println("Gestión de colas. Escoge una opción:");
			System.out.println("1) Meter un String en la cola");
			System.out.println("2) Sacar un String de la cola");
			System.out.println("Otra opción: salir");
			opcion=s.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("Introduce una cadena para encolar:");
				String cadena=s.next();
				try {
					cola.encolar(cadena); //Me como el marrón	
				} catch(Exception e) {
					System.out.println("No puedes meter una palabra malsonante, ¿quieres que haga un trapi para meterla igualmente? (S\\N)");
					String sino=s.next();
					if(sino.equals("S"))
						cola.encolar(cadena+" "); //Esto me obliga a poner un throws en la cabecera del método y pasar la pelota.
				}				
				break;
			case 2:
				try {
					System.out.println(cola.desencolar());
				} catch (Exception e) {
					//Dejo la pelota explotar:
					//e.printStackTrace();
					//Gestiono la pelota (me como el marrón):
					System.out.println("La cola está vacía. Escoge otra opción.");
				}
				break;
			default:
				System.out.println("Volviendo al menú anterior...");	
			}
		} while(opcion==1||opcion==2);
	}

	public static void main(String[] args) throws Exception {
		Aplicacion a = new Aplicacion();
	}

}
