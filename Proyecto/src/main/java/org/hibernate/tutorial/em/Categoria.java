package org.hibernate.tutorial.em;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Categoria {
	@Id
	private long id;
	long version;
	String nombre;
	@Column(name="is_Padre")
	boolean isPadre=true;
	@OneToMany(mappedBy = "padre", cascade = CascadeType.ALL,
			orphanRemoval = true)
	public List<Categoria> subcategorias=new ArrayList<Categoria>();
	
	@JoinColumn(name = "padre_id")
	@ManyToOne
	Categoria padre;
	public Categoria() {
		
	}
	public Categoria(String nombre,long id) {
		if(nombre.equals("")) {
			throw new IllegalArgumentException("No se permite un nombre de Categoría vacío, ingrese un nombre válido");
		}
		this.nombre=nombre;
		this.id=id;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre.equals("")) {
			throw new IllegalArgumentException("No se permite un nombre vacío, ingrese un nombre válido");
		}
		this.nombre = nombre;
	}
	public boolean isPadre() {
		return isPadre;
	}
	public void setPadre(boolean isPadre) {
		this.isPadre = isPadre;
	}
	
	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}
	public Categoria getPadre() {
		return padre;
	}
	public void setPadre(Categoria padre) {
		this.padre = padre;
	}
	
}
