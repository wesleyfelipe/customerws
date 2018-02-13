package br.dbc.customersws.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import br.dbc.customersws.entity.CreditRisk;

/**
 * @author Wesley Felipe
 */
public interface ICreditRiskRepository extends MongoRepository<CreditRisk, String> {
	
	public CreditRisk findByCode(@Param("code") String code);
	
}
