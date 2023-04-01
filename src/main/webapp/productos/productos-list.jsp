<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/auth/sesion.jsp" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%! String titulo = "Proyecto Dashboard TESE";%>
        <%@include file="/layout/head.jsp" %>
    </head>
    <body class="hold-transition sidebar-mini">
        <!-- Site wrapper -->
        <div class="wrapper">
            <%@include file="/layout/menu_superior.jsp" %>
            <%@include file="/layout/menu_izquierdo.jsp" %>
            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <div class="container-fluid">
                        <div class="row mb-2">
                            <div class="col-sm-6">
                                <h1>Productos</h1>
                            </div>
                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/index.jsp">Inicio</a></li>
                                    
                                </ol>
                            </div>
                        </div>
                    </div><!-- /.container-fluid -->
                </section>

                <!-- Main content -->
                <section class="content">
                    <!-- Inicio de Tabla -->
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title">Gestionar catálogo de productos</h3>
                                <div class="card-tools">
                                    <div class="container text-left">
                                        <a href="<%=request.getContextPath()%>/ProductosNew" class="btn btn-success">Agregar
                                        </a>
                                    </div>
                                </div>
                            </div>

                            <div class="card-body p-0">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Titulo</th>
                                            <th>Descripción</th>
                                            <th>Imagen</th>
                                            <th>Precio</th>
                                            <th>Acciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="prod" items="${listProductos}">
                                        <tr>
                                            <td>
                                        <c:out value="${prod.id}" />
                                        </td>
                                        <td>
                                        <c:out value="${prod.titulo}" />
                                        </td>
                                        <td>
                                        <c:out value="${prod.descripcion}" />
                                        </td>
                                        <td>
                                        
                                        <img alt="Avatar"  width="90" height="90" class="table-avatar" src="<c:out value="${prod.urlimage}"/>">
                                        </td>
                                        <td>
                                        <c:out value="${prod.precio}" />
                                        </td>
                                        <td><a href="<%=request.getContextPath()%>/ProductosUpdate?id=<c:out value='${prod.id}' />">Actualizar</a> &nbsp;&nbsp;&nbsp;&nbsp;
                                            <a href="<%=request.getContextPath()%>/ProductosDelete?id=<c:out value='${prod.id}' />">Borrar</a>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                        </div>     

                    </div>   
                    <!-- Fin de tabla -->
                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->

            <%@include file="/layout/footer.jsp" %>
        </div>
        <!-- ./wrapper -->

        <%@include file="/layout/libraries.jsp" %>
    </body>
</html>
