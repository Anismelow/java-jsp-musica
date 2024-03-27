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


@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Inicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//3
		DB_Helper db= new DB_Helper();
		Connection con=db.conectar();
		
		//4
		List<Estilo> listaEstilos = db.obtenerTodosEstilos(con);
		List<V_Disco> listaVDiscos = db.obtenerTodosVDiscos(con);
			
		//5
		db.desconectar(con);
	
		//6
		request.setAttribute("atr_lista_estilos", listaEstilos);
		request.setAttribute("atr_lista_v_discos", listaVDiscos);
	
		//7
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
