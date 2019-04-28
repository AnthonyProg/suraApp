package com.sura.suraApp.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sura.suraApp.entities.Currency;
import com.sura.suraApp.entities.Language;
import com.sura.suraApp.entities.PropertyType;
import com.sura.suraApp.service.IUtilService;


@RestController
@RequestMapping("/GlobalUtil")
public class UtilApi {

	@Autowired
	IUtilService utilService;
	
	@RequestMapping(value = "/languages", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Language>> getLanguages() throws Exception {
		
		List<Language> lenguajes = utilService.getLanguages();
		
		if (   null == lenguajes
			|| lenguajes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Language>>(lenguajes, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/propertyTypes", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<PropertyType>> getPropertyTypes() throws Exception {
		
		List<PropertyType> tiposPropiedad = utilService.getPropertyTypes();
		
		if (   null == tiposPropiedad
			|| tiposPropiedad.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<PropertyType>>(tiposPropiedad, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/currencies", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Currency>> getCurrencies() throws Exception {
		
		List<Currency> monedas = utilService.getCurrencies();
		
		if (   null == monedas
			|| monedas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Currency>>(monedas, HttpStatus.OK);
		
	}
	
}
