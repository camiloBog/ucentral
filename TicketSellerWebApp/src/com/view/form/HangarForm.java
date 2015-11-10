package com.view.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class HangarForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private String country;
	private String city;
	private String name;
	private String iata;

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {	

		ActionErrors actionErrors = new ActionErrors();

		if (country == null || country.trim().equals(""))
			actionErrors.add("country", new ActionMessage("error.country"));
		
		if (city == null || city.trim().equals("")) 
			actionErrors.add("city", new ActionMessage("error.city"));
		
		if (name == null || name.trim().equals(""))
			actionErrors.add("name", new ActionMessage("error.name"));
		
		if (iata == null || iata.trim().equals("")) 
			actionErrors.add("iata", new ActionMessage("error.iata"));
		
		return actionErrors;

	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIata() {
		return iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	
	
	
}
