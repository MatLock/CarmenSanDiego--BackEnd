package controllers;

import org.codehaus.jackson.JsonNode;

import jsonConverter.GenerarCasoJson;
import jsonConverter.ObtenerPistaJsonRequest;
import jsonConverter.ObtenerPistaJsonResponse;
import jsonConverter.ViajarJsonRequest;
import jsonConverter.ViajarJsonResponse;
import pais.Lugar;
import pais.Pais;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import Juego.Juego;

public class Application extends Controller {
  
	 private static Juego j = new Juego();
	 

    public static Result getCaso(){
    	GenerarCasoJson response = new GenerarCasoJson(j);
    	return ok(Json.toJson(response));
    }
    
    public static Result visitarLugar(){
    	JsonNode node = request().body().asJson();
		ObtenerPistaJsonRequest request = Json.fromJson(node, ObtenerPistaJsonRequest.class);
		j.visitarLugar(request.getPais().trim(),request.getLugar().trim());
		ObtenerPistaJsonResponse  response = new ObtenerPistaJsonResponse(j);
		return ok(Json.toJson(response));
    	
    }
    
    public static Result emitirOrdenPara(String nombre){
    	j.setVillano(j.buscarVillano(nombre.trim()));
    	return ok("Se ha emitido una orden contra: "+nombre);
    }
    
    
    public static Result viajar(){
    	JsonNode node = request().body().asJson();
    	ViajarJsonRequest request = Json.fromJson(node, ViajarJsonRequest.class);
    	Pais p = j.buscarPais(request.getDestino().trim());
    	j.setPaisActual(p);
    	ViajarJsonResponse response = new ViajarJsonResponse(p.getNombre(),p.getConexiones());
    	return ok (Json.toJson(response));    	
    }
   
 
  
}

