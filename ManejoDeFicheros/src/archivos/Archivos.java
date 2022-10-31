package archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Archivos {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		File file = null;
		String lectura = "";
		
		System.out.println("Introduce una ruta:\n");
		
		try {
			lectura = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}
		
		System.out.println(lectura);
		
		file = new File(lectura);
		
		if (!file.exists()) {
			
			System.out.println("\nEl archivo no existe. Creando...");
						
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(-2);
			}
			
		}
		
	}
	
}