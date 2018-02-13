package br.dbc.customersws.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.dbc.customersws.entity.Customer;
import br.dbc.customersws.exception.CustomerWsCustomException;
import br.dbc.customersws.service.ICustomerService;
import br.dbc.customersws.to.NewCustomerTo;

/**
 * @author Wesley Felipe
 */

@RestController
@CrossOrigin
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@RequestMapping(method = RequestMethod.POST)
	public void insertNew(@Valid @RequestBody NewCustomerTo customer) throws CustomerWsCustomException {

		customerService.insert(customer);

	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Customer> findAll() {

		return customerService.findAll();

	}

}
