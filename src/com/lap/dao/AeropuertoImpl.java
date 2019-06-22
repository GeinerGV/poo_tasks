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

//public class AeropuertoImpl implements AeropuertoIF {
/*
 * Esta clase tiene los metodos necesario para poder  obtener una conexion
 * y hacer operaciones (por ejemplo consultas)  a la
 *  base de datos facilitodb, desde nuestra aplicacion java
 *  
 */
public class AeropuertoImpl{
	
	Connection conn = null;
        
	String url = "jdbc:mysql://mysql.freehostia.com/geigra_gegeve";

	public AeropuertoImpl() {
		// Cargar el driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		} catch ( Exception e) {
			System.out.println("No se pudo cargar el driver");
		}
	}
	
	private Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, "geigra_gegeve", "RaW:XT.r!cH=pVovd6d'");
		} catch (SQLException e) {
			System.out.println("No se pudo otener conexion");
			e.printStackTrace();
		}
		return conn;
	}

        
public List getAllAeropuertos() {
		// Variables SQL
		Statement stmt = null;
		List aeropuertos = new ArrayList();
		
		// Crear la sentencia SQL
		String sql = "SELECT * FROM tbaeropuertos ORDER BY 1 ASC";
			try {
				this.getConnection();
				stmt = conn.createStatement();
                                
				ResultSet rs = stmt.executeQuery(sql);
				// Procesar el resultset
				while ( rs.next() ) {
					AeropuertoDTO aero = new AeropuertoDTO();
					aero.setCodigo(rs.getString(1));
					aero.setNombre(rs.getString(2) );
					aero.setCiudad(rs.getString(3) );
					aero.setPais(rs.getString(4) );
					
					aeropuertos.add(aero);
				}
				
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return aeropuertos;
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
				
                                // procesamos el resultset 
                                
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

	public AeropuertoDTO getAeropuerto(String vcodigo) {

                // usamos para ejecutar insert , delete, update, select 
		PreparedStatement stmt = null;
		ResultSet  rs; // que representa en resultado de un select 
		AeropuertoDTO dto = new AeropuertoDTO();
		
		// Crear la sentencia SQL
		String sql = "SELECT * FROM tbaeropuertos WHERE codigo=?";
			try {
				this.getConnection();
				stmt = conn.prepareStatement(sql);
                                
                                // reemplazamos la interrogante 1 con vcodigo 
				stmt.setString(1, vcodigo);
				
				rs = stmt.executeQuery();
                                
                                // el resultset puede contener 0 o mas registros
                                
				while (rs.next() ) {
					dto.setCodigo( rs.getString(1) );
					dto.setNombre( rs.getString(2 ));
					dto.setCiudad( rs.getString(3));
					dto.setPais( rs.getString(4) );
				}
				rs.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("*** " + e.getLocalizedMessage() );
				e.printStackTrace();
			}
			return dto;
	}
        
	public int insertaAeropuerto(AeropuertoDTO aeropuerto) {

		PreparedStatement stmt = null;
                int res = 1;
		
		// Crear la sentencia SQL
		String sql = "insert into tbaeropuertos values (?,?,?,?)";
			try {
				this.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, aeropuerto.getCodigo());
				stmt.setString(2, aeropuerto.getNombre());
				stmt.setString(3, aeropuerto.getCiudad());
				stmt.setString(4, aeropuerto.getPais());
                                
				
                                stmt.executeUpdate();
                                
				conn.close();
			} catch (SQLException e) {
                                res=0;
				// TODO Auto-generated catch block
				System.out.println("*** " + e.getLocalizedMessage() );
				e.printStackTrace();
			}
             return res;           
	}

	public int actualizarAeropuerto(AeropuertoDTO aeropuerto) {

		PreparedStatement stmt = null;
                int res = 1;
		
		// Crear la sentencia SQL
		String sql = "update tbaeropuertos set nombre=?, ciudad=?, pais=? where codigo=?";
			try {
				this.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, aeropuerto.getNombre());
				stmt.setString(2, aeropuerto.getCiudad());
				stmt.setString(3, aeropuerto.getPais());
				stmt.setString(4, aeropuerto.getCodigo());
            	stmt.executeUpdate();
                                
				conn.close();
			} catch (SQLException e) {
                                res=0;
				// TODO Auto-generated catch block
				System.out.println("*** " + e.getLocalizedMessage() );
				e.printStackTrace();
			}
             return res;           
	}
        

}
