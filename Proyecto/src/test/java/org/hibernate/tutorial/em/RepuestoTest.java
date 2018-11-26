package org.hibernate.tutorial.em;

import static org.junit.Assert.*;
import org.junit.Test;

public class RepuestoTest {

	@Test(expected = IllegalArgumentException.class)
	public void testSetNombre() {
		Repuesto repuesto = new Repuesto();
		repuesto.setNombre("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetMarca() {
		Repuesto repuesto = new Repuesto();
		repuesto.setMarca("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetPrecio() {
		Repuesto repuesto = new Repuesto();
		repuesto.setPrecio(-0.000001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetCostoDeFabrica() {
		Repuesto repuesto = new Repuesto();
		repuesto.setCostoDeFabrica(-0.000001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetStock() {
		Repuesto repuesto = new Repuesto();
		repuesto.setStock(-1);
	}
	
	//Test con ingresos correctos
	
	@Test
	public void testSetCategoria() {
		Repuesto repuesto = new Repuesto();
		Categoria categoria = new Categoria("nombre",0);
		repuesto.setCategoria(categoria);
	}
	
	@Test
	public void testSetNombreValido() {
		Repuesto repuesto = new Repuesto();
		repuesto.setNombre("asasas");
	}

	@Test
	public void testSetMarcaValido() {
		Repuesto repuesto = new Repuesto();
		repuesto.setMarca("asdasda");
	}

	@Test
	public void testSetPrecioValido() {
		Repuesto repuesto = new Repuesto();
		repuesto.setPrecio(0.000001);
	}

	@Test
	public void testSetCostoDeFabricaValido() {
		Repuesto repuesto = new Repuesto();
		repuesto.setCostoDeFabrica(0.000001);
	}

	@Test
	public void testSetStockValido() {
		Repuesto repuesto = new Repuesto();
		repuesto.setStock(1);
	}
}
