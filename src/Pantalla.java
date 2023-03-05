import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JList;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Font;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.ListSelectionListener;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.event.ListSelectionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Window.Type;
import javax.swing.DefaultComboBoxModel;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.event.MouseMotionAdapter;

@SuppressWarnings("unused")
public class Pantalla {

	private JFrame frmConversor;
	private JTextField txtValor;
	private JTextField txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatDarkLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla window = new Pantalla();
					window.frmConversor.setVisible(true);
					
					//PROPIEDAD PARA QUE LA VENTANA NO PUEDA CAMBIARSE DE TAMAÑO
					window.frmConversor.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Pantalla() {
		initialize();
	}

	//COMPONENTES GENERADOS POR EL DESIGN DE WINDOWS BUILDER
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	private void initialize() {
		frmConversor = new JFrame();
		frmConversor.setTitle("Conversor");
		frmConversor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConversor.setBounds(100, 100, 500, 318);
		SpringLayout springLayout = new SpringLayout();
		frmConversor.getContentPane().setLayout(springLayout);

		JPanel panelSeleccion = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panelSeleccion, 60, SpringLayout.NORTH, frmConversor.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panelSeleccion, 10, SpringLayout.WEST, frmConversor.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panelSeleccion, -10, SpringLayout.SOUTH, frmConversor.getContentPane());
		frmConversor.getContentPane().add(panelSeleccion);

