package br.dbc.customersws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.dbc.customersws.entity.CreditRisk;
import br.dbc.customersws.repository.ICreditRiskRepository;

/**
 * @author Wesley Felipe
 */
@Component
public class CreditRiskServiceImpl implements ICreditRiskService {

	@Autowired
	private ICreditRiskRepository creditRiskrepository;

	public List<CreditRisk> findAll() {
		return creditRiskrepository.findAll();
	}

	public CreditRisk save(CreditRisk risk) {
		return creditRiskrepository.save(risk);
	}

}
