package jsonConverter;

import java.util.ArrayList;
import java.util.List;

import pais.Pais;

public class ViajarJsonResponse {
	
	String paisActual;
	List<String>nombresDePaises;
	public String getPaisActual() {
		return paisActual;
	}
	public void setPaisActual(String paisActual) {
		this.paisActual = paisActual;
	}
	public List<String> getNombresDePaises() {
		return nombresDePaises;
	}
	public void setNombresDePaises(List<String> nombresDepaises) {
		this.nombresDePaises = nombresDepaises;
	}
	
	
	public ViajarJsonResponse(){
		
	}
	
	public ViajarJsonResponse(String paisActual,List<Pais>paises){
		this.setPaisActual(paisActual);
		this.setNombresDePaises(paisesToString(paises));
	}
	
	
	private List<String> paisesToString(List<Pais>paises){
		List<String> result = new ArrayList<String>();
		for (Pais p : paises){
			result.add(p.getNombre());
		}
		return result;
	}
	
	
	

}
