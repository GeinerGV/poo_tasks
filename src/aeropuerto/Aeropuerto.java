package aeropuerto;

import com.lap.dao.AeropuertoImpl;
import com.lap.dto.VueloDTO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
// import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;

public class Aeropuerto extends JFrame {

	private static final long serialVersionUID = 1L;
	private String[] arrAeropuertos;
	private String[] arrAerolineas;
	private String[] arrColumnasVuelo;
	// private List<AeropuertoDTO> listaADtos;
	private int[] selAeroItems = {0, 0};
	
	public Aeropuerto() {
		AeropuertoImpl impl = new AeropuertoImpl();
		arrAeropuertos = impl.getAllAeropuertosNamesWithId();
		arrAerolineas = impl.getAllAerolineasNamesWithId();
		arrColumnasVuelo = impl.getAllColumnsVuelos();
		// listaADtos = impl.getAllAeropuertos();

		setTitle("Registro de Vuelos");
		initComponents();
	}

	private void initComponents() {
		jPRegistrarVuelo = new JPanel();
		jLTitle = new JLabel();
		jLOrigen = new JLabel();
		jCBOrigen = new JComboBox<>();
		jLDestino = new JLabel();
		jCBDestino = new JComboBox<>();
		jLNumero = new JLabel();
		jCBAerolineas = new JComboBox<>();
		jLAsientos = new JLabel();
		jTFAsientos = new JTextField();
		jLAsientosDisponibles = new JLabel();
		jTFAsientosDisponibles = new JTextField();
		jLPrecioUnitario = new JLabel();
		jTFPrecioUnitario = new JTextField();
		jBRegistrar = new JButton();
		jLResultado = new JLabel();

		jPVerVuelos = new JPanel();
		jBVerTodo = new JButton("Ver Todo");
		jTblVuelos = new JTable(new Object[][] {{"", "", "", "", "", "", ""}}, arrColumnasVuelo);
		jSPVuelos = new JScrollPane(jTblVuelos);
		jTblVuelos.setFillsViewportHeight(true);


		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jCBOrigen.setModel(new DefaultComboBoxModel<>(arrAeropuertos));
		jCBOrigen.insertItemAt("Seleccione un aeropuerto", 0);
		jCBOrigen.setSelectedIndex(0);
		jCBDestino.setModel(new DefaultComboBoxModel<>(arrAeropuertos));
		jCBDestino.insertItemAt("Seleccione un aeropuerto", 0);
		jCBDestino.setSelectedIndex(0);
		jCBAerolineas.setModel(new DefaultComboBoxModel<>(arrAerolineas));
		jCBAerolineas.insertItemAt("- Aerolinea -", 0);
		jCBAerolineas.setSelectedIndex(0);

		jLTitle.setText("Formulario de Registro de vuelos");
		jLOrigen.setText("Origen:");
		jLDestino.setText(("Destino:"));
		jLNumero.setText("Número:");
		jLAsientos.setText("Cantidad de asientos:");
		jLAsientosDisponibles.setText("Cantidad de asientos disponibles");
		jLPrecioUnitario.setText("Percio por cada asiento");
		jBRegistrar.setText("Registrar");
		jLResultado.setText(" ");

		jCBOrigen.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// System.out.println(arg0.getSource().equals(jCBOrigen));
				aeropuertoActionPerformed(arg0);
			}
		});
		jCBDestino.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				aeropuertoActionPerformed(e);
			}
		});

		jBRegistrar.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int selOrigen = jCBOrigen.getSelectedIndex();
				int selDest = jCBDestino.getSelectedIndex();
				int selAerolinea = jCBAerolineas.getSelectedIndex();
				String tAsientos = jTFAsientos.getText().trim();
				String aDisponibles = jTFAsientosDisponibles.getText().trim();
				String precio = jTFPrecioUnitario.getText().trim();

				// System.out.println(selOrigen+"\t"+selDest+"\t"+selAerolinea+"\t"+tAsientos+
				// "\t"+aDisponibles+"\t"+precio);

				if (selOrigen>0 && selDest>0 && selAerolinea>0 && tAsientos.length()>0 
				&& aDisponibles.length()>0 && precio.length()>0) {
					// System.out.println("datos completos");
					int numAsientos = 0;
					int numDisponibles = 0;
					int monto = 0;
					try {
						numAsientos = Integer.parseInt(tAsientos);
						numDisponibles = Integer.parseInt(aDisponibles);
						monto = Integer.parseInt(precio);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					if (numAsientos>0 && numDisponibles>0 && monto>0 && numDisponibles<=numAsientos) {
						AeropuertoImpl impl = new AeropuertoImpl();
						// int res
						VueloDTO vueloDTO = new VueloDTO();
						try {
							vueloDTO.setOrigen(arrAeropuertos[selAeroItems[0]]);
							vueloDTO.setDestino(arrAeropuertos[selAeroItems[1]]);
							vueloDTO.setAerolinea((String)jCBAerolineas.getSelectedItem());
							vueloDTO.setAsientos(numAsientos);
							vueloDTO.setDisponibles(numDisponibles);
							vueloDTO.setPrecio(monto);
						} catch (Exception e) {
							e.printStackTrace();
						}
						int res = impl.insertarVuelo(vueloDTO);
						if (res==1) {
							jLResultado.setText("Ingreso exitoso");
							jCBOrigen.setSelectedIndex(0);
							jCBDestino.setSelectedIndex(0);
							jCBAerolineas.setSelectedIndex(0);
							jTFAsientos.setText("");
							jTFAsientosDisponibles.setText("");
							jTFPrecioUnitario.setText("");
							verTodo();
						}
					}
				}
			}
		});

		jBVerTodo.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				verTodo();
			}
		});


		// Ubicar elementos
		GroupLayout jPLayoutRegistrar = new GroupLayout(jPRegistrarVuelo);
		jPRegistrarVuelo.setLayout(jPLayoutRegistrar);
		jPLayoutRegistrar.setHorizontalGroup(
			jPLayoutRegistrar.createParallelGroup(GroupLayout.Alignment.CENTER)
			.addComponent(jLTitle)
			.addGroup(
				jPLayoutRegistrar.createSequentialGroup()
				.addGroup(
					jPLayoutRegistrar.createParallelGroup(GroupLayout.Alignment.TRAILING)
					.addComponent(jLOrigen)
					.addComponent(jLDestino)
					.addComponent(jLNumero)
					.addComponent(jLAsientos)
					.addComponent(jLAsientosDisponibles)
					.addComponent(jLPrecioUnitario)
				).addGap(10)
				.addGroup(
					jPLayoutRegistrar.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(jCBOrigen, 200, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(jCBDestino, 200, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(jCBAerolineas, 100, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(jTFAsientos, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addComponent(jTFAsientosDisponibles, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addComponent(jTFPrecioUnitario, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
				)
			)
			.addComponent(jBRegistrar)
			.addComponent(jLResultado)
			.addComponent(jBVerTodo)
			.addComponent(jSPVuelos)
		);
		jPLayoutRegistrar.setVerticalGroup(
			jPLayoutRegistrar.createSequentialGroup()
			.addComponent(jLTitle)
			.addGap(10)
			.addGroup(jPLayoutRegistrar.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addComponent(jLOrigen)
				.addComponent(jCBOrigen)
			).addGap(5)
			.addGroup(jPLayoutRegistrar.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addComponent(jLDestino)
				.addComponent(jCBDestino)
			).addGap(5)
			.addGroup(jPLayoutRegistrar.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addComponent(jLNumero)
				.addComponent(jCBAerolineas)
			).addGap(5)
			.addGroup(jPLayoutRegistrar.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addComponent(jLAsientos)
				.addComponent(jTFAsientos)
			).addGap(5)
			.addGroup(jPLayoutRegistrar.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addComponent(jLAsientosDisponibles)
				.addComponent(jTFAsientosDisponibles)
			).addGap(5)
			.addGroup(jPLayoutRegistrar.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addComponent(jLPrecioUnitario)
				.addComponent(jTFPrecioUnitario)
			).addGap(10)
			.addComponent(jBRegistrar)
			.addGap(5)
			.addComponent(jLResultado)
			.addGap(15)
			.addComponent(jBVerTodo)
			.addGap(5)
			.addComponent(jSPVuelos)//, 75, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			
		);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
			layout.createSequentialGroup()
			.addContainerGap()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addComponent(jPRegistrarVuelo)
				.addComponent(jPVerVuelos)
			)
			.addContainerGap()
		);
		layout.setVerticalGroup(
			layout.createSequentialGroup()
			.addContainerGap()
			.addComponent(jPRegistrarVuelo)
			.addGap(25)
			.addComponent(jPVerVuelos)
			.addContainerGap()
		);
		pack();
	}

	private void verTodo() {
		AeropuertoImpl impl = new AeropuertoImpl();
		jTblVuelos.setModel(new DefaultTableModel(impl.getDataTableModel(), arrColumnasVuelo));
	}

	private void aeropuertoActionPerformed(ActionEvent evt) {
		JComboBox<String> jComboBoxSel = null;
		JComboBox<String> jComboBox = null;
		int posChange = -1;
		if (evt.getSource().equals(jCBOrigen)) {
			jComboBoxSel = jCBOrigen;
			jComboBox = jCBDestino;
			posChange = 0;
		} else if (evt.getSource().equals(jCBDestino)) {
			jComboBoxSel = jCBDestino;
			jComboBox = jCBOrigen;
			posChange = 1;
		}

		if (selAeroItems[posChange]!=jComboBoxSel.getSelectedIndex()) {
			if (selAeroItems[posChange]>0) jComboBox.insertItemAt(arrAeropuertos[selAeroItems[posChange]-1], selAeroItems[posChange]);
			selAeroItems[posChange] = jComboBoxSel.getSelectedIndex();
			if (jComboBoxSel.getSelectedIndex()>0) {
				jLResultado.setText("");
				if (selAeroItems[(posChange+1)%2]>0 && jComboBoxSel.getSelectedIndex()>=selAeroItems[(posChange+1)%2]) selAeroItems[posChange] += 1;
				jComboBox.removeItemAt(selAeroItems[posChange]);
			}
		}
	}

	/* private TableModel setNewTableModel() {
		DefaultTableModel newModel = new DefaultTableModel(arrColumnasVuelo);
	} */

	public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Aeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Aeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Aeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Aeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Aeropuerto().setVisible(true);
			}
		});
	}

	private JPanel jPRegistrarVuelo;
	private JLabel jLTitle;
	private JLabel jLOrigen;
	private JLabel jLDestino;
	private JLabel jLNumero;
	private JLabel jLAsientos;
	private JLabel jLAsientosDisponibles;
	private JLabel jLPrecioUnitario;
	private JLabel jLResultado;
	private JComboBox<String> jCBOrigen;
	private JComboBox<String> jCBDestino;
	private JComboBox<String> jCBAerolineas;

	private JTextField jTFAsientos;
	private JTextField jTFAsientosDisponibles;
	private JTextField jTFPrecioUnitario;

	private JButton jBRegistrar;
	
	private JPanel jPVerVuelos;
	private JTable jTblVuelos;
	private JScrollPane jSPVuelos;
	private JButton jBVerTodo;

}