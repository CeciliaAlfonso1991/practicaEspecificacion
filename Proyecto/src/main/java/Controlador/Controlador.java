package Controlador;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JComboBox;


import org.hibernate.tutorial.em.Categoria;
import org.hibernate.tutorial.em.Repuesto;

public class Controlador {
	private static EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
	
	public Controlador() {
		
	}
	public Image imagen(String nombre) throws IOException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Repuesto> result = entityManager.createQuery( "from Repuesto", Repuesto.class ).getResultList();
		for ( Repuesto repuesto : result) {
			if(repuesto.getNombre().equals(nombre)) {
				ByteArrayInputStream inputStr = new ByteArrayInputStream(repuesto.getFoto());
				BufferedImage image = ImageIO.read(inputStr);
				return image;
			}
		}
		 throw new NullPointerException("Imagen no encontrada");
}
	
	public void agregarCategoria(String nombre,long id,boolean isPadre) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Categoria categoria=new Categoria(nombre,id);
		categoria.setPadre(isPadre);
		
		entityManager.persist(categoria);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}
	
	
	public void agregarRepuesto(long id,String nombre,String marca,String especificacion,byte[] foto,Double precio,String datosremito,
			Double preciofabrica,String categoria) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Categoria> result = entityManager.createQuery( "from Categoria", Categoria.class ).getResultList();
		Categoria cat=new Categoria();
			for(Categoria cate : result) {
				if(cate.getNombre().equals(categoria)) {
					cat=cate;
			}
		}
			Categoria find=entityManager.find(Categoria.class, cat.getId());
			Repuesto repuesto=new Repuesto(id,nombre,marca,especificacion,foto,precio,datosremito,preciofabrica,1,find);
			entityManager.persist(repuesto);
			
			entityManager.getTransaction().commit();
			entityManager.close();
		}
	
	public  void llenarJComboBoxRepuestos(JComboBox<String> box) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
        List<Repuesto> result = entityManager.createQuery( "from Repuesto", Repuesto.class ).getResultList();
		for ( Repuesto repuesto : result ) {
			box.addItem(repuesto.getNombre());
		}
        entityManager.getTransaction().commit();
        entityManager.close();
		}
	
	public  void llenarJComboBoxStockBajo(JComboBox<String> box) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
        List<Repuesto> result = entityManager.createQuery( "from Repuesto", Repuesto.class ).getResultList();
		for ( Repuesto repuesto : result ) {
			if(repuesto.getStock().equals(0)||repuesto.getStock().equals(1))
			box.addItem(repuesto.getNombre());
		}
        entityManager.getTransaction().commit();
        entityManager.close();
		}
	
	public int consultarStock(String nombre) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Repuesto> result = entityManager.createQuery( "from Repuesto", Repuesto.class ).getResultList();
		Repuesto rep=new Repuesto();
			for(Repuesto repuesto : result) {
				if(repuesto.getNombre().equals(nombre)) {
					rep=repuesto;
					
			}
		}
			
			entityManager.getTransaction().commit();
	        entityManager.close();
	        return rep.getStock();
			
	}
	
	public String consultarEspecificacion(String nombre) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Repuesto> result = entityManager.createQuery( "from Repuesto", Repuesto.class ).getResultList();
		Repuesto rep=new Repuesto();
			for(Repuesto repuesto : result) {
				if(repuesto.getNombre().equals(nombre)) {
					rep=repuesto;
					
			}
		}
			String especificacion=rep.getEspecificacion()+"\nCategoria: "+rep.getCategoria().getNombre();
			entityManager.getTransaction().commit();
	        entityManager.close();
	        return especificacion;
			
		
	}
	
	public String consultarMarca(String nombre) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Repuesto> result = entityManager.createQuery( "from Repuesto", Repuesto.class ).getResultList();
		Repuesto rep=new Repuesto();
			for(Repuesto repuesto : result) {
				if(repuesto.getNombre().equals(nombre)) {
					rep=repuesto;
					
			}
		}
			
			entityManager.getTransaction().commit();
	        entityManager.close();
	        return rep.getMarca();
			
	}
	
	public String consultarDatosRemito(String nombre) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Repuesto> result = entityManager.createQuery( "from Repuesto", Repuesto.class ).getResultList();
		Repuesto rep=new Repuesto();
			for(Repuesto repuesto : result) {
				if(repuesto.getNombre().equals(nombre)) {
					rep=repuesto;
					
			}
		}
			
			entityManager.getTransaction().commit();
	        entityManager.close();
	        return rep.getDatosRemito();
			
	}
	
	public String consultarPrecios(String nombre) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Repuesto> result = entityManager.createQuery( "from Repuesto", Repuesto.class ).getResultList();
		Repuesto rep=new Repuesto();
			for(Repuesto repuesto : result) {
				if(repuesto.getNombre().equals(nombre)) {
					rep=repuesto;
					
			}
		}
			String precios=+rep.getPrecio()+"\nprecio de fabrica: "+rep.getCostoDeFabrica();
			entityManager.getTransaction().commit();
	        entityManager.close();
	        return precios;
			
	}
	
	public void eliminarCategoria(String nombre) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Categoria> result = entityManager.createQuery( "from Categoria", Categoria.class ).getResultList();
		Categoria cat=new Categoria();
			for(Categoria categoria : result) {
				if(categoria.getNombre().equals(nombre)) {
					cat=categoria;
					
			}
		}
			Categoria borrar=entityManager.find(Categoria.class, cat.getId());
			entityManager.remove(borrar);
			entityManager.getTransaction().commit();
	        entityManager.close();
	}
	
	public void eliminarRepuesto(String nombre) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Repuesto> result = entityManager.createQuery( "from Repuesto", Repuesto.class ).getResultList();
		Repuesto rep=new Repuesto();
			for(Repuesto repuesto : result) {
				if(repuesto.getNombre().equals(nombre)) {
					rep=repuesto;
					
			}
		}
			Repuesto borrar=entityManager.find(Repuesto.class, rep.getCodigo());
			entityManager.remove(borrar);
			
			entityManager.getTransaction().commit();
	        entityManager.close();
	}
	
	public void editarCategoria(String categoria,String nombreNuevo) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Categoria> result = entityManager.createQuery( "from Categoria", Categoria.class ).getResultList();
		
		Categoria cat=new Categoria();
		
		for(Categoria category : result) {
			if(category.getNombre().equals(categoria)) {
				 cat=category;
			}
			
		}
		cat.setNombre(nombreNuevo);
		entityManager.getTransaction().commit();
        entityManager.close();
		
	}
	
	
	public void editarNombreRepuesto(String repuesto,String nombreNuevo) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Repuesto> result = entityManager.createQuery( "from Repuesto", Repuesto.class ).getResultList();
		
		Repuesto rep=new Repuesto();
		
		for(Repuesto repuest : result) {
			if(repuest.getNombre().equals(repuesto)) {
				 rep=repuest;
			}
			
		}
		rep.setNombre(nombreNuevo);
		entityManager.getTransaction().commit();
        entityManager.close();
	}
	
	public void editarMarcaRepuesto(String repuesto,String MarcaNueva) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Repuesto> result = entityManager.createQuery( "from Repuesto", Repuesto.class ).getResultList();
		
		Repuesto rep=new Repuesto();
		
		for(Repuesto repuest : result) {
			if(repuest.getNombre().equals(repuesto)) {
				 rep=repuest;
			}
			
		}
		rep.setMarca(MarcaNueva);
		entityManager.getTransaction().commit();
        entityManager.close();
	}
	
	public void editarEspecificacionRepuesto(String repuesto,String EspecificacionNueva) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Repuesto> result = entityManager.createQuery( "from Repuesto", Repuesto.class ).getResultList();
		
		Repuesto rep=new Repuesto();
		
		for(Repuesto repuest : result) {
			if(repuest.getNombre().equals(repuesto)) {
				 rep=repuest;
			}
			
		}
		rep.setEspecificacion(EspecificacionNueva);
		entityManager.getTransaction().commit();
        entityManager.close();
	}
	
	public void editarPrecioRepuesto(String repuesto,Double PrecioNuevo) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Repuesto> result = entityManager.createQuery( "from Repuesto", Repuesto.class ).getResultList();
		
		Repuesto rep=new Repuesto();
		
		for(Repuesto repuest : result) {
			if(repuest.getNombre().equals(repuesto)) {
				 rep=repuest;
			}
			
		}
		rep.setPrecio(PrecioNuevo);
		entityManager.getTransaction().commit();
        entityManager.close();
	}
	
	public void editarPrecioFabricaRepuesto(String repuesto,Double PrecioFabricaNuevo) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Repuesto> result = entityManager.createQuery( "from Repuesto", Repuesto.class ).getResultList();
		
		Repuesto rep=new Repuesto();
		
		for(Repuesto repuest : result) {
			if(repuest.getNombre().equals(repuesto)) {
				 rep=repuest;
			}
			
		}
		rep.setCostoDeFabrica(PrecioFabricaNuevo);
		entityManager.getTransaction().commit();
        entityManager.close();
	}
	
	public void editarDatosRemitoRepuesto(String repuesto,String DatosRemito) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Repuesto> result = entityManager.createQuery( "from Repuesto", Repuesto.class ).getResultList();
		
		Repuesto rep=new Repuesto();
		
		for(Repuesto repuest : result) {
			if(repuest.getNombre().equals(repuesto)) {
				 rep=repuest;
			}
			
		}
		rep.setDatosRemito(DatosRemito);
		entityManager.getTransaction().commit();
        entityManager.close();
	}
	
	public void editarStockRepuesto(String repuesto,int Stock) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Repuesto> result = entityManager.createQuery( "from Repuesto", Repuesto.class ).getResultList();
		
		Repuesto rep=new Repuesto();
		
		for(Repuesto repuest : result) {
			if(repuest.getNombre().equals(repuesto)) {
				 rep=repuest;
			}
			
		}
		rep.setStock(Stock);
		entityManager.getTransaction().commit();
        entityManager.close();
	}
	
	public void editarCategoriaRepuesto(String repuesto,String categoriaNueva) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Repuesto> result = entityManager.createQuery( "from Repuesto", Repuesto.class ).getResultList();
		
		Repuesto rep=new Repuesto();
		
		for(Repuesto repuest : result) {
			if(repuest.getNombre().equals(repuesto)) {
				 rep=repuest;
			}
			
		}
		
		List<Categoria> resulta = entityManager.createQuery( "from Categoria", Categoria.class ).getResultList();
		
		Categoria cat=new Categoria();
		
		for(Categoria categ : resulta) {
			if(categ.getNombre().equals(categoriaNueva)) {
				 cat=categ;
			}
			
		}
		
		rep.setCategoria(cat);
		entityManager.getTransaction().commit();
        entityManager.close();
	}
	
	public void agregarHijoYpadre(String hijo,String padre) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		
		List<Categoria> categorias = entityManager.createQuery( "from Categoria", Categoria.class ).getResultList();
		
		Categoria catHijo=new Categoria();
		Categoria catPadre=new Categoria();
		for(Categoria subs : categorias) {
			if(subs.getNombre().equals(hijo)) {
				 catHijo=subs;
			}
		}
			for(Categoria cats : categorias) {
				if(cats.getNombre().equals(padre)) {
					 catPadre=cats;
				}
			}
			catHijo.setPadre(catPadre);
			catPadre.subcategorias.add(catHijo);
		
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

	public void llenarJComboBoxCategoriaPadre(JComboBox<String> comboBox) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
        List<Categoria> result = entityManager.createQuery( "from Categoria", Categoria.class ).getResultList();
		for ( Categoria categoria : result ) {
			if(categoria.isPadre()==true) {
				comboBox.addItem(categoria.getNombre());
		}
		}
        entityManager.getTransaction().commit();
        entityManager.close();
		
	}
	
	public void llenarJComboBoxCategoriaHijo(JComboBox<String> comboBox) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
        List<Categoria> result = entityManager.createQuery( "from Categoria", Categoria.class ).getResultList();
		for ( Categoria categoria : result ) {
			if(categoria.isPadre()==false) {
				comboBox.addItem(categoria.getNombre());
		}
		}
        entityManager.getTransaction().commit();
        entityManager.close();
		
	}
	
	
	
	
	

}

