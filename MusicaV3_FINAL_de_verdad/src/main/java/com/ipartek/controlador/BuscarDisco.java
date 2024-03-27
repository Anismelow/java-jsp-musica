package com.ipartek.controlador;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
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

@WebServlet("/BuscarDisco")
public class BuscarDisco extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BuscarDisco() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1
		String texto = "";
		if (request.getParameter("texto") != null) {
			texto = request.getParameter("texto");
		}

		// 2

		// 3
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();

		// 4

		List<Estilo> listaEstilos = db.obtenerTodosEstilos(con);

		List<V_Disco> listaVDiscos = new ArrayList<V_Disco>();
		if (!texto.equals("")) {
			listaVDiscos = db.obtenerVDiscosBusqueda(con, texto);
		} else {
			listaVDiscos = db.obtenerTodosVDiscos(con);
		}
		// 5
		db.desconectar(con);

		// 6
		request.setAttribute("atr_lista_estilos", listaEstilos);
		request.setAttribute("atr_lista_v_discos", listaVDiscos);

		// 7
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
