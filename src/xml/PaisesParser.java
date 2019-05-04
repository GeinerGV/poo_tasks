package xml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

/**
 * PaisesParser
 */
public class PaisesParser {

	static final String PAIS = "pais";
	static final String P_ID = "id";

	private static String pathSrcFile = "src/resources/PaisesDefault.xml";

	public static ArrayList<String> getAllPaisesList() {
		ArrayList<String> listaPaises = new ArrayList<String>();
		try {
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			InputStream in = new FileInputStream(pathSrcFile);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				if (event.isStartElement()){
					if (event.asStartElement().getName().getLocalPart().equals(PAIS)){
						event = eventReader.nextEvent();
						listaPaises.add(event.asCharacters().getData());
					}
				}
			}
		} catch (Exception e) {
			//TODO: handle exception
		}
		return listaPaises;
	}
}