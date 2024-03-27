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

V_Disco disco = new V_Disco();
if(request.getAttribute("atr_v_disco")!=null){
	disco=(V_Disco)request.getAttribute("atr_v_disco");
}
%>     
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="ModificarDisco" method="get">
		<label for="id">ID</label><br>
        <input type="number" id="id" name="id" 
        required readonly value="<%=disco.getId()%>"><br><br>
	
        <label for="titulo">Título del Disco:</label><br>
        <input type="text" id="titulo" name="titulo" value="<%=disco.getTitulo() %>" required><br><br>
        
        <label for="numcanciones">Número de Canciones:</label><br>
        <input type="number" id="numcanciones" name="numcanciones" value="<%=disco.getNumCanciones()  %>" required><br><br>
        
        <label for="precio">Precio:</label><br> <input type="number" id="precio" name="precio" step="0.01"
			value="<%=disco.getPrecio()  %>" required><br><br>
        
        <label for="fk_estilo">Estilo:</label><br>
        <select id="fk_estilo" name="fk_estilo" required>
            <%for(Estilo  elemento : listaEstilos){
            	if(elemento.getId()==disco.getFk_estilo()){%>     
            		<option selected value="<%=elemento.getId()%>"><%=elemento.getEstilo()%></option>    
 			  <%}else {%>  
            		<option value="<%=elemento.getId()%>"><%=elemento.getEstilo()%></option><%
           	    } 
            }%>          
        </select><br><br>
        
        <input type="submit" value="Modificar Disco">
    </form>




</body>
</html>