package view;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Ventana
 */
public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;

	public Ventana() {
		initComponents();
	}

	public void initComponents() {
		
	}
	
	private JPanel jPdatosPersona;
	private JLabel jLnombre;
	private JTextField jTFnombre;
	private JLabel jLpaisNacimiento;
	private JComboBox jCBpaisNacimiento;
	private JLabel jLpaisResidencia;
}