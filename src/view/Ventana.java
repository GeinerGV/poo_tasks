package view;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
		jPdatosPersona = new JPanel();
		jLnombre = new JLabel("Nombre: ");
		jTFnombre = new JTextField();
		jLpaisNacimiento = new JLabel("País de Nacimento: ");
		jCBpaisNacimiento = new JComboBox();
		jLpaisResidencia = new JLabel("País de Residencia: ");
		jCBpaisResidencia = new JComboBox();
		jLedad = new JLabel("Edad: ");
		jTFedad = new JTextField();
		jLdestinoFavorito = new JLabel("Destino Favorito: ");
		jCBdestinoFavorito = new JComboBox();
		jLtiempoDeMochilero = new JLabel("Tiempo de Mochilero: ");
		jTFtiempoDeMochilero = new JTextField();
		jBagregar = new JButton("Agregar");
		jBreporte = new JButton("Reporte");
		jTAviewReporte = new JTextArea(8, 30);
		jSPviewReporte = new JScrollPane(jTAviewReporte);

		setTitle("Añadir Mochilero");

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		jPdatosPersona.add(jLnombre);
		jPdatosPersona.add(jTFnombre);
		jPdatosPersona.add(jLpaisNacimiento);
		jPdatosPersona.add(jCBpaisNacimiento);
		jPdatosPersona.add(jLpaisResidencia);
		jPdatosPersona.add(jCBpaisResidencia);
		jPdatosPersona.add(jLedad);
		jPdatosPersona.add(jTFedad);
		jPdatosPersona.add(jLdestinoFavorito);
		jPdatosPersona.add(jCBdestinoFavorito);
		jPdatosPersona.add(jLtiempoDeMochilero);
		jPdatosPersona.add(jTFtiempoDeMochilero);

		jPdatosPersona.setLayout(new GridLayout(6, 2));
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		add(jPdatosPersona);
		add(jBagregar);
		add(jBreporte);
		add(jSPviewReporte);
		pack();
	}
	
	private JPanel jPdatosPersona;
	private JLabel jLnombre;
	private JTextField jTFnombre;
	private JLabel jLpaisNacimiento;
	private JComboBox jCBpaisNacimiento;
	private JLabel jLpaisResidencia;
	private JComboBox jCBpaisResidencia;
	private JLabel jLedad;
	private JTextField jTFedad;
	private JLabel jLdestinoFavorito;
	private JComboBox jCBdestinoFavorito;
	private JLabel jLtiempoDeMochilero;
	private JTextField jTFtiempoDeMochilero;
	private JButton jBagregar;
	private JButton jBreporte;
	private JTextArea jTAviewReporte;
	private JScrollPane jSPviewReporte;
}