package org.hibernate.tutorial.em;

import static org.junit.Assert.*;

import org.junit.Test;

public class CategoriaTest {

	@Test(expected = IllegalArgumentException.class)
	public void testSetNombre() {
		Categoria categoria = new Categoria("kjasdkashdk",1);
		categoria.setNombre("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetCategoria() {
		Categoria categoria = new Categoria("",1);
	}
	
}
