package br.dbc.customersws.to;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.dbc.customersws.to.NewCustomerTo;

@RunWith(SpringJUnit4ClassRunner.class)
public class NewCustomerToTest {

	static Validator validator;

	@BeforeClass
	public static void initClass() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void newCustomerToIsValid() {

		NewCustomerTo customer = new NewCustomerTo();
		customer.setCreditLimit(new BigDecimal(10));
		customer.setCreditRiskCode("A");
		customer.setName("João Silva");

		Set<ConstraintViolation<NewCustomerTo>> constraintViolations = validator.validate(customer);

		assertEquals(0, constraintViolations.size());
	}
	
	@Test
	public void newCustomerToInvalidName() {

		NewCustomerTo customer = new NewCustomerTo();
		customer.setCreditLimit(new BigDecimal(10));
		customer.setCreditRiskCode("A");
		customer.setName("João");

		Set<ConstraintViolation<NewCustomerTo>> constraintViolations = validator.validate(customer);

		assertEquals(1, constraintViolations.size());
	}
	
	@Test
	public void newCustomerToNameNull() {

		NewCustomerTo customer = new NewCustomerTo();
		customer.setCreditLimit(new BigDecimal(10));
		customer.setCreditRiskCode("A");
		customer.setName(null);

		Set<ConstraintViolation<NewCustomerTo>> constraintViolations = validator.validate(customer);

		assertEquals(1, constraintViolations.size());
	}
	
	@Test
	public void newCustomerToCreditRiskCodeNull() {

		NewCustomerTo customer = new NewCustomerTo();
		customer.setCreditLimit(new BigDecimal(10));
		customer.setCreditRiskCode(null);
		customer.setName("João Silva");

		Set<ConstraintViolation<NewCustomerTo>> constraintViolations = validator.validate(customer);

		assertEquals(1, constraintViolations.size());
	}
	
	@Test
	public void newCustomerToCreditLimitNull() {

		NewCustomerTo customer = new NewCustomerTo();
		customer.setCreditLimit(null);
		customer.setCreditRiskCode("A");
		customer.setName("João Silva");

		Set<ConstraintViolation<NewCustomerTo>> constraintViolations = validator.validate(customer);

		assertEquals(1, constraintViolations.size());
	}
	
	@Test
	public void newCustomerToCreditLimitNegative() {

		NewCustomerTo customer = new NewCustomerTo();
		customer.setCreditLimit(new BigDecimal(-1));
		customer.setCreditRiskCode("A");
		customer.setName("João Silva");

		Set<ConstraintViolation<NewCustomerTo>> constraintViolations = validator.validate(customer);

		assertEquals(1, constraintViolations.size());
	}

}
