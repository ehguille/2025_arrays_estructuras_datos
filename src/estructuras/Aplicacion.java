package estructuras;

import java.util.Scanner;

public class Aplicacion {

	public Aplicacion() throws Exception {
		this.menu();
	}

	public static void menu() throws Exception {
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
				cola.encolar(cadena); //Paso la pelota al método anterior (indicando throws Exception en su cabecera)
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
				System.out.println("Saliendo de la aplicación.");	
			}
		} while(opcion==1||opcion==2);

	}

	public static void main(String[] args) throws Exception {
		Aplicacion a = new Aplicacion();
	}

}
