package edu.usil.test;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

public class InterfazAlumno extends JFrame {
	private static final long serialVersionUID = 5081894783141919281L;
	
	public InterfazAlumno() {
		initComponents();
	}
	
	public void initComponents() {
		jPmain = new JPanel();
		jPform = new JPanel();
		jLcodigo = new JLabel("Código:");
		jTFcodigo = new JTextField();
		jLnombre = new JLabel("Nombre:");
		jTFnombre = new JTextField();
		jLapellido = new JLabel("Apellido:");
		jTFapelldio = new JTextField();
		jLciclo = new JLabel("Ciclo:");
		jTFciclo = new JTextField();
		jBcrearAlumno = new JButton("Crear Alumno");
		jBverTodos = new JButton("Ver a todos");
		jTAmostrarTexto = new JTextArea(5, 15);

		setTitle("Añadir alumnos a un arreglo");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jPform.add(jLcodigo);
		jPform.add(jTFcodigo);
		jPform.add(jLnombre);
		jPform.add(jTFnombre);
		jPform.add(jLapellido);
		jPform.add(jTFapelldio);
		jPform.add(jLciclo);
		jPform.add(jTFciclo);
		jPform.setLayout(new GridLayout(4, 2));
		
		GroupLayout gLayout = new GroupLayout(jPmain);
		jPmain.setLayout(gLayout);
		gLayout.setHorizontalGroup(
			gLayout.createParallelGroup(Alignment.CENTER)
			.addGroup(gLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(gLayout.createParallelGroup(Alignment.CENTER)
					.addComponent(jPform, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addComponent(jBcrearAlumno)
				)
				.addContainerGap()
				.addGroup(gLayout.createParallelGroup(Alignment.CENTER)
					.addComponent(jBverTodos)
					.addComponent(jTAmostrarTexto)
				)
				.addContainerGap()
			)
		);
		gLayout.setVerticalGroup(
			gLayout.createParallelGroup(Alignment.CENTER)
			.addGroup(gLayout.createSequentialGroup()
				.addComponent(jPform, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addComponent(jBcrearAlumno)
			)
			.addGroup(gLayout.createSequentialGroup()
				.addComponent(jBverTodos)
				.addComponent(jTAmostrarTexto)
			)
		);
		add(jPmain, BorderLayout.CENTER);
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
            java.util.logging.Logger.getLogger(InterfazAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		
		java.awt.EventQueue.invokeLater(new Runnable(){
		
			@Override
			public void run() {
				new InterfazAlumno().setVisible(true);
			}
		});
	}

	private JPanel jPmain;
	private JPanel jPform;
	private JLabel jLcodigo;
	private JTextField jTFcodigo;
	private JLabel jLnombre;
	private JTextField jTFnombre;
	private JLabel jLapellido;
	private JTextField jTFapelldio;
	private JLabel jLciclo;
	private JTextField jTFciclo;
	private JButton jBcrearAlumno;
	private JButton jBverTodos;
	private JTextArea jTAmostrarTexto;
}
