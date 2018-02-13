package br.dbc.customersws.to;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * @author Wesley Felipe
 */
public class NewCustomerTo implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "� obrigat�rio informar o nome do cliente.")
	@Pattern(regexp = ".*\\w+\\s+\\w.*", message = "O nome do cliente deve possuir no m�nimo duas part�culas")
	private String name;

	@NotNull(message = "� obrigat�rio informar o limite de cr�dito do cliente.")
	@DecimalMin(value = "0.00", message = "O valor do limite de cr�dito deve ser maior que zero.")
	private BigDecimal creditLimit;

	@NotNull(message = "� obrigat�rio informar o c�digo referente ao tipo de risco associado ao cliente.")
	private String creditRiskCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getCreditRiskCode() {
		return creditRiskCode;
	}

	public void setCreditRiskCode(String creditRiskCode) {
		this.creditRiskCode = creditRiskCode;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
