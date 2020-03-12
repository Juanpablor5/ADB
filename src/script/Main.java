package script;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
	
	public static final String RUTA_ADB = "C:\\Users\\Juan Pablo Rocha\\AppData\\Local\\Android\\Sdk\\platform-tools";
	public static final String RUTA_APK = "C:\\adb\\app.apk";
	
	public static void main(String[] args) throws IOException
	{
		// Crea el script
		PrintWriter script = new PrintWriter("script.bat");
		
		//Crea el html
		PrintWriter reporte = new PrintWriter("Reporte.html", "UTF-8");
		reporte.println("<!DOCTYPE html>");
		reporte.println("<html>");
		reporte.println("<head>");
		reporte.println("<title>HTML Reference</title>");
		reporte.println("</head>");
		reporte.println("<body>");
		reporte.println("<h1>Reporte de ADB</h1>");
		reporte.println("<h3>Hecho por Juan Pablo Rocha - COD:201611835</h3>");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime hora = LocalDateTime.now();  
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Ingrese el número de acciones que desea realizar:");		 
		String n = reader.readLine();
		
		//TODO CAMBIAR RUTAS PARA PARÁMETRO
		System.out.print("Ingrese la ruta de la carpeta raiz del ADB:");		 
//		String ruta_adb = reader.readLine();
		script.println("cd " + RUTA_ADB);
		
		//Instala el apk
		System.out.print("Ingrese la ruta del apk a instalar (incluyendo el nombre del apk):");
//		String ruta_apk = reader.readLine();
		
		//TODO DESCOMENTAR ESTOOOO
		script.println("adb install -r " + RUTA_APK);
		reporte.println("<h4>Se instala la app a las " + dtf.format(hora) + ":</h4>");
		script.println("adb shell am start -n com.example.adbapp/com.example.adbapp.MainActivity");
		script.println("timeout 1");
		script.println("adb shell screencap -p /sdcard/screen.png");
		script.println("mkdir imgjpr");
		script.println("adb pull /sdcard/screen.png imgjpr/screen.png");
		reporte.println("<img src=\"" + RUTA_ADB + "\\imgjpr\\screen.png\" width=\"320\" height=\"640\">");
		script.println("adb shell am force-stop com.example.adbapp");
		
		reporte.println("<h3>Comienza a realizar los " + n + " eventos a las " + dtf.format(hora) + ":</h3>");
		// Recorre el número de acciones
		int c=1;
		while(c<=Integer.parseInt(n)) {
			if(c%8==0) {
				reporte.println("<h3>Hace back</h3>");
				script.println("adb shell input keyevent 4");
			}
			
			//Evento 1
			if(c<=Integer.parseInt(n)) {
				reporte.println("<h4>Se inicia el evento 1: abrir primer app</h4>");
				script.println("adb shell input keyevent 3");
				script.println("adb shell input swipe 538 1714 583 1005 100");
				script.println("adb shell input tap 162 1241");
				script.println("timeout 1");
				script.println("adb shell screencap -p /sdcard/screen"+c+".png");
				script.println("adb pull /sdcard/screen"+c+".png imgjpr/screen"+c+".png");
				script.println("adb shell input keyevent 3");
				reporte.println("<img src=\"" + RUTA_ADB + "\\imgjpr\\screen"+c+".png\" width=\"320\" height=\"640\">");
				c++;
			}
			
			//Evento 2
			if(c<=Integer.parseInt(n)) {
				int x = 250;
				for (int i = 0; i < 3; i++) {
					reporte.println("<h4>Se inicia el evento 2: pulsación larga</h4>");
					script.println("adb shell input keyevent 3");
					script.println("adb shell input swipe 538 1714 583 1005 100");
					script.println("adb shell input swipe "+(180+x*i)+" 940 "+(180+x*i)+" 940 1000");
					script.println("timeout 1");
					script.println("adb shell screencap -p /sdcard/screen"+(c+i)+".png");
					script.println("adb pull /sdcard/screen"+(c+i)+".png imgjpr/screen"+(c+i)+".png");
					script.println("adb shell input keyevent 3");
					reporte.println("<img src=\"" + RUTA_ADB + "\\imgjpr\\screen"+(c+i)+".png\" width=\"320\" height=\"640\">");
				}
				c++;
			}
			
			//Evento 3
			if(c<=Integer.parseInt(n)) {
				reporte.println("<h4>Se inicia el evento 3: Wi-Fi</h4>");
				script.println("adb shell input keyevent 3");
				script.println("adb shell am start -n com.android.settings/.wifi.WifiStatusTest");
				script.println("timeout 1");
				script.println("adb shell screencap -p /sdcard/screen"+c+".png");
				script.println("adb pull /sdcard/screen"+c+".png imgjpr/screen"+c+".png");
				script.println("adb shell input keyevent 3");
				reporte.println("<img src=\"" + RUTA_ADB + "\\imgjpr\\screen"+c+".png\" width=\"320\" height=\"640\">");
				c++;
			}		
			
			//Evento 4
			if(c<=Integer.parseInt(n)) {
				reporte.println("<h4>Se inicia el evento 4: modo avión</h4>");
				script.println("adb shell input keyevent 3");
				script.println("adb shell input swipe 570 1550 570 1880 100");
				script.println("adb shell input swipe 570 1550 570 1880 100");
				script.println("adb shell input tap 928 1484");
				script.println("timeout 1");
				script.println("adb shell screencap -p /sdcard/screen"+c+".png");
				script.println("adb pull /sdcard/screen"+c+".png imgjpr/screen"+c+".png");
				script.println("adb shell input keyevent 3");
				reporte.println("<img src=\"" + RUTA_ADB + "\\imgjpr\\screen"+c+".png\" width=\"320\" height=\"640\">");
				c++;
			}
			
			//Evento 5
			if(c<=Integer.parseInt(n)) {
				reporte.println("<h4>Se inicia el evento 5: añadir contacto</h4>");
				script.println("adb shell input keyevent 3");
				script.println("adb adb shell input keyevent 207");
				script.println("adb shell am start -a android.intent.action.INSERT -d 'content://contacts/people' -t 'vnd.android.cursor.dir/person' -c 'android.intent.category.DEFAULT' -e 'name' 'Juan Pablo'  -e 'phone' '123456789'");
				script.println("adb shell input tap 795 1249");
				script.println("timeout 1");
				script.println("adb shell screencap -p /sdcard/screen"+c+".png");
				script.println("adb pull /sdcard/screen"+c+".png imgjpr/screen"+c+".png");
				script.println("adb shell input keyevent 3");
				reporte.println("<img src=\"" + RUTA_ADB + "\\imgjpr\\screen"+c+".png\" width=\"320\" height=\"640\">");
				c++;
			}
			
			//Evento 6
			if(c<=Integer.parseInt(n)) {
				reporte.println("<h4>Se inicia el evento 6: abrir primer app</h4>");
				script.println("adb shell input keyevent 3");
				script.println("adb shell input swipe 538 1714 583 1005 100");
				script.println("adb shell input tap 162 1241");
				script.println("timeout 1");
				script.println("adb shell screencap -p /sdcard/screen"+c+".png");
				script.println("adb pull /sdcard/screen"+c+".png imgjpr/screen"+c+".png");
				script.println("adb shell input keyevent 3");
				reporte.println("<img src=\"" + RUTA_ADB + "\\imgjpr\\screen"+c+".png\" width=\"320\" height=\"640\">");
				c++;
			}
			
			//Evento 7
			if(c<=Integer.parseInt(n)) {
				int x = 250;
				for (int i = 0; i < 3; i++) {
					reporte.println("<h4>Se inicia el evento 7: pulsación larga</h4>");
					script.println("adb shell input keyevent 3");
					script.println("adb shell input swipe 538 1714 583 1005 100");
					script.println("adb shell input swipe "+(180+x*i)+" 940 "+(180+x*i)+" 940 1000");
					script.println("timeout 1");
					script.println("adb shell screencap -p /sdcard/screen"+(c+i)+".png");
					script.println("adb pull /sdcard/screen"+(c+i)+".png imgjpr/screen"+(c+i)+".png");
					script.println("adb shell input keyevent 3");
					reporte.println("<img src=\"" + RUTA_ADB + "\\imgjpr\\screen"+(c+i)+".png\" width=\"320\" height=\"640\">");
				}
				c++;
			}
			
			//Evento 8
			if (c <= Integer.parseInt(n)) {
				reporte.println("<h4>Se inicia el evento 8: Estado de batería</h4>");
				script.println("adb shell input keyevent 3");
				script.println("adb shell cat /sys/class/power_supply/battery/capacity > batterystats.txt");

				File file = new File(RUTA_ADB + "\\batterystats.txt");

				BufferedReader br = new BufferedReader(new FileReader(file));
				String st;
				while ((st = br.readLine()) != null) {
					reporte.println("<h4>El estado de la batería es "+st+"%</h4>");
				}				
				br.close();
				c++;
			}
			
			//Evento 9
			if(c<=Integer.parseInt(n)) {
				reporte.println("<h4>Se inicia el evento 9: encender bluetooth</h4>");
				script.println("adb shell input keyevent 3");
				script.println("adb shell input swipe 570 1550 570 1880 100");
				script.println("adb shell input swipe 570 1550 570 1880 100");
				script.println("adb shell input tap 431 899");
				script.println("adb shell input tap 956 891");
				script.println("timeout 2");
				script.println("adb shell screencap -p /sdcard/screen"+c+".png");
				script.println("adb pull /sdcard/screen"+c+".png imgjpr/screen"+c+".png");
				script.println("adb shell input keyevent 3");
				reporte.println("<img src=\"" + RUTA_ADB + "\\imgjpr\\screen"+c+".png\" width=\"320\" height=\"640\">");
				c++;
			}
			
			//Evento 10
			if(c<=Integer.parseInt(n)) {
				reporte.println("<h4>Se inicia el evento 10: añadir contacto</h4>");
				script.println("adb shell input keyevent 3");
				script.println("adb adb shell input keyevent 207");
				script.println("adb shell am start -a android.intent.action.INSERT -d 'content://contacts/people' -t 'vnd.android.cursor.dir/person' -c 'android.intent.category.DEFAULT' -e 'name' 'Juan Pablo'  -e 'phone' '123456789'");
				script.println("adb shell input tap 795 1249");
				script.println("timeout 1");
				script.println("adb shell screencap -p /sdcard/screen"+c+".png");
				script.println("adb pull /sdcard/screen"+c+".png imgjpr/screen"+c+".png");
				script.println("adb shell input keyevent 3");
				reporte.println("<img src=\"" + RUTA_ADB + "\\imgjpr\\screen"+c+".png\" width=\"320\" height=\"640\">");
				c++;
			}

		}
		
		//Cierre del HTML
		reporte.println("</body>");
		reporte.println("</html>");
		
		// Ejecuta el script
		Runtime rt = Runtime.getRuntime();
		rt.exec("cmd /c start script.bat");
//		out.println("@exit");
		script.close();
		reporte.close();
	}
}
