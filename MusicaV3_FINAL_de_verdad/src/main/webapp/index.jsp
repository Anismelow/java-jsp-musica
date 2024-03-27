<%@page import="com.ipartek.modelo.dto.V_Disco"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.modelo.dto.Estilo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
List<Estilo> listaEstilos = new ArrayList<Estilo>();
if(request.getAttribute("atr_lista_estilos")!=null){
	listaEstilos=(List<Estilo>)request.getAttribute("atr_lista_estilos");
}

List<V_Disco> listaVDiscos = new ArrayList<V_Disco>();
if(request.getAttribute("atr_lista_v_discos")!=null){
	listaVDiscos=(List<V_Disco>)request.getAttribute("atr_lista_v_discos");
}

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="InsertarDisco" method="get">
        <label for="titulo">Título del Disco:</label><br>
        <input type="text" id="titulo" name="titulo" required><br><br>
        
        <label for="numcanciones">Número de Canciones:</label><br>
        <input type="number" id="numcanciones" name="numcanciones" required><br><br>
        
        <label for="precio">Precio:</label><br>
        <input type="number" id="precio" name="precio" step="0.01" required><br><br>
        
        <label for="fk_estilo">Estilo:</label><br>
        <select id="fk_estilo" name="fk_estilo" required>
            <%for(Estilo  elemento : listaEstilos){%>
            	 <option value="<%=elemento.getId()%>"><%=elemento.getEstilo()%></option>
            <%}%>
        </select><br><br>
        
        <input type="submit" value="Insertar Disco">
    </form>
    
    <hr>
    
    <form action="BuscarDisco" method="get">
        <label for="texto">Texto a buscar:</label><br>
        <input type="text" id="texto" name="texto" ><br><br>
        
        <input type="submit" value="Buscar Disco">
    </form>
    
    
    
    <hr>

	<table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Número de Canciones</th>
                <th>Precio</th>
                <th>Estilo</th>
                <th>Opciones</th>
            </tr>
        </thead>
        <tbody>
            <%for(V_Disco  elemento : listaVDiscos){%>
            <tr>
                <td><%=elemento.getId() %></td>
                <td><%=elemento.getTitulo() %></td>
                <td><%=elemento.getNumCanciones() %></td>
                <td><%=elemento.getPrecio() %></td>
                <td><%=elemento.getEstilo() %></td>
                <td>
                	<a href="BorrarDisco?id=<%=elemento.getId() %>">Borrar</a>
                
                	<a href="FormModificar?id=<%=elemento.getId() %>">Modificar</a>
                </td>
            </tr>
  			<%}%>
        </tbody>
    </table>








</body>
</html>