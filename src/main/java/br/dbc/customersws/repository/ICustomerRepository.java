package br.dbc.customersws.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import br.dbc.customersws.entity.Customer;

/**
 * @author Wesley Felipe
 */
@Component
public interface ICustomerRepository extends MongoRepository<Customer, String>{

}
