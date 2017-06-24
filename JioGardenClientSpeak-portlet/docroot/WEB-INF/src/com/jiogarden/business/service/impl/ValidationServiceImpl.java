package com.jiogarden.business.service.impl;

import com.jiogarden.business.service.ValidationService;
import com.jiogarden.model.ClientSpeak;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

public class ValidationServiceImpl implements ValidationService {

	@Override
	public boolean validateClientSpeak(ClientSpeak clientSpeak,
			List<String> errors) {
		boolean valid = true;

		if (Validator.isNull(clientSpeak.getClientName())) {
			errors.add("client-name-required");
			valid = false;
		}

		if (Validator.isNull(clientSpeak.getClientDesignation())) {
			errors.add("client-designation-required");
			valid = false;
		}

		if (Validator.isNull(clientSpeak.getClientSpeak())) {
			errors.add("client-speak-required");
			valid = false;
		}

		return valid;
	}

}
