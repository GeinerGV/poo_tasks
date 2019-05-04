package components;

import java.util.ArrayList;

import javax.swing.JComboBox;

import xml.PaisesParser;

/**
 * JListaPaises
 */
public class JListaPaises extends JComboBox<String> {

	private static final long serialVersionUID = 2958156257188013413L;

	private static final ArrayList<String> paises = PaisesParser.getAllPaisesList();

	public JListaPaises() {
		super(paises.toArray(new String[paises.size()]));
		insertItemAt("", 0);
		setSelectedIndex(0);
		setEditable(true);
	}

	@Override
	public String getSelectedItem() {
		return (String)super.getSelectedItem();
	}
	
}