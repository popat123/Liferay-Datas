package com.jiogarden.business.service;

import com.jiogarden.model.ClientSpeak;

import java.util.List;

public interface ValidationService {

	boolean validateClientSpeak(ClientSpeak clientSpeak, List<String> errors);

}
