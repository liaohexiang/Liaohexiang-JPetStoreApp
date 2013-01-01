package org.springframework.samples.jpetstore.validators;

import org.springframework.samples.jpetstore.domain.Account;
import org.springframework.validation.BindingResult;

public class AccountValidator {

	public void validate(Account account, BindingResult bindResult){
		
		bindResult.rejectValue("username", null, "user name should be correct");
	}
}
