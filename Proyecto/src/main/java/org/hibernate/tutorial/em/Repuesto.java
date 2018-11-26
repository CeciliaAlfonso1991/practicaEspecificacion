package org.hibernate.tutorial.em;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Repuesto {
	@Id
	private long id;
	private String nombre;
	long version;
	private String marca;
	private String especificacion;
	private byte[] foto;
	private Double precio;
	@Column(name="datos_remito")
	private String datosRemito;
	@Column(name="costo_de_fabrica")
	private Double costoDeFabrica;
	private Integer stock;
	@JoinColumn(name = "categoria_id")
	@ManyToOne
	private Categoria categoria;
	
	public Repuesto(){	
	}
	
	public Repuesto(long id,String nombre,String marca,String especificacion,byte[] foto,
		Double precio,String datosremito,Double costodefabrica,Integer stock,Categoria categoria)
	{
		if(nombre.equals("") || marca.equals("")) {
			throw new IllegalArgumentException("Nombre vacío no válido");
		}
		if(precio <0 || costoDeFabrica<0 || stock < 0) {
			throw new IllegalArgumentException("Ingrese un número mayor o igual que 0");
		}
		this.id=id;
		this.nombre=nombre;
		this.marca=marca;
		this.especificacion=especificacion;
		this.foto=foto;
		this.precio=precio;
		this.datosRemito=datosremito;
		this.costoDeFabrica=costodefabrica;
		this.stock=stock;		
		this.categoria=categoria;
	}
	
	public long getCodigo() {
		return id;
	}
	
	public void setCodigo(long codigo) {
		
		id = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		if(nombre.equals("")) {
			throw new IllegalArgumentException("Nombre vacío no válido");
		}
		this.nombre = nombre;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		if(marca.equals("")) {
			throw new IllegalArgumentException("Nombre vacío no válido");
		}
		this.marca = marca;
	}
	
	public String getEspecificacion() {
		return especificacion;
	}
	
	public void setEspecificacion(String especificacion) {
		this.especificacion = especificacion;
	}
	
	public byte[] getFoto() {
		return foto;
	}
	
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	public Double getPrecio() {
		return precio;
	}
	
	public void setPrecio(Double precio) {
		if(precio <0) {
			throw new IllegalArgumentException("Ingrese un número mayor o igual que 0");
		}
		this.precio = precio;
	}
	
	public String getDatosRemito() {
		return datosRemito;
	}
	
	public void setDatosRemito(String datosRemito) {
		this.datosRemito = datosRemito;
	}
	
	public Double getCostoDeFabrica() {
		return costoDeFabrica;
	}
	
	public void setCostoDeFabrica(Double costoDeFabrica) {
		if(costoDeFabrica<0) {
			throw new IllegalArgumentException("Ingrese un número mayor o igual que 0");
		}
		this.costoDeFabrica = costoDeFabrica;
	}
	
	public Integer getStock() {
		return stock;
	}
	
	public void setStock(Integer stock) {
		if(stock < 0) {
			throw new IllegalArgumentException("Ingrese un número mayor o igual que 0");
		}
		this.stock = stock;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	

}