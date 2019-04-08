package star.wars.tester;

import fuerzas.imperiales.ClonTrooper;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class InterfazCT extends JFrame {
	private static final long serialVersionUID = 5081894783141919281L;

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
		jTARespuesta = new JTextArea(3, 10);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("StarWars");

		jBRenerarCT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String strjTFRango = jTFRango.getText().trim();
				String strjTFEspecialidad = jTFEspecialidad.getText().trim();
				String strjTFArmamento = jTFArmamento.getText().trim();
				if (strjTFRango.length()>0 && strjTFEspecialidad.length()>0 && strjTFArmamento.length()>0) {
					ClonTrooper ct = new ClonTrooper(strjTFRango, strjTFEspecialidad, strjTFArmamento);
					jTARespuesta.setText("Rango: "+strjTFRango+"\nEspecialidad: "+strjTFEspecialidad+"\nArmamento: "+strjTFArmamento);
				} else {
					jTARespuesta.setText("Ingrese los datos");
				}
			}
		});

		jPRoot.add(jLRango);
		jPRoot.add(jTFRango);
		jPRoot.add(jLEspecialidad);
		jPRoot.add(jTFEspecialidad);
		jPRoot.add(jLArmamento);
		jPRoot.add(jTFArmamento);
		jPRoot.setLayout(new GridLayout(3, 2));

		add(jPRoot, BorderLayout.CENTER);
		add(jBRenerarCT, BorderLayout.NORTH);
		add(jTARespuesta, BorderLayout.SOUTH);
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