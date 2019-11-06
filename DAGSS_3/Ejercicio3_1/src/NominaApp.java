import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class NominaApp {

	public static void main(String[] args) {

		Scanner scanner = null;
		PrintStream out = null;
		String name;
		Nomina nomina;

		try {
			scanner = new Scanner(new File("nomina.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("the file does not exist: " + e.getMessage());
			System.exit(1);
		}
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] fields = line.split("\t");
			name = fields[0];

			nomina = selectEscala(fields[1]);
			
			nomina = bonus(Integer.parseInt(fields[2]), nomina);
			
			nomina = intern(fields[3], nomina);
			
			System.out.println(name + " " + nomina.sueldoBase());
		}

		try {
			out = new PrintStream(new FileOutputStream(new File("libros.xml")));
		} catch (FileNotFoundException e1) {
			System.err.println("the file does cannot be created: " + e1.getMessage());
			System.exit(1);
		}


	}

	private static Nomina selectEscala(String escala) {
		Nomina nomina = null;
		
		switch(escala.toUpperCase()) {
			case "A": nomina = new EscalaA();
				break;
			case "B": nomina = new EscalaB();
				break;
			case "C": nomina = new EscalaC();
				break;
		}
		
		return nomina;
	}
	
	private static Nomina bonus(int years, Nomina nomina) {
		
		Nomina compl = null;
		
		if(years - 6 >= 0) {
			if(years - 6 >= 3) {
				compl = new Sexenio(bonus(years - 6, nomina));
			}else {
				compl = new Sexenio(nomina);
			}
			
		}else if(years - 5 >= 0) {
			if(years - 5 >= 3) {
				compl = new Quinquenios(bonus(years - 5, nomina));
			}else {
				compl = new Quinquenios(nomina);
			}
			
		}else if(years - 3 >= 0){
			compl = new Trienios(nomina);
			
		}
		
		return compl;
	}
	
	private static Nomina intern(String intern, Nomina nomina) {
		
		if(intern.equalsIgnoreCase("SI")) {
			nomina = new Interno(nomina);
		}
		
		return nomina;
	}

}
