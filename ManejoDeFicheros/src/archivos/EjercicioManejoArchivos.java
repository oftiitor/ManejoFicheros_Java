package archivos;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class EjercicioManejoArchivos {

	public static void main(String[] args) {
		
		/*
		 * Pide al usuario una opción de las siguientes y la hace:
		 * 
		 * 		a. Crear un archivo: archivo común o directorio.
		 * 		b. Borrar un archivo.
		 * 		c. Renombrar un archivo.
		 * 		d. Mover un archivo.
		 */
		
		Scanner sc = new Scanner(System.in);
		int opcion;
		boolean salirBucle = true;
		
		File file = null;
		File directory = null;
		String archivo = "";
		String directorio = "";
		
		do {
			System.out.println("Elija una de las siguientes opciones:\n"
					+ " 1. Crear un archivo: archivo común o directorio.\n"
					+ " 2. Borrar un archivo.\n"
					+ " 3. Renombrar un archivo.\n"
					+ " 4. Mover un archivo.\n"
					+ " 5. Salir del menú.\n");
			opcion = sc.nextInt();
			sc.nextLine();
			
			switch (opcion) {
			case 1:
				
				String eleccion;
				
				System.out.println("\n¿Desea crear un archivo o un directorio?\n");
				eleccion = sc.nextLine().toLowerCase();
				
				if (eleccion.equals("archivo")) {
					
					System.out.println("\nIntroduzca el nombre del archivo que desee crear:\n");
					archivo = sc.nextLine();
					
					file = new File(archivo);
					
					if (file.exists()) {
						
						System.out.println("\nEl archivo introducido ya existe.\n");
						
					} else {
						
						try {
							file.createNewFile();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.exit(-1);
						}
						
						System.out.println("\nEl archivo '" + archivo + "' se ha creado correctamente.\n");
						
					}
					
				} else if (eleccion.equals("directorio")) {
					
					System.out.println("\nIntroduzca el nombre del directorio que desee crear:\n");
					directorio = sc.nextLine();
					directory = new File(directorio);
					
					if (directory.exists()) {
						
						System.out.println("\nEl directorio introducido ya existe.\n");
						
					} else {
						
						directory.mkdirs();						
						System.out.println("\nEl directorio '" + directorio + "' se ha creado correctamente.\n");
						
					}
					
				} else {
					System.out.println("El nombre introducido no es válido.");
				}
				
				salirBucle = false;
				
				break;
				
			case 2:
				
				System.out.println("\nIntroduzca el nombre del archivo que desee borrar:\n");
				archivo = sc.nextLine();
				file = new File(archivo);
				
				if (file.exists()) {						
					
					file.delete();
					System.out.println("\nEl archivo '" + archivo + "' se ha borrado correctamente.\n");
					
				} else {
					
					System.out.println("\nEl archivo introducido no existe.\n");
					
				}
				
				salirBucle = false;
				
				break;
				
			case 3:
				
				System.out.println("\nIntroduzca el nombre del archivo que desee renombrar:\n");
				archivo = sc.nextLine();
				file = new File(archivo);
				
				System.out.println("\nIntroduzca el nuevo nombre del archivo:\n");
				String archivo2 = "";
				archivo2 = sc.nextLine();
				File file2 = new File(archivo2);
				
				if (file.exists()) {						
					
					file.renameTo(file2);
					System.out.println("\nEl archivo '" + archivo + "' ha sido renombrado correctamente.\nSu nuevo nombre es '" + archivo2 + "'.\n");
					
				} else {
					
					System.out.println("\nEl archivo introducido no existe.\n");
					
				}
				
				salirBucle = false;
				
				break;
				
			case 4:
				
				System.out.println("\nIntroduzca el nombre del archivo que desee mover:\n");
				archivo = sc.nextLine();
				file = new File(archivo);
				
				if (file.exists()) {
					System.out.println("\nIntroduzca la ruta del archivo que desee mover:\n");
					String rutaAntigua = "";
					rutaAntigua = sc.nextLine();
					
					System.out.println("\nIntroduzca la nueva ruta del archivo:\n");
					String rutaNueva = "";
					rutaNueva = sc.nextLine();
					
					try {
						Files.move(Path.of(rutaAntigua), Path.of(rutaNueva), StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println("\nEl archivo ha sido movido exitosamente a su nueva ruta.\n");
				} else {
					
					System.out.println("\nEl archivo introducido no existe.\n");
					
				}
				
				salirBucle = false;
				
				break;

			case 5:
								
				System.out.println("Adiós! Esperamos volver a verte pronto.");
				salirBucle = true;
				
				break;
			default:
				
				System.out.println("La opción seleccionada no es válida.");
				
				break;
			}
			
		} while (salirBucle == false);

	}

}
