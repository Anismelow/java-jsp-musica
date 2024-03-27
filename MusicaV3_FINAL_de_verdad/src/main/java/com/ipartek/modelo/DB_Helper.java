package com.ipartek.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.modelo.dto.Disco;
import com.ipartek.modelo.dto.Estilo;
import com.ipartek.modelo.dto.V_Disco;

public class DB_Helper implements IConexion {

	public Connection conectar() {
		Connection con = null;

		try {
			Class.forName(BD_DRIVER);
			con = DriverManager.getConnection(CADENA_CONEXION, USUARIO, PASS);
			System.out.println("Conexion ok");
		} catch (ClassNotFoundException e) {
			System.out.println("NO SE ENCONTRO EL DRIVER");
		} catch (SQLException e) {
			System.out.println("ERROR DE SQL EN LA CONEXION");
		}
		return con;
	}

	public void desconectar(Connection con) {
		try {
			con.close();
			System.out.println("Conexion cerrada");
		} catch (SQLException e) {
			System.out.println("NO SE PUDO DESCONECTAR");
		}
	}

	public List<Estilo> obtenerTodosEstilos(Connection con) {
		try {
			List<Estilo> lista = new ArrayList<Estilo>();
			CallableStatement cStmt = con.prepareCall("call sp_obtener_todos_estilos();");
			cStmt.execute();

			ResultSet rs = cStmt.getResultSet();

			while (rs.next()) {
				Estilo est = new Estilo();

				est.setId(rs.getInt("id"));
				est.setEstilo(rs.getString("estilo"));

				lista.add(est);
			}

			System.out.println(lista);
			return lista;

		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Estilo>();
		}
	}

	public List<V_Disco> obtenerTodosVDiscos(Connection con) {
		try {
			List<V_Disco> lista = new ArrayList<V_Disco>();
			CallableStatement cStmt = con.prepareCall("call sp_obtener_todos_discos_v();");
			cStmt.execute();

			ResultSet rs = cStmt.getResultSet();

			while (rs.next()) {
				V_Disco vDis = new V_Disco();

				vDis.setId(rs.getInt("id"));
				vDis.setTitulo(rs.getString("titulo"));
				vDis.setNumCanciones(rs.getInt("numcanciones"));
				vDis.setPrecio(rs.getDouble("precio"));
				vDis.setFk_estilo(rs.getInt("fk_estilo"));
				vDis.setEstilo(rs.getString("estilo"));

				lista.add(vDis);
			}

			System.out.println(lista);
			return lista;

		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<V_Disco>();
		}
	}

	public void insertarDisco(Connection con, Disco dis) {
		try {
			// call sp_insertar_disco('titulo', numcanciones, precio, fk_estilo);
			CallableStatement cStmt = con.prepareCall("call sp_insertar_disco(?, ?, ?, ?);");

			cStmt.setString(1, dis.getTitulo());
			cStmt.setInt(2, dis.getNumCanciones());
			cStmt.setDouble(3, dis.getPrecio());
			cStmt.setInt(4, dis.getFk_estilo());

			cStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//la de insetar

	public void borrarDisco(Connection con, int id) {
		
		try {
			//call sp_borrar_disco(9999);
			CallableStatement cStmt = con.prepareCall("call sp_borrar_disco(?);");
			
			cStmt.setInt(1, id);

			cStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

	public V_Disco obtenerVDiscoPorId(Connection con, int id) {
		try {
			//call sp_obtener_disco_por_id_v(4);
			CallableStatement cStmt = con.prepareCall("call sp_obtener_disco_por_id_v(?);");
			cStmt.setInt(1, id);
			cStmt.execute();
			ResultSet rs = cStmt.getResultSet();
			V_Disco vDis = new V_Disco();
			
			while (rs.next()) {
				vDis.setId(rs.getInt("id"));
				vDis.setTitulo(rs.getString("titulo"));
				vDis.setNumCanciones(rs.getInt("numcanciones"));
				vDis.setPrecio(rs.getDouble("precio"));
				vDis.setFk_estilo(rs.getInt("fk_estilo"));
				vDis.setEstilo(rs.getString("estilo"));	
			
			}
			return vDis;
		} catch (SQLException e) {
			e.printStackTrace();
			return new V_Disco();
		}
	}

	public void modificarDisco(Connection con, Disco dis) {
		try {
			//call sp_modificar_disco(id, 'titulo', numcanciones, precio, estilo);
			CallableStatement cStmt = con.prepareCall("call sp_modificar_disco(?, ?, ?, ?, ?);");

			cStmt.setInt(1, dis.getId());
			cStmt.setString(2, dis.getTitulo());
			cStmt.setInt(3, dis.getNumCanciones());
			cStmt.setDouble(4, dis.getPrecio());
			cStmt.setInt(5, dis.getFk_estilo());

			cStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//la de insetar

	public List<V_Disco> obtenerVDiscosBusqueda(Connection con, String texto) {
	

		try {
			List<V_Disco> lista = new ArrayList<V_Disco>();
			//call sp_buscar_disco_ft('dark');
			CallableStatement cStmt = con.prepareCall("call sp_buscar_disco_ft(?);");
			cStmt.setString(1, texto);
			cStmt.execute();

			ResultSet rs = cStmt.getResultSet();

			while (rs.next()) {
				V_Disco vDis = new V_Disco();

				vDis.setId(rs.getInt("id"));
				vDis.setTitulo(rs.getString("titulo"));
				vDis.setNumCanciones(rs.getInt("numcanciones"));
				vDis.setPrecio(rs.getDouble("precio"));
				vDis.setFk_estilo(rs.getInt("fk_estilo"));
				vDis.setEstilo(rs.getString("estilo"));

				lista.add(vDis);
			}

			System.out.println(lista);
			return lista;

		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<V_Disco>();
		}	
	}



	
	
	
}


