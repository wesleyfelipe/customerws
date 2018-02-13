package br.dbc.customersws.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.dbc.customersws.entity.CreditRisk;
import br.dbc.customersws.service.ICreditRiskService;

/**
 * @author Wesley Felipe
 */

@RestController
@CrossOrigin
@RequestMapping(value = "/credit-risk")
public class CreditRiskController {

	@Autowired
	private ICreditRiskService creditRiskService;

	@RequestMapping(method = RequestMethod.GET)
	public List<CreditRisk> get() {

		return creditRiskService.findAll();

	}

	@RequestMapping(method = RequestMethod.POST)
	public void post(@Valid @RequestBody CreditRisk risk) {

		creditRiskService.save(risk);

	}

}
