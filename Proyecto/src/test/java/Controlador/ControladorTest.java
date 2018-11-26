package Controlador;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.tutorial.em.Categoria;
import org.hibernate.tutorial.em.Repuesto;
import org.junit.Assert;
import org.junit.Test;

public class ControladorTest {

	private static EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
	
	@Test
	public void testAgregarCategoria() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Controlador controlador = new Controlador();
		controlador.agregarCategoria("nuevo", 1, true);
		Categoria auxiliar = new Categoria();
		
		List<Categoria> result = entityManager.createQuery( "from Categoria", Categoria.class ).getResultList();
		for ( Categoria categoria : result) {
			if(categoria.getNombre().equals("nuevo")) {
				auxiliar= categoria;
			}
		}
		Assert.assertEquals("nuevo", auxiliar.getNombre());
	}

	@Test
	public void testAgregarRepuesto() {
		fail("Not yet implemented");
	}

	@Test
	public void testLLenarJComboBoxRepuestos() {
		fail("Not yet implemented");
	}

	@Test
	public void testLLenarJComboBoxStockBajo() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultarStock() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultarEspecificacion() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultarMarca() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultarDatosRemito() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultarPrecios() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminarCategoria() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminarRepuesto() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditarCategoria() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditarNombreRepuesto() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditarMarcaRepuesto() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditarEspecificacionRepuesto() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditarPrecioRepuesto() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditarPrecioFabricaRepuesto() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditarDatosRemitoRepuesto() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditarStockRepuesto() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditarCategoriaRepuesto() {
		fail("Not yet implemented");
	}

	@Test
	public void testAgregarHijoYpadre() {
		fail("Not yet implemented");
	}

	@Test
	public void testLLenarJComboBoxCategoriaPadre() {
		fail("Not yet implemented");
	}

	@Test
	public void testLLenarJComboBoxCategoriaHijo() {
		fail("Not yet implemented");
	}

}
