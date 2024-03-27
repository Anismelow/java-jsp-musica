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
import com.ipartek.modelo.dto.Estilo;
import com.ipartek.modelo.dto.V_Disco;

@WebServlet("/FormModificar")
public class FormModificar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FormModificar() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = 0;
		if (request.getParameter("id") != null) {
			String texto = request.getParameter("id");
			id = Integer.parseInt(texto);
		}

		// 3
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();

		// 4
		V_Disco disco = db.obtenerVDiscoPorId(con, id);
		List<Estilo> listaEstilos = db.obtenerTodosEstilos(con);
	
		// 5
		db.desconectar(con);

		// 6
		request.setAttribute("atr_lista_estilos", listaEstilos);
		request.setAttribute("atr_v_disco", disco);
		
		// 7
		request.getRequestDispatcher("formModificar.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
