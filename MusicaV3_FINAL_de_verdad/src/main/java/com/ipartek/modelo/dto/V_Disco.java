package com.ipartek.modelo.dto;

public class V_Disco extends Disco {

	private String estilo;

	public V_Disco(int id, String titulo, int numCanciones, double precio, int fk_estilo, String estilo) {
		super(id, titulo, numCanciones, precio, fk_estilo);
		this.estilo = estilo;
	}
	
	public V_Disco() {
		super();
		this.estilo = "";
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	@Override
	public String toString() {
		return "V_Disco [estilo=" + estilo + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
