package br.dbc.customersws.service;

import java.util.List;

import br.dbc.customersws.entity.CreditRisk;

/**
 * @author Wesley Felipe
 */
public interface ICreditRiskService {

	public List<CreditRisk> findAll();
	
	public CreditRisk save(CreditRisk risk);
}
