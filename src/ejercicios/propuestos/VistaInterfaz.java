package ejercicios.propuestos;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * VistaInterfaz
 */
public class VistaInterfaz extends JFrame {

	private static final long serialVersionUID = 1L;

	public VistaInterfaz() {
		initComponents();
	}

	public void initComponents() {
		jPRoot = new JPanel();
		jPForm = new JPanel();
		jLAltura = new JLabel("Estatura (cm):");
		jLPeso = new JLabel("Peso (kg):");
		jTFAltura = new JTextField();
		jTFPeso = new JTextField();
		jBCalcular = new JButton("Calcular");
		jLResultado = new JLabel("IMC: ?");

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Índice de masa corporal (IMC)");

		jBCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String strAlto = jTFAltura.getText().trim();
				String strPeso = jTFPeso.getText().trim();
				if (strAlto.length()>0 && strPeso.length()>0) {
					int alto, peso;
					try {
						peso = Integer.parseInt(strPeso);
						alto = Integer.parseInt(strAlto);
						if (peso < 0) throw new IndexOutOfBoundsException("Peso debe ser >= 0 (kg)");
						if (alto <= 0) throw new IndexOutOfBoundsException("Altura debe ser mayor a 0 (cm)");
						IMC imc = new IMC(alto, peso);
						jLResultado.setText("IDM: "+imc.getMensaje());
					} catch(IndexOutOfBoundsException ex) {
						jLResultado.setText(ex.getMessage());
					} catch (Exception ex) {
						jLResultado.setText("Ingrese solo números");
					}
				} else {
					jLResultado.setText("Ingrese los datos");
				}
			}
		});
		
		jPForm.add(jLAltura);
		jPForm.add(jTFAltura);
		jPForm.add(jLPeso);
		jPForm.add(jTFPeso);
		jPForm.setLayout(new GridLayout(2,2));

		jPRoot.setLayout(new BoxLayout(jPRoot, BoxLayout.PAGE_AXIS));
		jPRoot.add(jPForm);
		jBCalcular.setAlignmentX(Component.CENTER_ALIGNMENT);
		jPRoot.add(jBCalcular);
		jLResultado.setAlignmentX(Component.CENTER_ALIGNMENT);
		jPRoot.add(jLResultado);
		add(jPRoot, BorderLayout.CENTER);
		// getContentPane().setLayout(new BorderLayout());
		pack();
	}

	public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
		} catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		
		java.awt.EventQueue.invokeLater(new Runnable(){
		
			@Override
			public void run() {
				new VistaInterfaz().setVisible(true);
			}
		});
		
	}

	private JPanel jPRoot;
	private JPanel jPForm;
	private JLabel jLAltura;
	private JLabel jLPeso;
	private JTextField jTFAltura;
	private JTextField jTFPeso;
	private JButton	jBCalcular;
	private JLabel jLResultado;
}