		JLabel lblBienvenida = new JLabel("<html>Seleccione el tipo de conversion que desee realizar</html>");
		lblBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);

		JList listadoConversiones = new JList();
		listadoConversiones.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listadoConversiones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		listadoConversiones.setModel(new AbstractListModel() {
			String[] values = new String[] { "Moneda", "Temperatura", "Distancia", "Masa", "Volumen" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listadoConversiones.setSelectedIndex(0);

		JButton btnCambiar = new JButton("Cambiar");

		GroupLayout gl_panelSeleccion = new GroupLayout(panelSeleccion);
		gl_panelSeleccion.setHorizontalGroup(
			gl_panelSeleccion.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelSeleccion.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelSeleccion.createParallelGroup(Alignment.TRAILING)
						.addComponent(listadoConversiones, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
						.addComponent(lblBienvenida, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
						.addComponent(btnCambiar, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelSeleccion.setVerticalGroup(
			gl_panelSeleccion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSeleccion.createSequentialGroup()
					.addComponent(lblBienvenida, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(listadoConversiones)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCambiar, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		panelSeleccion.setLayout(gl_panelSeleccion);

		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.EAST, panelSeleccion, -6, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -10, SpringLayout.SOUTH, frmConversor.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, panel, 60, SpringLayout.NORTH, frmConversor.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 184, SpringLayout.WEST, frmConversor.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, frmConversor.getContentPane());
		frmConversor.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JLabel lblInstrucciones = new JLabel(
				"<html>Seleccione los tipos de valores a convertir en los siguientes listados</html>");
		sl_panel.putConstraint(SpringLayout.NORTH, lblInstrucciones, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblInstrucciones, 20, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblInstrucciones, 39, SpringLayout.NORTH, panel);
		lblInstrucciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblInstrucciones);

		JLabel labelDe = new JLabel("De:");
		sl_panel.putConstraint(SpringLayout.NORTH, labelDe, 6, SpringLayout.SOUTH, lblInstrucciones);
		sl_panel.putConstraint(SpringLayout.WEST, labelDe, 20, SpringLayout.WEST, panel);
		panel.add(labelDe);

		JComboBox comboEntrada = new JComboBox();
		sl_panel.putConstraint(SpringLayout.NORTH, comboEntrada, 2, SpringLayout.SOUTH, lblInstrucciones);
		sl_panel.putConstraint(SpringLayout.WEST, comboEntrada, 5, SpringLayout.EAST, labelDe);
		sl_panel.putConstraint(SpringLayout.EAST, comboEntrada, -150, SpringLayout.EAST, panel);
		comboEntrada.setModel(new DefaultComboBoxModel(
				new String[] { "USD-Dolar", "CRC-Colon", "EUR-Euro", "GBP-Libra", "JPY-Yen", "KRW-Won surcoreano" }));
		panel.add(comboEntrada);

		JLabel labelA = new JLabel("A:");
		sl_panel.putConstraint(SpringLayout.NORTH, labelA, 0, SpringLayout.NORTH, labelDe);
		sl_panel.putConstraint(SpringLayout.EAST, labelA, -122, SpringLayout.EAST, panel);
		panel.add(labelA);

		JComboBox comboSalida = new JComboBox();
		sl_panel.putConstraint(SpringLayout.EAST, lblInstrucciones, 0, SpringLayout.EAST, comboSalida);
		sl_panel.putConstraint(SpringLayout.NORTH, comboSalida, -3, SpringLayout.NORTH, labelDe);
		sl_panel.putConstraint(SpringLayout.WEST, comboSalida, 14, SpringLayout.EAST, labelA);
		comboSalida.setModel(new DefaultComboBoxModel(
				new String[] { "USD-Dolar", "CRC-Colon", "EUR-Euro", "GBP-Libra", "JPY-Yen", "KRW-Won surcoreano" }));
		panel.add(comboSalida);

		txtValor = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, txtValor, 20, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txtValor, -10, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, comboSalida, 0, SpringLayout.EAST, txtValor);
		sl_panel.putConstraint(SpringLayout.NORTH, txtValor, 14, SpringLayout.SOUTH, comboEntrada);
		txtValor.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(txtValor);
		txtValor.setColumns(10);

		JButton btnConvertir = new JButton("Convertir");
		sl_panel.putConstraint(SpringLayout.WEST, btnConvertir, 20, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnConvertir, -10, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, txtValor, -6, SpringLayout.NORTH, btnConvertir);
		panel.add(btnConvertir);

		txtResultado = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, txtResultado, 149, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, txtResultado, 20, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, txtResultado, -15, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txtResultado, -10, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnConvertir, -6, SpringLayout.NORTH, txtResultado);
		txtResultado.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultado.setEditable(false);
		panel.add(txtResultado);
		txtResultado.setColumns(10);

		JLabel barra = new JLabel("");
		springLayout.putConstraint(SpringLayout.SOUTH, barra, -2, SpringLayout.NORTH, panelSeleccion);
		springLayout.putConstraint(SpringLayout.NORTH, barra, 0, SpringLayout.NORTH, frmConversor.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, barra, 10, SpringLayout.WEST, frmConversor.getContentPane());

		// CARGA DE IMAGEN BARRA DE TITULO
		ImageIcon imagen = new ImageIcon("img/barra.png");
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(400, 58, Image.SCALE_DEFAULT));
		barra.setIcon(icono);
		frmConversor.getContentPane().add(barra);

		JLabel imgGithub = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, imgGithub, 6, SpringLayout.NORTH, frmConversor.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, imgGithub, 418, SpringLayout.WEST, frmConversor.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, imgGithub, -8, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, imgGithub, -22, SpringLayout.EAST, frmConversor.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, barra, -6, SpringLayout.WEST, imgGithub);

		// CARGA DE IMAGEN GITHUB
		imagen = new ImageIcon("img/github.png");
		icono = new ImageIcon(imagen.getImage().getScaledInstance(42, 42, Image.SCALE_DEFAULT));
		imgGithub.setIcon(icono);
		frmConversor.getContentPane().add(imgGithub);

		// INICIO DE EVENTOS

		// CARGA DE COMBOBOX SEGUN LA SELECCION DEL TIPO DE CAMBIO
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medidas medida = new Medidas((String) listadoConversiones.getSelectedValue());
				String seleccion = (String) listadoConversiones.getSelectedValue();
				String[] carga = { "0" };
				txtResultado.setText("");
				txtValor.setText("");
				comboEntrada.removeAllItems();
				comboSalida.removeAllItems();
				switch (seleccion) {
				case "Moneda":
					carga = medida.getMoneda();
					break;
				case "Distancia":
					carga = medida.getDistancia();
					break;
				case "Masa":
					carga = medida.getMasa();
					break;
				case "Volumen":
					carga = medida.getVolumen();
					break;
				case "Temperatura":
					carga = medida.getTemperatura();
					break;
				}
				for (int i = 0; i < carga.length; i++) {
					comboEntrada.addItem(carga[i]);
					comboSalida.addItem(carga[i]);
				}
			}
		});

		//EVENTO PARA REALIZAR LA CONVERSION
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Verificacion.verificaEntero(txtValor.getText())) {
					double valor = Double.parseDouble(txtValor.getText());
					String entrada = (String) comboEntrada.getSelectedItem();
					String salida = (String) comboSalida.getSelectedItem();
					double resultado = Calculo.tipoDeConversion(valor, entrada, salida);
					txtResultado.setText(String.valueOf(Math.round(resultado * 10000) / 10000d));
				} else {
					txtResultado.setText("ingrese valores numericos");
				}
			}
		});

		// EVENTO PARA LA IMAGEN DE GITHUB, ENVIA AL PERFIL AL HACER CLICK EN EL
		// TRY CATCH AUTOGENERADO
		imgGithub.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					URL url = new URL("https://github.com/chetosky/");
					Desktop.getDesktop().browse(url.toURI());
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
			}

			// EVENTO PARA QUE AL PASAR POR ENCIMA CAMBIE EL CURSOR
			@Override
			public void mouseEntered(MouseEvent e) {
				imgGithub.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});

	}
}
