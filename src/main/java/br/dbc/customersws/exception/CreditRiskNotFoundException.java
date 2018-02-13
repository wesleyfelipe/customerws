package br.dbc.customersws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No credit risk found for entered code.")
public class CreditRiskNotFoundException extends CustomerWsCustomException {

	private static final long serialVersionUID = 1L;

}
