package Vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controlador.Controlador;

public class Vista {

	private JFrame Pantalla;
	private Controlador controlador=new Controlador();
	public byte[] bytesImg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = new Vista();
					window.Pantalla.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Vista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Pantalla = new JFrame();
		Pantalla.getContentPane().setBackground(Color.RED);
		
		
		Pantalla.setBounds(100, 100, 700, 500);
		Pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Pantalla.getContentPane().setLayout(null);
		
		JLabel lblAsdsa = new JLabel("CONTROLADOR DE REPUESTOS");
		lblAsdsa.setFont(new Font("Traditional Arabic", Font.PLAIN, 40));
		lblAsdsa.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsdsa.setBounds(10, 0, 652, 39);
		lblAsdsa.setForeground(Color.GREEN);
		Pantalla.getContentPane().add(lblAsdsa);
		
		JButton btnAgregarCategoria = new JButton("AGREGAR CATEGORIA");
		btnAgregarCategoria.setBackground(Color.WHITE);
		btnAgregarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla.setVisible(false);
				 final JFrame frame;
				 final JTextField textField;
				 final JTextField textField_1;
				 final JTextField textField_2;
				 final JTextField textFieldD; 
				 frame = new JFrame();
				
					frame.getContentPane().setBackground(Color.ORANGE);
					frame.setBounds(100, 100, 491, 270);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.getContentPane().setLayout(null);
					frame.setVisible(true);
					
					JLabel lblNuevaCategoria = new JLabel("CATEGORIAS");
					lblNuevaCategoria.setFont(new Font("Tahoma", Font.PLAIN, 19));
					lblNuevaCategoria.setHorizontalAlignment(SwingConstants.CENTER);
					lblNuevaCategoria.setBounds(0, 2, 444, 25);
					frame.getContentPane().add(lblNuevaCategoria);
					
					JLabel lblNombre = new JLabel("Nombre");
					
					lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblNombre.setBounds(10, 93, 92, 31);
					frame.getContentPane().add(lblNombre);
					
					textField = new JTextField();
					textField.setBounds(10, 135, 86, 20);
					frame.getContentPane().add(textField);
					textField.setColumns(10);
					
