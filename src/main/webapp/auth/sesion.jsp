<%
     if ( session.getAttribute("USUARIO") == null) {
	request.setAttribute("mensaje", "Debe autenticarse para ingresar al sistema");
        pageContext.forward("/auth/login.jsp");
    }
%>