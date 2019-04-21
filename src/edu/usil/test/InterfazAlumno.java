package edu.usil.test;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

import org.w3c.dom.ranges.RangeException;

import edu.usil.bean.Alumno;

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
		jLapellido = new JLabel("Apellidos:");
		jTFapellido = new JTextField();
		jLciclo = new JLabel("Ciclo:");
		jTFciclo = new JTextField();
		jBcrearAlumno = new JButton("Ingresar");
		jBverTodos = new JButton("Listar");
		jTAmostrarTexto = new JTextArea(5, 30);
		jLdesc = new JLabel("Complete los espacios en blanco");
		jSPtexto = new JScrollPane(jTAmostrarTexto);

		setTitle("Añadir alumnos a un arreglo");
		setDefaultCloseOperation(EXIT_ON_CLOSE);



		jBcrearAlumno.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String code = jTFcodigo.getText().trim();
				String name = jTFnombre.getText().trim();
				String surname = jTFapellido.getText().trim();
				String cicloStr = jTFciclo.getText().trim();
				if (code.length()>0 && name.length()>0 && surname.length()>0 && cicloStr.length()>0){
					int ciclo;
					try {
						ciclo = Integer.parseInt(cicloStr);
						if (ciclo<0 || ciclo>10) throw new RangeException((short) 1, "El ciclo debe estar entre 0 y 10");
						alumnos.add(new Alumno(code, name, surname, ciclo));
						jTAmostrarTexto.setText("Último alumno ingresado:\n"+alumnos.get(alumnos.size()-1));
						pack();
					} catch (NumberFormatException e) {
						jLdesc.setText("El ciclo necesita ser un número entero");
					} catch (Exception e) {
						jLdesc.setText(e.getMessage());
					}
				} else {
					jLdesc.setText("Complete los espacios en blanco");
				}
			}
		});

		jBverTodos.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (alumnos.size()>0) {
					String texto = "";
					int i=0;
					for (Alumno alumno : alumnos) {
						i++;
						texto += "Estudiante "+i+":\n";
						texto += alumno;
						texto += "\n\n";
					}
					texto = texto.substring(0, texto.length()-2);
					jTAmostrarTexto.setText(texto);
				} else {
					jTAmostrarTexto.setText("No se ha agregado ningún estudiante todavía.");
					pack();
				}
			}
		});
		
		jLapellido.setLabelFor(jTFcodigo);
		jLapellido.setLabelFor(jTFnombre);
		jLapellido.setLabelFor(jTFapellido);
		jLapellido.setLabelFor(jTFciclo);
		jPform.add(jLcodigo);
		jPform.add(jTFcodigo);
		jPform.add(jLnombre);
		jPform.add(jTFnombre);
		jPform.add(jLapellido);
		jPform.add(jTFapellido);
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
					.addComponent(jPform, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addComponent(jBcrearAlumno)
				)
				.addContainerGap()
				.addGroup(gLayout.createParallelGroup(Alignment.CENTER)
					.addComponent(jBverTodos)
					.addComponent(jSPtexto)
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
				.addComponent(jSPtexto)
			)
		);
		add(jLdesc, BorderLayout.NORTH);
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
	private JTextField jTFapellido;
	private JLabel jLciclo;
	private JTextField jTFciclo;
	private JButton jBcrearAlumno;
	private JButton jBverTodos;
	private JTextArea jTAmostrarTexto;
	private JLabel jLdesc;
	private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	private JScrollPane jSPtexto;
}
