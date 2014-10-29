package jsonConverter;

import java.util.ArrayList;
import java.util.List;


import Juego.Juego;
import pais.Pais;
import persona.Villano;

public class GenerarCasoJson {
	
	String descripcion;
	String paisActual;
	List<String>nombresDeVillanos;
	List<String>nombresDePaises;
	
	
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setCaso(String caso) {
		this.descripcion = caso;
	}
	public String getPaisActual() {
		return paisActual;
	}
	public void setPaisActual(String string) {
		this.paisActual = string;
	}
	public List<String> getNombresDeVillanos() {
		return nombresDeVillanos;
	}
	public void setNombresDeVillanos(List<String> nombresDeVillanos) {
		this.nombresDeVillanos = nombresDeVillanos;
	}
	public List<String> getNombresDePaises() {
		return nombresDePaises;
	}
	public void setNombresDePaises(List<String> nombresDePaises) {
		this.nombresDePaises = nombresDePaises;
	}
	
	public GenerarCasoJson(Juego j){
		this.setCaso(j.getCasoSeleccionado().getDescripcion());
		this.setNombresDePaises(this.paisesToString(j.getPaisActual().getConexiones()));
		this.setNombresDeVillanos(this.villanosToString(j.getVillanos()));
		this.setPaisActual(j.getPaisActual().getNombre());
	}
	
	private List<String> villanosToString(List<Villano> villanos) {
		List<String>r = new ArrayList<String>();
		for(Villano v : villanos){
			r.add(v.getNombre());
		}
		return r;
	}
	private List<String>paisesToString(List<Pais>paises){
		List<String> r = new ArrayList<String>();
		for (Pais p : paises){
			r.add(p.getNombre());
		}
		return r;
	}
	
	
	private GenerarCasoJson() {
	}
	

}
