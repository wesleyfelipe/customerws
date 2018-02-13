package br.dbc.customersws.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * @author Wesley Felipe
 */
public class CustomerCredit implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal creditLimit;

	private CreditRisk risk;

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	public CreditRisk getRisk() {
		return risk;
	}

	public void setRisk(CreditRisk risk) {
		this.risk = risk;
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
