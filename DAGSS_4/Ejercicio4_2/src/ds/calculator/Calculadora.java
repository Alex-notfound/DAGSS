package ds.calculator;

import java.util.LinkedList;
import java.util.List;

import ds.framework.Application;
import ds.framework.Operation;

public class Calculadora extends Application {

	@Override
	public List<Operation> createOperations() {

		List<Operation> operations = new LinkedList<>();

		operations.add(new Suma());
		operations.add(new Division());
		operations.add(new FullVersionOperation(new Raiz()));

		return operations;
	}
	public static void main(String[] args) {
		new Calculadora().run();
	}

}
