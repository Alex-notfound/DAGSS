package ds.calculator;

import java.util.LinkedList;
import java.util.List;

import ds.framework.Application;
import ds.framework.Operation;
import ds.framework.OperationObserver;

public class Calculadora extends Application {

	@Override
	public List<Operation> createOperations() {
		
		OperationObserver opObserver = new OperationObserver();

		Suma suma = new Suma();
		suma.addObserver(opObserver);
		Division div = new Division();
		div.addObserver(opObserver);
		Raiz raiz = new Raiz();
		raiz.addObserver(opObserver);
		
		List<Operation> operations = new LinkedList<>();

		operations.add(suma);
		operations.add(div);
		operations.add(new FullVersionOperation(raiz));

		return operations;
	}
	public static void main(String[] args) {
		new Calculadora().run();
	}

}
