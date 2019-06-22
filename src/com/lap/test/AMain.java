package com.lap.test;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.lap.dao.AeropuertoImpl;
import com.lap.dto.AeropuertoDTO;
import com.lap.dto.PanelDTO;

public class AMain {

	public static void main(String[] args) {
		AMain am = new AMain();
		am.generaPanel();
	}
	
	public void generaPanel() {
		String[] estados = new String[] {"EN VUELO", "DEMORADO", "ATERRIZO", "CRASHED","ULTIMA LLAMADA"};
		
		AeropuertoImpl impl = new AeropuertoImpl(); // las operaciones a las tablas en la b.d. estan aqui
		List objVuelos =  impl.getAllVuelos(); //  obtenemos los vuelos de la table tbvuelos

		for (int i=0; i < objVuelos.size(); i++ ) {
			PanelDTO panel = (PanelDTO)objVuelos.get(i); // la lista objvuelos retorna de manera generica Object
													// a traves del metodo get(i)
													// pero como sabemos que el objeto retornado es de tipo PanelDTO
													// lo convertimos a PanelDTO haciendo un cast:
													// PanelDTO p = (PanelDTO)objVuelos.get(i)
			

			// Cargar codigos:  ejemplo pais, cia
			 
			AeropuertoDTO objAeropuertoOrigen = (AeropuertoDTO)impl.getAeropuerto( panel.getOrigen());
			AeropuertoDTO objAeropuertoDestino = (AeropuertoDTO)impl.getAeropuerto( panel.getDestino());
			
			panel.setOpais(objAeropuertoOrigen.getPais());
			panel.setDpais(objAeropuertoDestino.getPais());

			// otra forma equivalente de hacer las 4 lineas arriba :)
			//panel.setOpais( ((AeropuertoDTO)aero.getAeropuerto( panel.getOrigen())).getPais());
			//panel.setDpais( ((AeropuertoDTO)aero.getAeropuerto( panel.getDestino())).getPais());
			
			// Carga compania ( son los 2 primeros caracteres del vuelo )
			String cia = panel.getNumero().substring(0,2);
			
			panel.setCompania( impl.getCompania(cia));
			
			// setear el Gate
			int maxValor = 20;
			int minValor = 1;
			
			panel.setGate( (int)( (maxValor - minValor + 1) * Math.random() ) + minValor );
			
			// Setear el estado
			int est = (int)( (4 - 0 + 1) * Math.random() ) + 0 ;
			panel.setEstado( estados[est] );
			
			// Pintar el panel ...
			System.out.println(panel);
			
		}
		
	}

}
