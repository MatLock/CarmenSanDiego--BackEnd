package jsonConverter;

public class ObtenerPistaJsonRequest {
	
	String pais;
	String lugar;
	
	

	
	
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}



    public ObtenerPistaJsonRequest(){
    	
    }

	public ObtenerPistaJsonRequest(String pais, String lugar) {
		this.pais = pais;
		this.lugar = lugar;
	}
	
	
	
	

}
