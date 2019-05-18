package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout.Alignment;

public class Ventana extends JFrame {

	public Ventana() {
		initComponents();
	}

	public void initComponents() {
		jPBotones = new JPanel();
		jBGenerar = new JButton("Generar");
		jBListar = new JButton("Listar");
		jTAResultados = new JTextArea(3, 50);
		jSPResultados = new JScrollPane(jTAResultados);


		setTitle("Dr. Tejes y Manejes");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		GroupLayout layout = new GroupLayout(jPBotones);
		jPBotones.setLayout(layout);

		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.CENTER)
			.addComponent(jBGenerar)
			.addComponent(jBListar)
			.addComponent(jSPResultados)
		);

		layout.setVerticalGroup(
			layout.createSequentialGroup()
			.addComponent(jBGenerar)
			.addGap(10)
			.addComponent(jBListar)
			.addGap(20)
			.addComponent(jSPResultados)
		);

		add(jPBotones, BorderLayout.CENTER);

		setMinimumSize(new Dimension(600, 250));
		
		pack();
	}

	private JPanel jPBotones;
	private JButton jBGenerar;
	private JButton jBListar;
	private JTextArea jTAResultados;
	private JScrollPane jSPResultados;
}