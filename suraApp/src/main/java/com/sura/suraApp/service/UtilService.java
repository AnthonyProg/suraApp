package com.sura.suraApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sura.suraApp.dao.CurrencyRepository;
import com.sura.suraApp.dao.LanguageRepository;
import com.sura.suraApp.dao.PropertyTypeRepository;
import com.sura.suraApp.entities.Currency;
import com.sura.suraApp.entities.Language;
import com.sura.suraApp.entities.PropertyType;

@Service
public class UtilService implements IUtilService {

	@Autowired
	LanguageRepository languageRepository;
	
	@Autowired
	CurrencyRepository currencyRepository;
	
	@Autowired
	PropertyTypeRepository propertyTypeRepository;
	
	@Override
	public List<Language> getLanguages() throws Exception{
		try {
			return languageRepository.findAll();
		} catch (Exception e){
            throw new Exception("Error querying languages");
        }
		
	}

	@Override
	public List<PropertyType> getPropertyTypes() throws Exception{
		try {
			return propertyTypeRepository.findAll();
		} catch (Exception e) {
			throw new Exception("Error querying property types");
		}
	}

	@Override
	public List<Currency> getCurrencies() throws Exception{
		try {
			return currencyRepository.findAll();
		} catch (Exception e) {
			throw new Exception("Error querying currencies");
		}
	}

	 
	
}
