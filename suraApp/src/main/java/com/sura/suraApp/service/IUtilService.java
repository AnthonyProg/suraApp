package com.sura.suraApp.service;

import java.util.List;

import com.sura.suraApp.entities.Currency;
import com.sura.suraApp.entities.Language;
import com.sura.suraApp.entities.PropertyType;

public interface IUtilService {
	
	List<Language> getLanguages() throws Exception;
	
	List<PropertyType> getPropertyTypes() throws Exception;
	
	List<Currency> getCurrencies() throws Exception;
	
}
