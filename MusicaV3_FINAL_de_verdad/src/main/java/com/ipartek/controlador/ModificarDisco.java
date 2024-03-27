package com.ipartek.controlador;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.dto.Disco;
import com.ipartek.modelo.dto.Estilo;
import com.ipartek.modelo.dto.V_Disco;

@WebServlet("/ModificarDisco")
public class ModificarDisco extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModificarDisco() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		if (request.getParameter("id") != null) {
			String texto = request.getParameter("id");
			id = Integer.parseInt(texto);
		}
		
		String titulo = "";
		if (request.getParameter("titulo") != null) {
			titulo = request.getParameter("titulo");
		}

		int numcanciones = 0;
		if (request.getParameter("numcanciones") != null) {
			String texto = request.getParameter("numcanciones");
			numcanciones = Integer.parseInt(texto);
		}

		double precio = 0.0;
		if (request.getParameter("precio") != null) {
			String texto = request.getParameter("precio");
			precio = Double.parseDouble(texto);
		}

		int fk_estilo = 0;
		if (request.getParameter("fk_estilo") != null) {
			String texto = request.getParameter("fk_estilo");
			fk_estilo = Integer.parseInt(texto);
		}

		// 2
		Disco dis = new Disco(id, titulo, numcanciones, precio, fk_estilo);

		// 3
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();

		// 4
		db.modificarDisco(con, dis);
		
		List<Estilo> listaEstilos = db.obtenerTodosEstilos(con);
		List<V_Disco> listaVDiscos = db.obtenerTodosVDiscos(con);

		// 5
		db.desconectar(con);

		// 6
		request.setAttribute("atr_lista_estilos", listaEstilos);
		request.setAttribute("atr_lista_v_discos", listaVDiscos);

		// 7
		request.getRequestDispatcher("index.jsp").forward(request, response);

		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
