package ds.framework;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.sun.media.jfxmedia.logging.Logger;

public abstract class Application implements Runnable {

	public abstract List<Operation> createOperations();

	ConsoleLogger consoleLog = ConsoleLogger.getInstance(Logger.INFO, null);

	// Implements Runnable?
	public void run() {
		while (true) {

			// Se que esto se puede resumir en un linea, lo dejo asi por ahora para que se
			// vea mas claro como funciona

			int op = showMenu();
			Operation operation = getOperation(op);
			List<String> paramsValues = getOptions(operation);
			String result = runOperation(operation, paramsValues);
			System.out.println("Result: " + result);

		}
	}

	private int showMenu() {
		List<Operation> operations = createOperations();

		int option = 0;
		do {
			System.out.println("Choose an option:");
			for (option = 0; option < operations.size(); option++) {
				System.out.printf("\t%d. %s\n", option, operations.get(option).getName());
			}

			System.out.printf("\t%d. Quit\n", option);

			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			try {
				option = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				System.err.println("Introduce una opción correcta: ");
				option = -1;
			}

		} while (option < 0 || option > operations.size());

		if (option == operations.size()) {
			this.consoleLog.log("[INFO] The program has been finished.", Logger.INFO);
			System.exit(0);
		}

		return option;

	}

	private Operation getOperation(int operacion) {
		return createOperations().get(operacion);
	}

	private List<String> getOptions(Operation operation) {
		List<String> results = new LinkedList<>();

		System.out.println("Param values:");

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String ope = null;
		boolean repetir;
		for (int i = 0; i < operation.getParameterNames().size(); i++) {
			System.out.println(operation.getParameterNames().get(i) + ":");
			repetir = true;
			while (repetir) {
				repetir = false;
				ope = input.nextLine();
				try {
					Double.parseDouble(ope);
				} catch (NumberFormatException e) {
					System.err.println("Introduce un valor numérico: ");
					repetir = true;
				}
			}
			results.add(ope);
		}

		return results;
	}

	private String runOperation(Operation operation, List<String> paramsValues) {
		String msg = String.format("[INFO] %s has been executed.", operation.getName());

		this.consoleLog.log(msg, Logger.INFO);
		return operation.exectute(paramsValues);
	}

}
