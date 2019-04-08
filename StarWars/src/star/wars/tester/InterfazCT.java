package star.wars.tester;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class InterfazCT extends JFrame {
	public InterfazCT() {
		initComponents();
	}

	public void initComponents() {
		jPRoot = new JPanel();
		jLRango = new JLabel("Rango: ");
		jTFRango = new JTextField();
		jLEspecialidad = new JLabel("Especialidad: ");
		jTFEspecialidad = new JTextField();
		jLArmamento = new JLabel("Armamento: ");
		jTFArmamento = new JTextField();
		jBRenerarCT = new JButton("Generar CT");
		jTARespuesta = new JTextArea();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("StarWars");

		jPRoot.add(jLRango);
		jPRoot.add(jTFRango);
		jPRoot.add(jLEspecialidad);
		jPRoot.add(jTFEspecialidad);
		jPRoot.add(jLArmamento);
		jPRoot.add(jTFArmamento);
		jPRoot.setLayout(new GridLayout(2,2));

		JPanel container = getContentPane();

		add(jPRoot, BorderLayout.CENTER);
		add(jBRenerarCT, BorderLayout.CENTER);
		add(jTARespuesta, BorderLayout.CENTER);
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
            java.util.logging.Logger.getLogger(InterfazCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		
		java.awt.EventQueue.invokeLater(new Runnable(){
		
			@Override
			public void run() {
				new InterfazCT().setVisible(true);
			}
		});
	}

	private JPanel jPRoot;
	private JLabel jLRango;
	private JTextField jTFRango;
	private JLabel jLEspecialidad;
	private JTextField jTFEspecialidad;
	private JLabel jLArmamento;
	private JTextField jTFArmamento;
	private JButton jBRenerarCT;
	private JTextArea jTARespuesta;

}