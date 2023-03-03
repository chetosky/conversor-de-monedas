import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JList;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JSeparator;
import java.awt.Color;
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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pantalla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConversor = new JFrame();
		frmConversor.setTitle("Conversor");
		frmConversor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConversor.setBounds(100, 100, 450, 300);
		SpringLayout springLayout = new SpringLayout();
		frmConversor.getContentPane().setLayout(springLayout);

		JPanel panelSeleccion = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panelSeleccion, 10, SpringLayout.NORTH,
				frmConversor.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panelSeleccion, 10, SpringLayout.WEST,
				frmConversor.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panelSeleccion, 251, SpringLayout.NORTH,
				frmConversor.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panelSeleccion, 178, SpringLayout.WEST,
				frmConversor.getContentPane());
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

		JButton btnIniciar = new JButton("Iniciar");

		GroupLayout gl_panelSeleccion = new GroupLayout(panelSeleccion);
		gl_panelSeleccion.setHorizontalGroup(gl_panelSeleccion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSeleccion.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelSeleccion.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING,
										gl_panelSeleccion
												.createSequentialGroup()
												.addComponent(btnIniciar, GroupLayout.DEFAULT_SIZE, 158,
														Short.MAX_VALUE)
												.addContainerGap())
								.addGroup(Alignment.TRAILING,
										gl_panelSeleccion.createSequentialGroup()
												.addGroup(gl_panelSeleccion.createParallelGroup(Alignment.TRAILING)
														.addComponent(lblBienvenida, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
														.addComponent(listadoConversiones, GroupLayout.DEFAULT_SIZE,
																148, Short.MAX_VALUE))
												.addContainerGap()))));
		gl_panelSeleccion.setVerticalGroup(gl_panelSeleccion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSeleccion.createSequentialGroup()
						.addComponent(lblBienvenida, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(listadoConversiones, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnIniciar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGap(20)));
		panelSeleccion.setLayout(gl_panelSeleccion);

		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, frmConversor.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 6, SpringLayout.EAST, panelSeleccion);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 251, SpringLayout.NORTH, frmConversor.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 246, SpringLayout.EAST, panelSeleccion);
		frmConversor.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JLabel lblInstrucciones = new JLabel(
				"<html>Seleccione los tipos de valores a convertir en los siguientes listados</html>");
		sl_panel.putConstraint(SpringLayout.NORTH, lblInstrucciones, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblInstrucciones, 20, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblInstrucciones, 39, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblInstrucciones, -20, SpringLayout.EAST, panel);
		lblInstrucciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblInstrucciones);

		JLabel labelDe = new JLabel("De:");
		sl_panel.putConstraint(SpringLayout.NORTH, labelDe, 6, SpringLayout.SOUTH, lblInstrucciones);
		sl_panel.putConstraint(SpringLayout.WEST, labelDe, 0, SpringLayout.WEST, lblInstrucciones);
		panel.add(labelDe);

		JComboBox comboEntrada = new JComboBox();
		comboEntrada.setModel(new DefaultComboBoxModel(new String[] {"USD-Dolar", "CRC-Colon", "EUR-Euro", "GBP-Libra", "JPY-Yen", "KRW-Won surcoreano"}));
		sl_panel.putConstraint(SpringLayout.NORTH, comboEntrada, 2, SpringLayout.SOUTH, lblInstrucciones);
		sl_panel.putConstraint(SpringLayout.WEST, comboEntrada, 24, SpringLayout.WEST, lblInstrucciones);
		sl_panel.putConstraint(SpringLayout.EAST, comboEntrada, -100, SpringLayout.EAST, lblInstrucciones);
		panel.add(comboEntrada);

		JLabel labelA = new JLabel("A:");
		sl_panel.putConstraint(SpringLayout.NORTH, labelA, 6, SpringLayout.SOUTH, lblInstrucciones);
		sl_panel.putConstraint(SpringLayout.WEST, labelA, 6, SpringLayout.EAST, comboEntrada);
		panel.add(labelA);

		JComboBox comboSalida = new JComboBox();
		comboSalida.setModel(new DefaultComboBoxModel(new String[] {"USD-Dolar", "CRC-Colon", "EUR-Euro", "GBP-Libra", "JPY-Yen", "KRW-Won surcoreano"}));
		sl_panel.putConstraint(SpringLayout.NORTH, comboSalida, 2, SpringLayout.SOUTH, lblInstrucciones);
		sl_panel.putConstraint(SpringLayout.WEST, comboSalida, 140, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, comboSalida, -24, SpringLayout.EAST, panel);
		panel.add(comboSalida);

		txtValor = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, txtValor, 24, SpringLayout.SOUTH, comboEntrada);
		sl_panel.putConstraint(SpringLayout.SOUTH, txtValor, -122, SpringLayout.SOUTH, panel);
		txtValor.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		sl_panel.putConstraint(SpringLayout.WEST, txtValor, 0, SpringLayout.WEST, lblInstrucciones);
		sl_panel.putConstraint(SpringLayout.EAST, txtValor, 0, SpringLayout.EAST, lblInstrucciones);
		panel.add(txtValor);
		txtValor.setColumns(10);

		JButton btnConvertir = new JButton("Convertir");
		sl_panel.putConstraint(SpringLayout.NORTH, btnConvertir, 6, SpringLayout.SOUTH, txtValor);
		sl_panel.putConstraint(SpringLayout.WEST, btnConvertir, 0, SpringLayout.WEST, lblInstrucciones);
		sl_panel.putConstraint(SpringLayout.EAST, btnConvertir, -20, SpringLayout.EAST, panel);
		panel.add(btnConvertir);

		txtResultado = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, txtResultado, 8, SpringLayout.SOUTH, btnConvertir);
		sl_panel.putConstraint(SpringLayout.WEST, txtResultado, 0, SpringLayout.WEST, lblInstrucciones);
		sl_panel.putConstraint(SpringLayout.SOUTH, txtResultado, -53, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txtResultado, -20, SpringLayout.EAST, panel);
		txtResultado.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultado.setEditable(false);
		panel.add(txtResultado);
		txtResultado.setColumns(10);

		// INICIO DE ACCIONES

		// Cargando combos de acuerdo a la seleccion

		btnIniciar.addActionListener(new ActionListener() {
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

		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Verificacion.verificaEntero(txtValor.getText())) {
					double valor = Double.parseDouble(txtValor.getText());
					String monedaEntrada = (String) comboEntrada.getSelectedItem();
					String monedaSalida = (String) comboSalida.getSelectedItem();
					double resultado = Calculo.tipoDeConversion(valor, monedaEntrada, monedaSalida);
					txtResultado.setText("");
					txtResultado.setText(String.valueOf(Math.round(resultado * 10000) / 10000d));
				} else {
					txtResultado.setText("ingrese valores numericos");
				}
			}
		});

	}
}
