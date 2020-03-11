package script;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
	
	public static final String RUTA_ADB = "C:\\Users\\Juan Pablo Rocha\\AppData\\Local\\Android\\Sdk\\platform-tools";
	
	public static void main(String[] args) throws IOException
	{
		// Crea el script
		PrintWriter out = new PrintWriter("script.bat");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Ingrese el número de acciones que desea realizar:");		 
		String n = reader.readLine();
		
//		System.out.print("Ingrese la ruta de la carpeta raiz del ADB:");		 
//		String adb = reader.readLine();
		out.println("cd " + RUTA_ADB);
		
		// Recorre el número de acciones
		int c=1;
		while(c<=Integer.parseInt(n)) {
			out.println("adb devices");
			c++;
		}
		
		// Ejecuta el script
		Runtime rt = Runtime.getRuntime();
		rt.exec("cmd /c start script.bat");
//		out.println("@exit");
		out.close();
	}
}
