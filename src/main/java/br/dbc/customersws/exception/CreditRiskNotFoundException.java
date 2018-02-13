package br.dbc.customersws.exception;

public class CreditRiskNotFoundException extends CustomerWsCustomException {

	private static final long serialVersionUID = 1L;

	private static final String MESSAGE = "No credit risk found for entered code.";

	public CreditRiskNotFoundException() {

		super(MESSAGE);

	}

}
