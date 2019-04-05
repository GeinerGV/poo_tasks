package edu.usil.facilito01.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

/**
 * VistaEjemploIF
 */
public class VistaEjemploIF extends JFrame {

	private static final long serialVersionUID = 1L;

	public VistaEjemploIF() {
		initComponents();
	}

	public void initComponents() {
		jPRoot = new JPanel();
		jTFNota = new JTextField();
		jBEvaluarNota = new JButton("Evaluar Nota");
		jCBGenerarNota = new JCheckBox();
		jLMensaje = new JLabel(" ");

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setTitle("Evaluar Nota");
		jCBGenerarNota.setText("Generar nota");
		// jCBGenerarNota.setSelected(true);

		jCBGenerarNota.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean sel = jCBGenerarNota.isSelected();
				if (sel) {
					jBEvaluarNota.setText("Evaluar NUEVA Nota");
					jTFNota.setEnabled(false);
					pack();
				} else {
					jTFNota.setEnabled(true);
					jBEvaluarNota.setText("Evaluar Nota");
					pack();
				}
			}
		});

		jBEvaluarNota.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				int nota;
				String tmpNota;
				if (jCBGenerarNota.isSelected()) {
					tmpNota = "" + (int)(Math.random()*20.0);
					jTFNota.setText(tmpNota);
				} else {
					tmpNota = jTFNota.getText().trim();
				}
				
				if (tmpNota.length()>0) {
					try {
						nota = Integer.parseInt(jTFNota.getText());
						if (nota<0 || nota>20) throw new IndexOutOfBoundsException("La nota debe de ser entre 0 y 20");
						String str = "Tu nota es: " + nota + ". ";
						str += nota>=11 ?  "Aprobaste".toUpperCase() : "Desaprobaste".toUpperCase();
						jLMensaje.setText(str);
					} catch (IndexOutOfBoundsException ex) {
						jLMensaje.setText(ex.getMessage());
					} catch (Exception ex) {
						jLMensaje.setText("Ingrese un número correcto.");
					}
				} else {
					jLMensaje.setText("Ingrese una nota");
				}
			}
		});

		

		add(jPRoot);
		GroupLayout layout = new GroupLayout(jPRoot);
		jPRoot.setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.CENTER)
			.addGroup(
				layout.createSequentialGroup()
				.addComponent(jTFNota, 150, GroupLayout.DEFAULT_SIZE, 300)
				.addGap(15)
				.addComponent(jBEvaluarNota, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			)
			.addComponent(jCBGenerarNota, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			.addComponent(jLMensaje)
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.CENTER)
			.addGroup(
				layout.createSequentialGroup()
				.addGroup(
					layout.createParallelGroup()
					.addComponent(jTFNota, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(jBEvaluarNota, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				)
				.addComponent(jCBGenerarNota, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addComponent(jLMensaje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			)
		);
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
            java.util.logging.Logger.getLogger(VistaEjemploIF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaEjemploIF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaEjemploIF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaEjemploIF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		
		java.awt.EventQueue.invokeLater(new Runnable(){
		
			@Override
			public void run() {
				new VistaEjemploIF().setVisible(true);
			}
		});

	}

	private JPanel jPRoot;
	private JTextField jTFNota;
	private JButton jBEvaluarNota;
	private JCheckBox jCBGenerarNota;
	private JLabel	jLMensaje;
}