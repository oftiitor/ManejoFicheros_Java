package archivos;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class Ejercicios {

	public static void main(String[] args) {
		
		/*
		 * 1. Pedir al usuario una ruta (absoluta o relativa). 
		 * 2. Si el archivo exite, entonces muestra sus metadatos:
		 * 		a) Nombre.
		 * 		b) Ruta absoluta.
		 * 		c) Tamaño del archivo.
		 * 		d) Los permisos de lectura, escritura y ejecución.
		 * 		e) La fecha de modificación.
		 *  	f) Si es archivo o directorio.
		 * */

		String archivo = "";
		File file;
		
		Scanner sc = new Scanner(System.in);
		String ruta;
		
		System.out.println("Introduce una ruta:\n");
		ruta = sc.nextLine();
		file = new File(ruta);
		
		if (file.exists()) {
			System.out.println("A continuación, mostraremos algunos datos del archivo:\n");
			System.out.println("\ta) Nombre del archivo: " + "\n · " + file.getName());
			System.out.println("\tb) Ruta absoluta del archivo: " + "\n · " + file.getAbsolutePath());
			System.out.println("\tc) Tamaño del archivo: " + "\n · " + file.length());
			System.out.println("\td) ¿Dispone de permisos de lectura?: " + "\n · " + file.canRead());
			System.out.println("\t   ¿Dispone de permisos de escritura?: " + "\n · " + file.canWrite());
			System.out.println("\t   ¿Dispone de permisos de ejecución?: " + "\n · " + file.canExecute());
			System.out.println("\te) Fecha de modificación:" + "\n · " + new Date(file.lastModified()));
			System.out.println("\tf) ¿Es archivo?:" + "\n · " + file.isFile());
			System.out.println("\t   ¿Es directorio?:" + "\n · " + file.isDirectory());
			
		} else {
			System.out.println("La ruta introducida no lleva a ningún archivo existente.");
		}
		
	}

}
