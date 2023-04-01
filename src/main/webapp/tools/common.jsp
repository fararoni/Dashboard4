<%!
    String getAtributo(HttpServletRequest request, String atributo){
        String mensaje = (String)request.getAttribute(atributo);
        System.out.println("::getAtributo(" + atributo + ")[" + mensaje + "]");
        if (mensaje==null) mensaje = "";
        return mensaje;
    }
%>