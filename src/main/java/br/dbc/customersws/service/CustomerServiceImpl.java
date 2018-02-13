package br.dbc.customersws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.dbc.customersws.entity.CreditRisk;
import br.dbc.customersws.entity.Customer;
import br.dbc.customersws.entity.CustomerCredit;
import br.dbc.customersws.exception.CreditRiskNotFoundException;
import br.dbc.customersws.repository.ICreditRiskRepository;
import br.dbc.customersws.repository.ICustomerRepository;
import br.dbc.customersws.to.NewCustomerTo;

/**
 * @author Wesley Felipe
 */
@Component
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	@Autowired
	private ICreditRiskRepository creditRiskRepository;

	public void insert(NewCustomerTo customerTo) throws CreditRiskNotFoundException {

		customerRepository.save(buildCustomer(customerTo));

	}
	
	public List<Customer> findAll(){
		
		return customerRepository.findAll();
		
	}

	protected Customer buildCustomer(NewCustomerTo customerTo) throws CreditRiskNotFoundException {

		Customer customer = new Customer();
		customer.setName(customerTo.getName());
		customer.setCredit(buildCredit(customerTo));
		return customer;

	}

	protected CustomerCredit buildCredit(NewCustomerTo customerTo) throws CreditRiskNotFoundException {

		CreditRisk risk = creditRiskRepository.findByCode(customerTo.getCreditRiskCode());
		if (risk == null) {
			throw new CreditRiskNotFoundException();
		}

		return buildCredit(customerTo, risk);
	}

	protected CustomerCredit buildCredit(NewCustomerTo customerTo, CreditRisk risk) {
		CustomerCredit credit = new CustomerCredit();
		credit.setRisk(risk);
		credit.setCreditLimit(customerTo.getCreditLimit());
		return credit;
	}

}