					JButton btnConfirmar = new JButton("CONFIRMAR");
					btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 17));
					btnConfirmar.setBounds(14, 195, 168, 23);
					frame.getContentPane().add(btnConfirmar);
					
					textField_1 = new JTextField();
					textField_1.setBounds(134, 135, 57, 20);
					frame.getContentPane().add(textField_1);
					textField_1.setColumns(10);
					
					JLabel lblNumeroId = new JLabel("Numero ID");
					
					lblNumeroId.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblNumeroId.setBounds(106, 99, 125, 19);
					frame.getContentPane().add(lblNumeroId);
					
					JLabel lblNuevaCategoriaPadre = new JLabel("Nueva Categoria");
					lblNuevaCategoriaPadre.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblNuevaCategoriaPadre.setBounds(14, 53, 177, 25);
					frame.getContentPane().add(lblNuevaCategoriaPadre);
					
					JLabel lblNuevaSubcategoria = new JLabel("Nueva Subcategoria");
					lblNuevaSubcategoria.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblNuevaSubcategoria.setBounds(284, 54, 206, 23);
					frame.getContentPane().add(lblNuevaSubcategoria);
					
					JLabel lblNombre_1 = new JLabel("Nombre");
					
					lblNombre_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblNombre_1.setBounds(257, 95, 102, 26);
					frame.getContentPane().add(lblNombre_1);
					
					textFieldD = new JTextField();
					textFieldD.setBounds(246, 135, 121, 20);
					frame.getContentPane().add(textFieldD);
					textFieldD.setColumns(10);
					
					JLabel lblNumeroId_1 = new JLabel("Numero ID");
					
					lblNumeroId_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblNumeroId_1.setBounds(365, 96, 125, 25);
					frame.getContentPane().add(lblNumeroId_1);
					
					textField_2 = new JTextField();
					textField_2.setBounds(414, 135, 51, 20);
					frame.getContentPane().add(textField_2);
					textField_2.setColumns(10);
					
					JButton btnConfirmar_1 = new JButton("CONFIRMAR");
					btnConfirmar_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
					btnConfirmar_1.setBounds(313, 196, 131, 23);
					frame.getContentPane().add(btnConfirmar_1);
					
					JButton btnAtras = new JButton("ATRAS");
					btnAtras.setBackground(Color.CYAN);
					btnAtras.setBounds(0, 31, 89, 23);
					frame.getContentPane().add(btnAtras);
					btnAtras.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);
						Pantalla.setVisible(true);
					}
					});
				btnConfirmar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
						Integer id=Integer.parseInt(textField_1.getText());
						controlador.agregarCategoria(textField.getText(),id,true);
						JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
						}catch(Exception ee){
							JOptionPane.showMessageDialog(null, "El id ingresado ya pertenece a otra categoria seleccione otro");
						}
					}
				});
				btnConfirmar_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
						Integer id=Integer.parseInt(textField_2.getText());
						controlador.agregarCategoria(textFieldD.getText(),id,false);
						JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
						}catch(Exception ee){
							JOptionPane.showMessageDialog(null, "El id ingresado ya pertenece a otra categoria seleccione otro");
						}
					}
				});
				
				
				
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon("C:\\Users\\Nico\\eclipse-workspace2\\Proyecto\\Imagenes\\450_1000.jpg"));
				label.setBounds(-10, 0, 544, 284);
				frame.getContentPane().add(label);
			}
		});
		btnAgregarCategoria.setFont(new Font("Traditional Arabic", Font.PLAIN, 17));
		btnAgregarCategoria.setBounds(226, 67, 247, 31);
		Pantalla.getContentPane().add(btnAgregarCategoria);
		
		JButton btnNewButtonn = new JButton("ASIGNAR HIJOS");
		btnNewButtonn.setFont(new Font("Traditional Arabic", Font.PLAIN, 17));
		btnNewButtonn.setBounds(226, 119, 247, 31);
		Pantalla.getContentPane().add(btnNewButtonn);
		btnNewButtonn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pantalla.setVisible(false);
				
				final JFrame frame = new JFrame();
				frame.getContentPane().setBackground(Color.ORANGE);
				frame.setBounds(100, 100, 482, 318);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				frame.setVisible(true);
				
				JLabel lblAsignacionDeCategorias = new JLabel("ASIGNACION DE CATEGORIAS Y SUBCATEGORIAS");
				lblAsignacionDeCategorias.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblAsignacionDeCategorias.setBounds(28, 11, 413, 33);
				frame.getContentPane().add(lblAsignacionDeCategorias);
				
				final JComboBox<String> comboBox = new JComboBox<String>();
				comboBox.setBounds(149, 110, 213, 20);
				frame.getContentPane().add(comboBox);
				controlador.llenarJComboBoxCategoriaPadre(comboBox);
				JLabel lblPadre = new JLabel("PADRE");
				lblPadre.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblPadre.setBounds(218, 66, 103, 33);
				frame.getContentPane().add(lblPadre);
				
				JLabel lblHijo = new JLabel("HIJO");
				lblHijo.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblHijo.setBounds(228, 148, 69, 33);
				frame.getContentPane().add(lblHijo);
				
				final JComboBox<String> comboBox_1 = new JComboBox<String>();
				comboBox_1.setBounds(149, 191, 213, 20);
				frame.getContentPane().add(comboBox_1);
				controlador.llenarJComboBoxCategoriaHijo(comboBox_1);
				
				JButton btnConfirmar = new JButton("CONFIRMAR");
				btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 18));
				btnConfirmar.setBounds(177, 246, 144, 23);
				frame.getContentPane().add(btnConfirmar);
				frame.setVisible(true);
				
				JButton btnAtras = new JButton("ATRAS");
				btnAtras.setBackground(Color.CYAN);
				btnAtras.setBounds(0, 41, 89, 23);
				frame.getContentPane().add(btnAtras);
				btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					Pantalla.setVisible(true);
				}
				});
				
				btnConfirmar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							
							controlador.agregarHijoYpadre(comboBox_1.getSelectedItem().toString(),comboBox.getSelectedItem().toString());
							JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
							}catch(Exception ee){
								JOptionPane.showMessageDialog(null, "La operacion no pudo concretarse");
							}
					}
				});
				JLabel lblNombre = new JLabel();
				lblNombre.setIcon(new ImageIcon("C:\\Users\\Nico\\eclipse-workspace2\\Proyecto\\Imagenes\\img_smoreno_20161206-145117_imagenes_lv_terceros_istock-519156390-kF0D-U4414810160920JG-992x558@LaVanguardia-Web (1).jpg"));
				lblNombre.setBounds(0, 0, 466, 284);
				lblNombre.setForeground(Color.GREEN);
				frame.getContentPane().add(lblNombre);
			}
		});
		
		
		JButton btnAgregarCategoria_1 = new JButton("AGREGAR REPUESTO");
		btnAgregarCategoria_1.setFont(new Font("Traditional Arabic", Font.PLAIN, 19));
		btnAgregarCategoria_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pantalla.setVisible(false);
				
				 final JTextField textField;
				 final JTextField textField_1;
				 final JTextField textField_2;
				 final JTextField textField_3;
				 final JTextField textField_4;
				 final JTextField textField_5;
				 final JTextField textField_6;
				 
				
				 	final JFrame frame = new JFrame();
					frame.getContentPane().setBackground(Color.WHITE);
					frame.setBounds(100, 100, 450, 367);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.getContentPane().setLayout(null);
					frame.setVisible(true);
					
					JLabel lblNuevaCategoria = new JLabel("NUEVO REPUESTO");
					lblNuevaCategoria.setFont(new Font("Tahoma", Font.PLAIN, 17));
					lblNuevaCategoria.setHorizontalAlignment(SwingConstants.CENTER);
					lblNuevaCategoria.setBounds(0, 0, 434, 25);
					lblNuevaCategoria.setForeground(Color.GREEN);
					frame.getContentPane().add(lblNuevaCategoria);
					
					JLabel lblNombre = new JLabel("Nombre");
					lblNombre.setBounds(10, 47, 46, 14);
					lblNombre.setForeground(Color.GREEN);
					frame.getContentPane().add(lblNombre);
					
					JLabel lblMarca = new JLabel("Marca");
					lblMarca.setBounds(10, 72, 46, 14);
					lblMarca.setForeground(Color.GREEN);
					frame.getContentPane().add(lblMarca);
					
					JLabel lblEspecificacion = new JLabel("Especificacion");
					lblEspecificacion.setBounds(10, 97, 105, 14);
					lblEspecificacion.setForeground(Color.GREEN);
					frame.getContentPane().add(lblEspecificacion);
					
					JLabel lblNewLabel_1 = new JLabel("Precio");
					lblNewLabel_1.setBounds(21, 175, 46, 14);
					lblNewLabel_1.setForeground(Color.GREEN);
					frame.getContentPane().add(lblNewLabel_1);
					
					JLabel lblDatosDeRemito = new JLabel("Datos de remito");
					lblDatosDeRemito.setBounds(21, 214, 123, 14);
					lblDatosDeRemito.setForeground(Color.GREEN);
					frame.getContentPane().add(lblDatosDeRemito);
					
					JLabel lblPrecioDeFabrica = new JLabel("Precio de fabrica");
					lblPrecioDeFabrica.setBounds(21, 257, 123, 14);
					lblPrecioDeFabrica.setForeground(Color.GREEN);
					frame.getContentPane().add(lblPrecioDeFabrica);
					
					textField = new JTextField();
					textField.setBounds(57, 44, 123, 20);
					frame.getContentPane().add(textField);
					textField.setColumns(10);
					
					textField_1 = new JTextField();
					textField_1.setBounds(57, 69, 148, 20);
					frame.getContentPane().add(textField_1);
					textField_1.setColumns(10);
					
					textField_2 = new JTextField();
					textField_2.setBounds(101, 94, 309, 20);
					frame.getContentPane().add(textField_2);
					textField_2.setColumns(10);
					
					textField_4 = new JTextField();
					textField_4.setBounds(82, 172, 123, 20);
					frame.getContentPane().add(textField_4);
					textField_4.setColumns(10);
					
					
					textField_5 = new JTextField();
					textField_5.setBounds(125, 211, 185, 20);
					frame.getContentPane().add(textField_5);
					textField_5.setColumns(10);
					
					textField_6 = new JTextField();
					textField_6.setBounds(142, 254, 179, 20);
					frame.getContentPane().add(textField_6);
					textField_6.setColumns(10);
					
					JLabel lblCategoria = new JLabel("Categoria");
					lblCategoria.setBounds(340, 178, 73, 14);
					lblCategoria.setForeground(Color.GREEN);
					frame.getContentPane().add(lblCategoria);
					
					final JComboBox<String> comboBox = new JComboBox<String>();
					comboBox.setBounds(324, 211, 100, 20);
					frame.getContentPane().add(comboBox);
					controlador.llenarJComboBoxCategoriaHijo(comboBox);
					
					
					
					JButton btnConfirmar = new JButton("CONFIRMAR");
					btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 17));
					btnConfirmar.setBounds(142, 295, 168, 23);
					frame.getContentPane().add(btnConfirmar);
					
					JButton btnSeleccionarImagen = new JButton("SELECCIONAR IMAGEN");
					btnSeleccionarImagen.setFont(new Font("Tahoma", Font.PLAIN, 16));
					btnSeleccionarImagen.setBounds(10, 135, 227, 29);
					frame.getContentPane().add(btnSeleccionarImagen);
					
					JLabel lblId = new JLabel("id");
					lblId.setForeground(Color.GREEN);
					lblId.setBackground(Color.WHITE);
					lblId.setBounds(252, 47, 29, 14);
					frame.getContentPane().add(lblId);
					
					textField_3 = new JTextField();
					textField_3.setBounds(279, 44, 86, 20);
					frame.getContentPane().add(textField_3);
					textField_3.setColumns(10);
					
			
					
					btnConfirmar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							 Double dou=Double.parseDouble(textField_4.getText());
							 Double dou2=Double.parseDouble(textField_6.getText());
							 Integer id=Integer.parseInt(textField_3.getText());
							controlador.agregarRepuesto(id,textField.getText(), textField_1.getText(), textField_2.getText(), 
									bytesImg,dou, textField_5.getText(), dou2, comboBox.getSelectedItem().toString());
							JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
							
						}
						});
					
					btnSeleccionarImagen.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JFileChooser seleccionado = new JFileChooser();
						    File archivo;
						    javax.swing.JLabel lblImagen = new javax.swing.JLabel();
							if(seleccionado.showDialog(null, "ABRIR ARCHIVO") == JFileChooser.APPROVE_OPTION){
					            archivo = seleccionado.getSelectedFile();
					            if(archivo.canRead()){
					                if(archivo.getName().endsWith("txt")){
					                    
					                }else{
					                    if(archivo.getName().endsWith("jpg")||archivo.getName().endsWith("png")||archivo.getName().endsWith("gif")){
					                    	 bytesImg =AbrirAImagen(archivo);
					                    	
					                        lblImagen.setIcon(new ImageIcon(bytesImg));
					                    }
					                }
					            }
					        }
						}
					});
					
					JButton btnAtras = new JButton("ATRAS");
					btnAtras.setBackground(Color.CYAN);
					btnAtras.setBounds(335, 16, 89, 23);
					frame.getContentPane().add(btnAtras);
					
					btnAtras.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							frame.setVisible(false);
							Pantalla.setVisible(true);
						}
						});
					JLabel label = new JLabel("");
					label.setIcon(new ImageIcon("C:\\Users\\Nico\\eclipse-workspace2\\proyecto\\Imagenes\\43079410-muchas-piezas-de-autom\u00F3viles-en-el-fondo-blanco-hecho-en-3d-.jpg"));
					label.setBounds(-20, 0, 454, 262);
					frame.getContentPane().add(label);
			}
		});
		btnAgregarCategoria_1.setBounds(229, 168, 247, 31);
		Pantalla.getContentPane().add(btnAgregarCategoria_1);
		
		JButton btnNewButton = new JButton("DATOS DE REPUESTO");
		btnNewButton.setFont(new Font("Traditional Arabic", Font.PLAIN, 19));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla.setVisible(false);
				final JFrame frame;
				
				
				frame = new JFrame();
				frame.getContentPane().setBackground(Color.GREEN);
				frame.setBounds(100, 100, 600, 300);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				frame.setVisible(true);
				
				JLabel lblNuevaCategoria = new JLabel("INFO DE REPUESTOS");
				lblNuevaCategoria.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblNuevaCategoria.setHorizontalAlignment(SwingConstants.CENTER);
				lblNuevaCategoria.setBounds(0, 1, 584, 25);
				lblNuevaCategoria.setForeground(Color.GREEN);
				frame.getContentPane().add(lblNuevaCategoria);
				
				final JComboBox<String> comboBox = new JComboBox<String>();
				comboBox.setBounds(10, 72, 143, 20);
				frame.getContentPane().add(comboBox);
				controlador.llenarJComboBoxRepuestos(comboBox);
				
				JButton btnAtras = new JButton("ATRAS");
				btnAtras.setBounds(463, 37, 89, 23);
				frame.getContentPane().add(btnAtras);
				
				btnAtras.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);
						Pantalla.setVisible(true);
					}
				});
				
				JButton btnConsultarStock = new JButton("Consultar Stock");
				btnConsultarStock.setBounds(183, 57, 143, 23);
				frame.getContentPane().add(btnConsultarStock);
				btnConsultarStock.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						JOptionPane.showMessageDialog(null, "El stock del producto: "+comboBox.getSelectedItem().toString()
								+"\n es: "+controlador.consultarStock(comboBox.getSelectedItem().toString()));
					}
				});
				
			
				
				JButton btnNewButton = new JButton("Especificacion");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						JOptionPane.showMessageDialog(null, "La especificacion del producto: "+comboBox.getSelectedItem().toString()
								+"\n es: "+controlador.consultarEspecificacion(comboBox.getSelectedItem().toString()));
					}
				});
				btnNewButton.setBounds(183, 91, 117, 23);
				frame.getContentPane().add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton("Marca");
				btnNewButton_1.setBounds(183, 125, 117, 23);
				frame.getContentPane().add(btnNewButton_1);
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						JOptionPane.showMessageDialog(null, "La Marca del producto: "+comboBox.getSelectedItem().toString()
								+"\n es: "+controlador.consultarMarca(comboBox.getSelectedItem().toString()));
					}
				});
				
				JButton btnNewButton_2 = new JButton("Ver Foto");
				btnNewButton_2.setBounds(183, 159, 117, 23);
				frame.getContentPane().add(btnNewButton_2);
				
				btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				frame.getContentPane().setLayout(new FlowLayout());
				try {
					frame.getContentPane().add(new JLabel(new ImageIcon(controlador.imagen(comboBox.getSelectedItem().toString()))));
					frame.setBounds(100, 100, 491, 270);
					frame.pack();
					frame.setVisible(true);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error al traer la imagen verifique que el repuesto tenga asignada una imagen");
				}
					}
				});
				
				JButton btnNewButton_3 = new JButton("Precio/PrecioFabrica");
				btnNewButton_3.setBounds(183, 194, 168, 23);
				frame.getContentPane().add(btnNewButton_3);
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						JOptionPane.showMessageDialog(null, "los precios del producto: "+comboBox.getSelectedItem().toString()
								+"\nPrecio: "+controlador.consultarPrecios(comboBox.getSelectedItem().toString()));
					}
				});
				
				
				JButton btnDatosDeRemito = new JButton("Datos de remito");
				btnDatosDeRemito.setBounds(183, 228, 131, 23);
				frame.getContentPane().add(btnDatosDeRemito);
				frame.getContentPane().add(btnNewButton_3);
				btnDatosDeRemito.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						JOptionPane.showMessageDialog(null, "los datos de remito del producto: "+comboBox.getSelectedItem().toString()
								+"\nson: "+controlador.consultarDatosRemito(comboBox.getSelectedItem().toString()));
					}
				});
				
				JComboBox<String> comboBox_1 = new JComboBox<String>();
				comboBox_1.setBounds(418, 126, 117, 20);
				frame.getContentPane().add(comboBox_1);
				controlador.llenarJComboBoxStockBajo(comboBox_1);
				
				JLabel lblRepuestosConPoco = new JLabel("Repuestos con poco stock");
				lblRepuestosConPoco.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblRepuestosConPoco.setBounds(392, 93, 182, 21);
				lblRepuestosConPoco.setForeground(Color.GREEN);
				frame.getContentPane().add(lblRepuestosConPoco);
				
				JLabel lblRepuestos = new JLabel("REPUESTOS");
				lblRepuestos.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblRepuestos.setBounds(27, 47, 126, 14);
				lblRepuestos.setForeground(Color.GREEN);
				frame.getContentPane().add(lblRepuestos);
				
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon("C:\\Users\\Nico\\eclipse-workspace2\\proyecto\\Imagenes\\189845.jpg"));
				label.setBounds(0, -176, 584, 438);
				frame.getContentPane().add(label);
			}
		});
		btnNewButton.setBounds(229, 228, 247, 31);
		Pantalla.getContentPane().add(btnNewButton);
		
		JButton btnEliminarRepuestocategoria = new JButton("ELIMINAR REPUESTO/CATEGORIA");
		btnEliminarRepuestocategoria.setFont(new Font("Traditional Arabic", Font.PLAIN, 12));
		btnEliminarRepuestocategoria.setBounds(229, 288, 247, 31);
		Pantalla.getContentPane().add(btnEliminarRepuestocategoria);
		btnEliminarRepuestocategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla.setVisible(false);
				final JFrame frame;
				frame = new JFrame();
				frame.getContentPane().setBackground(Color.GREEN);
				frame.setBounds(100, 100, 590, 300);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				frame.setVisible(true);
				
				JLabel lblNuevaCategoria = new JLabel("ELIMINAR ELEMENTOS");
				lblNuevaCategoria.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblNuevaCategoria.setHorizontalAlignment(SwingConstants.CENTER);
				lblNuevaCategoria.setBounds(0, 1, 584, 25);
				lblNuevaCategoria.setForeground(Color.GREEN);
				frame.getContentPane().add(lblNuevaCategoria);
				
				JLabel lblCategorias = new JLabel("CATEGORIAS");
				lblCategorias.setFont(new Font("Tahoma", Font.PLAIN, 19));
				lblCategorias.setBounds(10, 53, 120, 31);
				lblCategorias.setForeground(Color.GREEN);
				frame.getContentPane().add(lblCategorias);
				
				final JComboBox<String> comboBox = new JComboBox<String>();
				comboBox.setBounds(0, 95, 143, 20);
				frame.getContentPane().add(comboBox);
				controlador.llenarJComboBoxCategoriaPadre(comboBox);
				controlador.llenarJComboBoxCategoriaHijo(comboBox);
				
				JButton btnEliminarCategoria = new JButton("Eliminar categoria");
				btnEliminarCategoria.setBounds(156, 228, 140, 23);
				frame.getContentPane().add(btnEliminarCategoria);
				btnEliminarCategoria.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
						controlador.eliminarCategoria(comboBox.getSelectedItem().toString());
						JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
						comboBox.removeItem(comboBox.getSelectedItem());
						}catch(Exception a) {
							JOptionPane.showMessageDialog(null, "La operacion no pudo ser concretada verifique si la"
									+ " categoria que intenta eliminar no esta asociada a algun repuesto o a otra categoria como su padre");
						}
					}
				});
				final JComboBox<String> comboBox_1 = new JComboBox<String>();
				comboBox_1.setBounds(447, 95, 130, 20);
				frame.getContentPane().add(comboBox_1);
				controlador.llenarJComboBoxRepuestos(comboBox_1);
				
				JButton btnEliminarRepuesto = new JButton("Eliminar repuesto");
				btnEliminarRepuesto.setBounds(312, 228, 140, 23);
				frame.getContentPane().add(btnEliminarRepuesto);
				btnEliminarRepuesto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						controlador.eliminarRepuesto(comboBox_1.getSelectedItem().toString());
						JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
						comboBox_1.removeItem(comboBox_1.getSelectedItem());
						
					}
				});
				
				JLabel lblSoloPodraEliminar = new JLabel("Solo podra eliminar categorias sin productos asociados");
				lblSoloPodraEliminar.setBounds(10, 37, 350, 14);
				lblSoloPodraEliminar.setForeground(Color.GREEN);
				frame.getContentPane().add(lblSoloPodraEliminar);
				
				JLabel lblRepuestos = new JLabel("REPUESTOS");
				lblRepuestos.setFont(new Font("Tahoma", Font.PLAIN, 19));
				lblRepuestos.setBounds(447, 59, 147, 19);
				lblRepuestos.setForeground(Color.GREEN);
				frame.getContentPane().add(lblRepuestos);
				
				JButton btnAtras = new JButton("ATRAS");
				btnAtras.setBounds(254, 94, 89, 23);
				frame.getContentPane().add(btnAtras);
				btnAtras.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);
						Pantalla.setVisible(true);
					}
				});
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon("C:\\Users\\Nico\\eclipse-workspace2\\proyecto\\Imagenes\\portada-mecanicos.jpg"));
				label.setBounds(0, 0, 584, 262);
				frame.getContentPane().add(label);
				
			}
		});
		
		JButton btnEditarRepuestocategoria = new JButton("EDITAR REPUESTO/CATEGORIA");
		btnEditarRepuestocategoria.setFont(new Font("Traditional Arabic", Font.PLAIN, 13));
		btnEditarRepuestocategoria.setBounds(229, 347, 247, 31);
		Pantalla.getContentPane().add(btnEditarRepuestocategoria);
		btnEditarRepuestocategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla.setVisible(false);
				final JFrame frame;
				final JTextField textField;
				final JTextField textField_1;
				final JTextField textField_2;
				final JTextField textField_3;
				final JTextField textField_4;
				final JTextField textField_5;
				final JTextField textField_6;
				final JTextField textField_7;
				
				frame = new JFrame();
				frame.getContentPane().setBackground(Color.GREEN);
				frame.setBounds(100, 100, 600, 400);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				frame.setVisible(true);
				
				JLabel lblNuevaCategoria = new JLabel("EDICION DE ELEMENTOS");
				lblNuevaCategoria.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblNuevaCategoria.setHorizontalAlignment(SwingConstants.CENTER);
				lblNuevaCategoria.setBounds(0, 1, 584, 25);
				lblNuevaCategoria.setForeground(Color.GREEN);
				frame.getContentPane().add(lblNuevaCategoria);
				
				JLabel lblCategorias = new JLabel("CATEGORIAS");
				lblCategorias.setFont(new Font("Tahoma", Font.PLAIN, 19));
				lblCategorias.setBounds(10, 53, 120, 31);
				lblCategorias.setForeground(Color.GREEN);
				frame.getContentPane().add(lblCategorias);
				
				textField = new JTextField();
				textField.setBounds(91, 141, 86, 20);
				frame.getContentPane().add(textField);
				textField.setColumns(10);
				
				final JComboBox<String> comboBox = new JComboBox<String>();
				comboBox.setBounds(0, 95, 143, 20);
				frame.getContentPane().add(comboBox);
				controlador.llenarJComboBoxCategoriaPadre(comboBox);
				controlador.llenarJComboBoxCategoriaHijo(comboBox);
				
				final JComboBox<String> comboBox_2 = new JComboBox<String>();
				comboBox_2.setBounds(299, 127, 102, 20);
				frame.getContentPane().add(comboBox_2);
				controlador.llenarJComboBoxCategoriaHijo(comboBox_2);
				
				JButton btnEditarCategoria = new JButton("Editar Nombre/categoria");
				btnEditarCategoria.setBounds(10, 174, 190, 23);
				frame.getContentPane().add(btnEditarCategoria);
				btnEditarCategoria.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlador.editarCategoria(comboBox.getSelectedItem().toString(), textField.getText());
					comboBox.removeItem(comboBox.getSelectedItem());
					comboBox_2.removeItem(comboBox.getSelectedItem());
					controlador.llenarJComboBoxCategoriaPadre(comboBox);
					controlador.llenarJComboBoxCategoriaHijo(comboBox);
					controlador.llenarJComboBoxCategoriaHijo(comboBox_2);
					JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
					
				}
			});
				final JComboBox<String> comboBox_1 = new JComboBox<String>();
				comboBox_1.setBounds(248, 95, 137, 20);
				frame.getContentPane().add(comboBox_1);
				controlador.llenarJComboBoxRepuestos(comboBox_1);
				
				
				textField_1 = new JTextField();
				textField_1.setBounds(488, 95, 86, 20);
				frame.getContentPane().add(textField_1);
				textField_1.setColumns(10);
				
				
				JButton btnOKK = new JButton("OK");
				btnOKK.setBounds(508, 126, 52, 23);
				frame.getContentPane().add(btnOKK);
				btnOKK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controlador.editarNombreRepuesto(comboBox_1.getSelectedItem().toString(), textField_1.getText());
						comboBox_1.removeItem(comboBox_1.getSelectedItem());
						controlador.llenarJComboBoxRepuestos(comboBox_1);
						JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
						
					}
				});
				
				JLabel lblRepuestos = new JLabel("REPUESTOS");
				lblRepuestos.setFont(new Font("Tahoma", Font.PLAIN, 19));
				lblRepuestos.setBounds(266, 59, 147, 19);
				lblRepuestos.setForeground(Color.GREEN);
				frame.getContentPane().add(lblRepuestos);
				
				
				
				JButton btnAtras = new JButton("ATRAS");
				btnAtras.setBounds(32, 282, 89, 23);
				frame.getContentPane().add(btnAtras);
				btnAtras.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);
						Pantalla.setVisible(true);
					}
				});
				
				JLabel lblNuevoNombre = new JLabel("Nuevo nombre:");
				lblNuevoNombre.setBounds(10, 144, 89, 14);
				lblNuevoNombre.setForeground(Color.GREEN);
				frame.getContentPane().add(lblNuevoNombre);
				
				
				
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(432, 98, 50, 14);
				lblNombre.setForeground(Color.GREEN);
				frame.getContentPane().add(lblNombre);
				
				
				
				JLabel lblMarca = new JLabel("Marca:");
				lblMarca.setBounds(432, 159, 46, 14);
				lblMarca.setForeground(Color.GREEN);
				frame.getContentPane().add(lblMarca);
				
				textField_2 = new JTextField();
				textField_2.setBounds(488, 156, 86, 20);
				frame.getContentPane().add(textField_2);
				textField_2.setColumns(10);
				
				JButton btnOk = new JButton("OK");
				btnOk.setBounds(508, 187, 52, 23);
				frame.getContentPane().add(btnOk);
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controlador.editarMarcaRepuesto(comboBox_1.getSelectedItem().toString(), textField_2.getText());
						JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
						
					}
				});
				
				JLabel lblEspecificacion = new JLabel("Especificacion:");
				lblEspecificacion.setBounds(402, 215, 89, 14);
				lblEspecificacion.setForeground(Color.GREEN);
				frame.getContentPane().add(lblEspecificacion);
				
				textField_3 = new JTextField();
				textField_3.setBounds(488, 212, 86, 20);
				frame.getContentPane().add(textField_3);
				textField_3.setColumns(10);
				
				JButton btnOk_1 = new JButton("OK");
				btnOk_1.setBounds(514, 244, 52, 23);
				frame.getContentPane().add(btnOk_1);
				
				btnOk_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controlador.editarEspecificacionRepuesto(comboBox_1.getSelectedItem().toString(), textField_3.getText());
						JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
						
					}
				});
				
				
				JLabel lblPrecio = new JLabel("Precio:");
				lblPrecio.setBounds(248, 305, 46, 14);
				lblPrecio.setForeground(Color.GREEN);
				frame.getContentPane().add(lblPrecio);
				
				textField_4 = new JTextField();
				textField_4.setBounds(304, 302, 86, 20);
				frame.getContentPane().add(textField_4);
				textField_4.setColumns(10);
				
				JButton btnOk_2 = new JButton("OK");
				btnOk_2.setBounds(321, 328, 52, 23);
				frame.getContentPane().add(btnOk_2);
				
				btnOk_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Double valor=Double.parseDouble(textField_4.getText());
						controlador.editarPrecioRepuesto(comboBox_1.getSelectedItem().toString(), valor);
						JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
						
					}
				});
				
				JLabel lblDatosDeRemito = new JLabel("Datos de remito:");
				lblDatosDeRemito.setBounds(199, 191, 95, 14);
				lblDatosDeRemito.setForeground(Color.GREEN);
				frame.getContentPane().add(lblDatosDeRemito);
				
				textField_5 = new JTextField();
				textField_5.setBounds(299, 188, 86, 20);
				frame.getContentPane().add(textField_5);
				textField_5.setColumns(10);
				
				JButton btnOk_3 = new JButton("OK");
				btnOk_3.setBounds(321, 211, 52, 23);
				frame.getContentPane().add(btnOk_3);
				
				btnOk_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controlador.editarDatosRemitoRepuesto(comboBox_1.getSelectedItem().toString(), textField_5.getText());
						JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
						
					}
				});
				
				JLabel lblPrecioDeFabrica = new JLabel("Precio de fabrica:");
				lblPrecioDeFabrica.setBounds(188, 248, 106, 14);
				lblPrecioDeFabrica.setForeground(Color.GREEN);
				frame.getContentPane().add(lblPrecioDeFabrica);
				
				textField_6 = new JTextField();
				textField_6.setBounds(299, 245, 86, 20);
				frame.getContentPane().add(textField_6);
				textField_6.setColumns(10);
				
				JButton btnOk_4 = new JButton("OK");
				btnOk_4.setBounds(321, 268, 52, 23);
				frame.getContentPane().add(btnOk_4);
				
				btnOk_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Double valor=Double.parseDouble(textField_6.getText());
						controlador.editarPrecioFabricaRepuesto(comboBox_1.getSelectedItem().toString(), valor);
						JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
						
					}
				});
				
				JLabel lblStock = new JLabel("Stock:");
				lblStock.setBounds(432, 286, 46, 14);
				lblStock.setForeground(Color.GREEN);
				frame.getContentPane().add(lblStock);
				
				textField_7 = new JTextField();
				textField_7.setBounds(488, 283, 86, 20);
				frame.getContentPane().add(textField_7);
				textField_7.setColumns(10);
				
				JButton btnOk_5 = new JButton("OK");
				btnOk_5.setBounds(514, 316, 52, 23);
				frame.getContentPane().add(btnOk_5);
				
				btnOk_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Integer valor=Integer.parseInt(textField_7.getText());
						controlador.editarStockRepuesto(comboBox_1.getSelectedItem().toString(), valor);
						JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
						
					}
				});
				
				JLabel lblCategoria = new JLabel("Categoria:");
				lblCategoria.setBounds(229, 130, 68, 14);
				lblCategoria.setForeground(Color.GREEN);
				frame.getContentPane().add(lblCategoria);
				
				
				
				
				JButton btnOk_6 = new JButton("OK");
				btnOk_6.setBounds(321, 155, 52, 23);
				frame.getContentPane().add(btnOk_6);
				
				btnOk_6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						controlador.editarCategoriaRepuesto(comboBox_1.getSelectedItem().toString(), comboBox_2.getSelectedItem().toString());
						JOptionPane.showMessageDialog(null, "Operacion realizada correctamente");
						
					}
				});
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon("C:\\Users\\Nico\\eclipse-workspace2\\proyecto\\Imagenes\\ford-fiesta-hb-01 (1).jpg"));
				label.setBounds(-25, 0, 609, 362);
				frame.getContentPane().add(label);
				
			}
		});
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBackground(Color.CYAN);
		btnSalir.setFont(new Font("Traditional Arabic", Font.PLAIN, 13));
		btnSalir.setBounds(22, 403, 89, 23);
		Pantalla.getContentPane().add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla.setVisible(false);
			}
		});
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Nico\\eclipse-workspace2\\proyecto\\Imagenes\\pamotaller1 (2).jpg"));
		label.setBounds(-62, 0, 746, 473);
		Pantalla.getContentPane().add(label);
	}
	static public byte[] AbrirAImagen(File archivo){
        byte[] bytesImg = new byte[1024*100];
        try {
        	FileInputStream entrada = new FileInputStream(archivo);
            entrada.read(bytesImg);
            entrada.close();
        } catch (Exception e) {
        }
        
        return bytesImg;
        
    }
}

