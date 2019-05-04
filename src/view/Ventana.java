package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.w3c.dom.ranges.RangeException;

import bean.Mochilero;
import components.JListaPaises;

/**
 * Ventana
 */
public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;

	private ArrayList<Mochilero> mochileros = new ArrayList<Mochilero>();

	public Ventana() {
		initComponents();
	}

	public void initComponents() {
		jPdatosPersona = new JPanel();
		jLnombre = new JLabel("Nombres: ");
		jTFnombre = new JTextField();
		jLpaisNacimiento = new JLabel("País de Nacimento: ");
		jCBpaisNacimiento = new JListaPaises();
		jLpaisResidencia = new JLabel("País de Residencia: ");
		jCBpaisResidencia = new JListaPaises();
		jLedad = new JLabel("Edad: ");
		jTFedad = new JTextField();
		jLdestinoFavorito = new JLabel("Destino Favorito: ");
		jCBdestinoFavorito = new JListaPaises();
		jLtiempoDeMochilero = new JLabel("Tiempo de Mochilero: ");
		jTFtiempoDeMochilero = new JTextField();
		jBagregar = new JButton("Agregar");
		jBreporte = new JButton("Reporte");
		jTAviewReporte = new JTextArea(8, 30);
		jSPviewReporte = new JScrollPane(jTAviewReporte);
		jLMessage = new JLabel(" ");

		setTitle("Añadir Mochilero");

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		jBreporte.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String resultado = "";
				for (Mochilero mochilero : mochileros) {
					resultado += mochilero+"\n\n";
				}
				resultado = resultado.substring(0, resultado.length()-2);
				jTAviewReporte.setText(resultado);
			}
		});

		jBagregar.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nombre = jTFnombre.getText().trim();
				String paisNacimiento = jCBpaisNacimiento.getSelectedItem().trim();
				String paisResidencia = jCBpaisResidencia.getSelectedItem().trim();
				String edadStr = jTFedad.getText().trim();
				String destinoFavorito = jCBdestinoFavorito.getSelectedItem().trim();
				String tiempoDeMochileroStr = jTFtiempoDeMochilero.getText().trim();

				if (nombre.length()>0&&
				paisNacimiento.length()>0&&
				paisResidencia.length()>0&&
				edadStr.length()>0&&
				destinoFavorito.length()>0&&
				tiempoDeMochileroStr.length()>0) {
					try {
						int edad = Integer.parseInt(edadStr);
						if (edad<=0) throw new RangeException((short)1, "La edad debe que ser un valor positivo");
						int tiempoDeMochilero = Integer.parseInt(tiempoDeMochileroStr);
						if (tiempoDeMochilero<0) throw new RangeException((short)2, "El tiempo de mochilero debe que ser mayor o igual a cero");
						mochileros.add(new Mochilero(nombre, paisNacimiento, paisResidencia, edad, destinoFavorito, tiempoDeMochilero));
						jTAviewReporte.setText((mochileros.get(mochileros.size()-1)).toString());
						
						jTFnombre.setText("");
						jCBpaisNacimiento.setSelectedIndex(0);
						jCBpaisResidencia.setSelectedIndex(0);
						jTFedad.setText("");
						jCBdestinoFavorito.setSelectedIndex(0);
						jTFtiempoDeMochilero.setText("");

					} catch (NumberFormatException e) {
						jLMessage.setText("Completa la edad o tiempo de mochilero con números");
						pack();
					} catch (Exception e) {
						jLMessage.setText(e.getMessage());
						pack();
					}
				} else {
					jLMessage.setText("Complete los espacios en blanco");
					pack();
				}
			}
		});

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
		add(jLMessage);
		add(jPdatosPersona);
		add(jBagregar);
		add(jBreporte, CENTER_ALIGNMENT);
		add(jSPviewReporte, CENTER_ALIGNMENT);
		pack();
	}
	
	private JPanel jPdatosPersona;
	private JLabel jLnombre;
	private JTextField jTFnombre;
	private JLabel jLpaisNacimiento;
	private JListaPaises jCBpaisNacimiento;
	private JLabel jLpaisResidencia;
	private JListaPaises jCBpaisResidencia;
	private JLabel jLedad;
	private JTextField jTFedad;
	private JLabel jLdestinoFavorito;
	private JListaPaises jCBdestinoFavorito;
	private JLabel jLtiempoDeMochilero;
	private JTextField jTFtiempoDeMochilero;
	private JButton jBagregar;
	private JButton jBreporte;
	private JTextArea jTAviewReporte;
	private JScrollPane jSPviewReporte;
	private JLabel jLMessage;
}