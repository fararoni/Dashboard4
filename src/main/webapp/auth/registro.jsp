<%@include file="/tools/common.jsp" %>
<%! String titulo = "Iniciar sesión"; %>
<%
    String mensaje = getAtributo(request, "mensaje");
//    request.removeAttribute("mensaje");
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/layout/head.jsp" %>
    </head>
    <body class="hold-transition register-page">
        <div class="register-box">
            <div class="card card-outline card-primary">
                <div class="card-header text-center">
                    <a href="<%=request.getContextPath()%>" class="h1"><b>Tese</b>ADMIN</a>
                </div>
                <div class="card-body">
                    <p class="login-box-msg">Crear cuenta de usuario</p>
                    <% 
                        if ( !"".equals(mensaje) ) {
                    %>
                        <div class="callout callout-warning">
                           
                            <p><%= mensaje%></p>
                        </div>
                    <%
                        }
                    %>
                                           
                    <form action="<%=request.getContextPath()%>/Auth/registrar" method="post">
                        <div class="input-group mb-3">
                            <input type="email" class="form-control" name="email" placeholder="Email">
                            <div class="input-group-append">
                                <div class="input-group-text">
                                    <span class="fas fa-envelope"></span>
                                </div>
                            </div>
                        </div>
                        <div class="input-group mb-3">
                            <input type="tel" class="form-control" id="telefono" name="telefono" placeholder="12-3456-7890" pattern="[0-9]{2}-[0-9]{4}-[0-9]{4}" required>
                       
                            <div class="input-group-append">
                                <div class="input-group-text">
                                    <span class="fas fa-phone"></span>
                                </div>
                            </div>
                        </div>
                        <div class="input-group mb-3">
                            <input type="password" class="form-control" name="password" placeholder="Password">
                            <div class="input-group-append">
                                <div class="input-group-text">
                                    <span class="fas fa-lock"></span>
                                </div>
                            </div>
                        </div>
                        <div class="input-group mb-3">
                            <input type="password" class="form-control" name="password2" placeholder="Retype password">
                            <div class="input-group-append">
                                <div class="input-group-text">
                                    <span class="fas fa-lock"></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-8">
                                <div class="icheck-primary">
                                    <input type="checkbox" id="agreeTerms" name="terms" value="agree">
                                    <label for="agreeTerms">
                                        Acepto los <a href="#">términos</a>
                                    </label>
                                </div>
                            </div>

                            <div class="col-4">
                                <button type="submit" class="btn btn-primary btn-block">Registrar</button>
                            </div>

                        </div>
                    </form>

                    <a href="<%=request.getContextPath()%>/Auth/login" class="text-center">Ya tengo una cuenta</a>
                </div>

            </div>
        </div>

        <%@include file="/layout/libraries.jsp" %>
    </body>
</html>
