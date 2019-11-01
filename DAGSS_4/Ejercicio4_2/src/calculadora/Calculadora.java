package calculadora;

import java.util.LinkedList;
import java.util.List;

import framework.Application;
import framework.Operation;
import operations.Suma;

public class Calculadora extends Application{

	@Override
	public List<Operation> createOperations() {
		List<Operation> operations = new LinkedList<>();
		
		operations.add(new Suma());
		
		return operations;
	}

}
