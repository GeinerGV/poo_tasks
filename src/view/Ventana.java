package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout.Alignment;

import bean.Boleta;
import bean.Comprobante;
import bean.Factura;
import test.Tester;

public class Ventana extends JFrame {

	private static final long serialVersionUID = -8823178631194199148L;
	private static final int num_empresas = 2;
	private static final int comprobantes_por_empresa = 10;

	private static ArrayList<String> empresas = new ArrayList<String>();
	private static ArrayList<String> rucs = new ArrayList<String>();
	private static Comprobante[][] comprobantes = new Comprobante[num_empresas][comprobantes_por_empresa];

	public Ventana() {
		initComponents();
	}

	private void initComponents() {
		jPBotones = new JPanel();
		jBGenerar = new JButton("Generar");
		jBListar = new JButton("Listar");
		jTAResultados = new JTextArea(3, 45);
		jSPResultados = new JScrollPane(jTAResultados);


		setTitle("Dr. Tejes y Manejes");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		jTAResultados.setMargin(new Insets(10, 10, 10, 10));


		jBGenerar.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				empresas.clear();
				rucs.clear();

				Comprobante base;
				Comprobante comprobante;
				for (int i = 0; i < num_empresas; i++) {
					getEmpresa();
				}
				for (int i = 0; i < num_empresas; i++) {
					base = new Comprobante(rucs.get(i), empresas.get(i));
					// System.out.println(base);
					for (int j = 0; j < (comprobantes_por_empresa); j++) {
						if (Math.random()>0.5) {
							comprobante = new Factura(base);
							((Factura) comprobante).setRazon_cliente(getEmpresa());
							((Factura) comprobante).setRuc_cliente(getRuc(((Factura) comprobante).getRazon_cliente()));
							((Factura) comprobante).setMonto(Tester.getMonto());
						} else {
							comprobante = new Boleta(base);
							((Boleta) comprobante).setNombre_cliente(Tester.getNombre());
							((Boleta) comprobante).setMonto(Tester.getMonto());
						}
						comprobante.setFecha(Tester.getDate());
						comprobantes[i][j] = comprobante;
					}
				}
			}
		});

		jBListar.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String resultado = "";
				for (int i = 0; i < comprobantes.length; i++) {
					for (int j = 0; j < comprobantes[i].length; j++) {
						resultado += "Comprobante " + (i*comprobantes_por_empresa+j)+" = ";
						resultado += comprobantes[i][j];
						resultado += "\n";
					}
					resultado += "\n";
				}
				jTAResultados.setText(resultado);
			}
		});


		GroupLayout layout = new GroupLayout(jPBotones);
		jPBotones.setLayout(layout);

		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.CENTER)
			.addComponent(jBGenerar)
			.addComponent(jBListar)
			// .addGroup(Alignment.CENTER, 
			// 	layout.createSequentialGroup()
			// 	.addGap(10)
			.addComponent(jSPResultados)
				// .addGap(10)
			// )
		);

		layout.setVerticalGroup(
			layout.createSequentialGroup()
			.addContainerGap()
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

	private static String getEmpresa() {
		String next;
		next = Tester.getEmpresa();
		while (empresas.contains(next) && empresas.indexOf(next)<num_empresas) {
			next = Tester.getEmpresa();
		}
		if (!empresas.contains(next)) {
			empresas.add(next);
			rucs.add(Tester.getRuc());
		}
		return next;
	}

	private static String getRuc(String empresa) {
		if (empresas.contains(empresa)) {
			return rucs.get(empresas.indexOf(empresa));
		}
		return "";
	}

	private JPanel jPBotones;
	private JButton jBGenerar;
	private JButton jBListar;
	private JTextArea jTAResultados;
	private JScrollPane jSPResultados;
}