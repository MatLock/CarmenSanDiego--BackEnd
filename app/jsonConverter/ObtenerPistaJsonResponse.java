package jsonConverter;

import java.util.ArrayList;
import java.util.List;

import Juego.Juego;
import pais.Pais;

public class ObtenerPistaJsonResponse {
	
	String descripcion;
	List<String>paisesFallidos;
	
	
	
		
	public List<String> getPaisesFallidos() {
		return paisesFallidos;
	}
	public void setPaisesFallidos(List<String> paisesFallidos) {
		this.paisesFallidos = paisesFallidos;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	public ObtenerPistaJsonResponse(){
		
	}
	
	public ObtenerPistaJsonResponse(Juego j){
		this.setDescripcion(j.getDescripcionDeLaPista());
		this.setPaisesFallidos(paisesToString(j.getPaisesFallidos()));		
	}
	
	private List<String> paisesToString(List<Pais>paises){
		List<String>result = new ArrayList<String>();
		for(Pais p : paises){
			result.add(p.getNombre());
		}
		return result;
	}
	
	
	
	
	

}
