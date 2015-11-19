package com.view.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.model.ContextLoader;
import com.model.ejb.CiudadEjbRemote;
import com.model.ejb.PaisEjbRemote;
import com.model.entities.Ciudad;
import com.model.entities.Pais;

public class HangarForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private String country;
	private String city;
	private String name;
	private String iata;
	
	private String paises;
	private List<Object> paisesLista = new ArrayList<Object>();
	
	private PaisEjbRemote paisService = 
			(PaisEjbRemote) ContextLoader.getContext("PaisEjb");
	
	private String ciudades;
	private List<Object> ciudadesLista = new ArrayList<Object>();
	
	private CiudadEjbRemote ciudadService = 
			(CiudadEjbRemote) ContextLoader.getContext("CiudadEjb");
	
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

	public String getPaises() {
		return paises;
	}

	public void setPaises(String paises) {
		this.paises = paises;
	}
	
	public String getCiudades() {
		return ciudades;
	}

	public void setCiudades(String ciudades) {
		this.ciudades = ciudades;
	}

	public List<Object> getPaisesLista() {
		paisesLista = paisService.FindAll(new Pais());
		return paisesLista;
	}

	public void setPaisesLista(List<Object> paisesLista) {
		this.paisesLista = paisesLista;
	}

	public List<Object> getCiudadesLista() {
		//225
		ciudadesLista = ciudadService.findByCountryId(new Long("225"));
		return ciudadesLista;
	}

	public void setCiudadesLista(List<Object> ciudadesLista) {
		this.ciudadesLista = ciudadesLista;
	}

	
	
}
