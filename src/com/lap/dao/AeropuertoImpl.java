package com.lap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lap.dto.AeropuertoDTO;
import com.lap.dto.PanelDTO;
import com.lap.dto.VueloDTO;

//public class AeropuertoImpl implements AeropuertoIF {
/*
 * Esta clase tiene los metodos necesario para poder  obtener una conexion
 * y hacer operaciones (por ejemplo consultas)  a la
 *  base de datos facilitodb, desde nuestra aplicacion java
 *  
 */
public class AeropuertoImpl{
	
	Connection conn = null;

	//String url = "jdbc:mysql://127.0.0.1:3306/facilitodb";
	String url = "jdbc:mysql://mysql.freehostia.com/geigra_gegeve";
						
	// String url = "jdbc:mysql://poo_user:Zk12_Tlp9Dkad7ODzO3C@localhost:3306/facilitodb";
	public AeropuertoImpl() {
		// Cargar el driver
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		} catch ( Exception e) {
			System.out.println("No se pudo cargar el driver");
		}
	}
	
	private Connection getConnection() {
		try {
			//conn = DriverManager.getConnection(url, "root", "facilito");
			conn = DriverManager.getConnection(url, "geigra_gegeve", "RaW:XT.r!cH=pVovd6d'");
		} catch (SQLException e) {
			System.out.println("No se pudo otener conexion");
			e.printStackTrace();
		}
		return conn;
	}

	public List getAllVuelos() {
		// Variables SQL
		Statement stmt = null;
		List vuelos = new ArrayList();
		
		// Crear la sentencia SQL
		String sql = "SELECT * FROM tbvuelos ORDER BY 1 ASC";
			try {
				this.getConnection();
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				// Procesar el resultset
				while ( rs.next() ) {
					PanelDTO p = new PanelDTO();
					p.setId( rs.getInt(1));
					p.setOrigen( rs.getString(2) );
					p.setDestino( rs.getString(3) );
					p.setNumero( rs.getString(4) );
					p.setAsientos( rs.getInt(5) );
					
					vuelos.add(p);
				}
				
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return vuelos;
	}

	public List getAllAeropuertos() {
		Statement stmt = null;
		List<AeropuertoDTO> aeropuertos = new ArrayList<AeropuertoDTO>();
		String sql = "SELECT * FROM tbaeropuertos ORDER BY 1 ASC;";
		try {
			this.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				AeropuertoDTO aDto = new AeropuertoDTO();
				aDto.setCodigo( rs.getString(1) );
				aDto.setNombre( rs.getString(2 ));
				aDto.setCiudad( rs.getString(3));
				aDto.setPais( rs.getString(4) );
				aeropuertos.add(aDto);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aeropuertos;
	}

	public String[] getAllColumnsVuelos() {
		Statement stmt = null;
		ResultSet rs;
		String sql = "SELECT Column_name  FROM Information_schema.columns  WHERE Table_name='tbvuelos';";
		List<String> nombres = new ArrayList<String>();
		try {
			this.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				nombres.add( rs.getString(1) );
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String[] listNames = new String[nombres.size()];
		for (int i = 0; i < nombres.size(); i++) {
			listNames[i] = nombres.get(i);
		}
		return listNames;
	}

	public String[] getAllAeropuertosNamesWithId() {
		Statement stmt = null;
		ResultSet rs;
		String sql = "SELECT codigo, nombre FROM tbaeropuertos ORDER BY 1 ASC;";
		List<String> nombres = new ArrayList<String>();
		try {
			this.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				nombres.add( rs.getString("nombre") + " (" + rs.getString("codigo") +")" );
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String[] listNames = new String[nombres.size()];
		for (int i = 0; i < nombres.size(); i++) {
			listNames[i] = nombres.get(i);
		}
		return listNames;
	}

	public Object[][] getDataTableModel() {
		Statement stmt = null;
		ResultSet rs;
		String sql = "SELECT * FROM tbvuelos ORDER BY 1 ASC;";
		List<Object[]> filas = new ArrayList<Object[]>();
		Object[] fila = new Object[7];
		try {
			this.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				fila[0] = rs.getInt(1);
				fila[1] = rs.getString(2);
				fila[2] = rs.getString(3);
				fila[3] = rs.getString(4);
				fila[4] = rs.getInt(5);
				fila[5] = rs.getInt(6);
				fila[6] = rs.getInt(7);
				filas.add(fila.clone());
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Object[][] arrFilas = new Object[filas.size()][7];
		for (int i = 0; i < filas.size(); i++) {
			arrFilas[i] = filas.get(i);
		}
		return arrFilas;
	}

	public int insertarVuelo(VueloDTO vuelo) {

		PreparedStatement stmt = null;
                int res = 1;
		
		// Crear la sentencia SQL
		String sql = "insert into tbvuelos (origen, destino, numero, asientos,disponibles,preciounit) values (?,?,?,?,?,?);";
			try {
				this.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, vuelo.getOrigen());
				stmt.setString(2, vuelo.getDestino());
				stmt.setString(3, getNumVuelo(vuelo.getAerolinea()));
				stmt.setInt(4, vuelo.getAsientos());
				stmt.setInt(5, vuelo.getDisponibles());
				stmt.setInt(6, vuelo.getPrecio());
				stmt.executeUpdate();
				stmt.close();                
				conn.close();
			} catch (SQLException e) {
                res=0;
				e.printStackTrace();
			}
            return res;           
	}

	public String getNumVuelo(String laAerolinea) {
		PreparedStatement stmt = null;
		ResultSet rs;
		String sql = "SELECT COUNT(numero) FROM tbvuelos WHERE numero LIKE CONCAT(?,'%');";
		String result = laAerolinea + "-";
		try {
			this.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, laAerolinea);
			rs = stmt.executeQuery();
			if (rs.next()) {
				int n = rs.getInt(1);
				result += (int)(n+101);
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("error getVuelo");
			e.printStackTrace();
			result += 101;
		}
		return result;
	}

	public String[] getAllAerolineasNamesWithId() {
		Statement stmt = null;
		ResultSet rs;
		String sql = "SELECT la, nombre FROM tbaerolineas ORDER BY 1 ASC;";
		List<String> nombres = new ArrayList<String>();
		try {
			this.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				nombres.add( rs.getString("nombre")+" ("+rs.getString("la")+")" );
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String[] listNames = new String[nombres.size()];
		for (int i = 0; i < nombres.size(); i++) {
			listNames[i] = nombres.get(i);
		}
		return listNames;
	}

	public String getCompania(String codigo) {
		PreparedStatement stmt = null;
		String nombre ="";
		ResultSet  rs;
		
		// Crear la sentencia SQL
		String sql = "SELECT nombre FROM tbaerolineas WHERE LA = ?";
			try {
				this.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, codigo);
				rs = stmt.executeQuery();
				
				while (rs.next() ) {
					nombre = rs.getString(1);
				}
				rs.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("getCompania: " + e.getLocalizedMessage() );
				e.printStackTrace();
			}
		return nombre;
	}

	public AeropuertoDTO getAeropuerto(String codigo) {

		PreparedStatement stmt = null;
		ResultSet  rs;
		AeropuertoDTO a = new AeropuertoDTO();
		
		// Crear la sentencia SQL
		String sql = "SELECT * FROM tbaeropuertos WHERE codigo=?";
			try {
				this.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, codigo);
				
				rs = stmt.executeQuery();
				while (rs.next() ) {
					a.setCodigo( codigo );
					a.setNombre( rs.getString(2 ));
					a.setCiudad( rs.getString(3));
					a.setPais( rs.getString(4) );
				}
				rs.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("*** " + e.getLocalizedMessage() );
				e.printStackTrace();
			}
			return a;
	}

}
