package br.dbc.customersws.service;

import java.util.List;

import br.dbc.customersws.entity.Customer;
import br.dbc.customersws.exception.CustomerWsCustomException;
import br.dbc.customersws.to.NewCustomerTo;

/**
 * @author Wesley Felipe
 */
public interface ICustomerService {
	
	public void insert(NewCustomerTo customerTo) throws CustomerWsCustomException;
	
	public List<Customer> findAll();

}
