package ds.calculator;

import java.util.List;

import ds.framework.Operation;

public class FullVersionOperation extends Operation {

	private Operation operation;

	public FullVersionOperation(Operation op) {
		super(op.getName(), op.getParameterNames());
		operation = op;
	}

	@Override
	public String execute(List<String> paramValues) {
		if (LicenseManager.checkIsFullVersion()) {
			return operation.execute(paramValues);
		} else {
			return "ERROR: Hace falta la versión de pago para ejecutar esta operación";
		}
	}

}
