package com.ipartek.modelo.dto;

public class Estilo {
	
	private int id;
	private String estilo;
	
	public Estilo(int id, String estilo) {
		super();
		this.id = id;
		this.estilo = estilo;
	}
	
	public Estilo() {
		super();
		this.id = 0;
		this.estilo = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	@Override
	public String toString() {
		return "Estilo [id=" + id + ", estilo=" + estilo + "]";
	}
	
	
	

}
