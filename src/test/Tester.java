package test;

import java.util.Date;

import view.Ventana;

/**
 * Tester
 */
public class Tester {

	public static String getRuc() {
		String ruc = "";
		ruc += Math.random()>0.5 ? '2' : '1';
		ruc += '0';
		for (int i = 0; i < 9; i++) {
			ruc += (int)(Math.random()*9.9);
		}
		return ruc;
	}

	private static String[] empresas = {"PETROPERÚ", "CREDICORP", "REFINERÍA LA PAMPILLA S.A.A.", "FALABELLA PERÚ", "SOCIEDAD MINERA CERRO VERDE", "CÍA. MINERA ANTAMINA", "ESSALUD", "MINERA LAS BAMBAS", "TELEFÓNICA DEL PERÚ", "INRETAIL PERÚ CORP. y SUB.", "BANCO DE CRÉDITO DEL PERÚ", "SOUTHERN PERU COPPER CORP. / DEL GRUPO MÉXICO", "PRIMAX", "ALICORP", "GRAÑA Y MONTERO", "AMÉRICA MÓVIL PERÚ - CLARO", "CENCOSUD", "FERREYCORP", "SUPERMERCADOS PERUANOS", "TRAFIGURA PERÚ", "BBVA BANCO CONTINENTAL", "UCP BACKUS Y JOHNSTON", "INTERCORP PERÚ", "GLENCORE", "CÍA. DE MINAS BUENAVENTURA y SUB."};

	private static String[][] nombres = {{"Juan", "Pedro", "Martín", "Carlos", "Antonio", "Marcos", "Franco"}, {"Marta", "Lucía", "Belén", "Judith", "Mayte", "Berta", "María"}};

	private static String[] apellidos = {"Gonzales", "Fernandez", "Hernandez", "Pinedo", "Chavez", "Martinez", "Acosta", "Diaz"};

	public static String getNombre() {
		int num = Math.random()>0.5 ? 0 : 1;
		String nombre = "";
		
		for (int i = 0; i < 2; i++) {
			if (i>0) nombre+= " ";
			nombre += apellidos[(int)( Math.round(Math.random() * (apellidos.length-1)) )];
		}
		nombre += ",";
		for (int i = 0; i < (int)(Math.round(Math.random()) + 1); i++) {
			nombre += " " + nombres[num][(int)( Math.round(Math.random() * (nombres[num].length-1)) )];
		}
		return nombre;	
	}

	public static String getDate() {
		Date fch = new Date();
		int year = fch.getYear();
		int mes = fch.getMonth();
		if (mes==0) {
			year -= 1;
			mes = 12;
		}
		mes = (int)(Math.round(Math.random()*(mes+0.49))+1);
		int dia = mes == 1 ? 28 : 30;
		dia = (int)(Math.round(Math.random()*dia));
		return dia+"/"+mes+"/"+(year+"").substring(1);
	}


	public static String getEmpresa() {
		return empresas[(int)( Math.round(Math.random() * (empresas.length-1)) )];
	}

	public static double getMonto() {
		return Math.random()*1000+0.1;
	}

	public static void main(String[] args) {
		new Ventana().setVisible(true);
	}
}