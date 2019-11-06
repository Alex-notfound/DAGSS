import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NominaApp {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(new File("nomina.txt"))) {

			String name;
			Nomina nomina;

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] fields = line.split("\t");
				name = fields[0];

				nomina = selectEscala(fields[1]);

				nomina = bonus(Integer.parseInt(fields[2]), nomina);

				nomina = intern(fields[3], nomina);

				System.out.println(name + " " + nomina.sueldoBase());
			}

		} catch (FileNotFoundException e) {
			System.err.println("the file does not exist: " + e.getMessage());
			System.exit(1);
		}
	}

	private static Nomina selectEscala(String escala) {

		switch (escala.toUpperCase()) {
		case "A":
			return new EscalaA();
		case "B":
			return new EscalaB();
		case "C":
			return new EscalaC();
		}
		return null;
	}

	private static Nomina bonus(int years, Nomina nomina) {

		if (years >= 6) {
			return bonus(years - 6, new Sexenio(nomina));
		}
		if (years >= 5) {
			return bonus(years - 5, new Quinquenio(nomina));
		}
		if (years >= 3) {
			return bonus(years - 3, new Trienio(nomina));
		}
		return nomina;
	}

	private static Nomina intern(String intern, Nomina nomina) {
		return intern.equalsIgnoreCase("SI") ? new Interno(nomina) : nomina;
	}

}
