package com.ipartek.modelo.dto;

public class Disco {
	
	private int id;
	private String titulo;
	private int numCanciones;
	private double precio;
	private int fk_estilo;
	
	public Disco(int id, String titulo, int numCanciones, double precio, int fk_estilo) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.numCanciones = numCanciones;
		this.precio = precio;
		this.fk_estilo = fk_estilo;
	}
	
	public Disco() {
		super();
		this.id = 0;
		this.titulo = "";
		this.numCanciones = 0;
		this.precio = 0.0;
		this.fk_estilo = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumCanciones() {
		return numCanciones;
	}

	public void setNumCanciones(int numCanciones) {
		this.numCanciones = numCanciones;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getFk_estilo() {
		return fk_estilo;
	}

	public void setFk_estilo(int fk_estilo) {
		this.fk_estilo = fk_estilo;
	}

	@Override
	public String toString() {
		return "Disco [id=" + id + ", titulo=" + titulo + ", numCanciones=" + numCanciones + ", precio=" + precio
				+ ", fk_estilo=" + fk_estilo + "]";
	}
	
	
	

}
