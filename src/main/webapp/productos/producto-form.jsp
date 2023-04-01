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
                                    <li class="breadcrumb-item active"><a href="<%=request.getContextPath()%>/ProductosGrid">Productos</a></li></li>
                                </ol>
                            </div>
                        </div>
                    </div><!-- /.container-fluid -->
                </section>

                <!-- Main content -->
                <section class="content">
                    <!-- Inicio de Tabla -->

                    <div class="card card-info">
                        <div class="card-header">
                            <h3 class="card-title">Agregar un nuevo producto</h3>
                        </div>
                        <c:if test="${accion == null }">
                            <c:if test="${producto == null}">
                                <form class="form-horizontal" action="<%=request.getContextPath()%>/ProductosNew" method="POST">
                            </c:if>
                            <c:if test="${producto != null}">
                                <form class="form-horizontal" action="<%=request.getContextPath()%>/ProductosUpdate" method="POST">
                            </c:if>                                
                        </c:if>                                
                        <c:if test="${accion == 'borrar'}">
                            <form class="form-horizontal" action="<%=request.getContextPath()%>/ProductosDelete" method="POST">
                        </c:if>                      
                            <div class="card-body">
                                
                                <c:if test="${producto != null}">
                                    <input type="hidden" name="id" value="<c:out value='${producto.id}' />" />
                                </c:if>
                            
                                <div class="form-group row">
                                    <label for="titulo" class="col-sm-2 col-form-label">Título</label>
                                    <div class="col-sm-10">
                                        <input type="text" id="titulo" name="titulo" value="<c:out value='${producto.titulo}' />" 
                                               class="form-control" placeholder="Título del producto ...">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="descripcion" class="col-sm-2 col-form-label">Descripción</label>
                                    <div class="col-sm-10">
                                        <textarea rows="3" id="descripcion" name="descripcion"  
                                                  class="form-control"  placeholder="Descripción ..."><c:out value='${producto.descripcion}' /></textarea>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="urlimage" class="col-sm-2 col-form-label">URL de imagen</label>
                                    <div class="col-sm-10">
                                        <input type="text" id="urlimage" name="urlimage"  value="<c:out value='${producto.urlimage}' />" 
                                               class="form-control" placeholder="Url de imagen...">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="precio" class="col-sm-2 col-form-label">Precio $</label>
                                    <div class="col-sm-10">
                                        <input  type="number" min="1" step="any" id="precio" name="precio"  value="<c:out value='${producto.precio}' />" 
                                                class="form-control" placeholder="Precio...">
                                    </div>
                                </div>

                            </div>
                            <div class="card-footer">
                                <a href="<%=request.getContextPath()%>/ProductosGrid" class="btn btn-default" role="button">Cancelar</a>
                                <c:if test="${accion == null }">
                                    <c:if test="${producto == null}">
                                        <button type="submit" class="btn btn-info  float-right">Agregar</button>
                                    </c:if>
                                    <c:if test="${producto != null}">
                                        <button type="submit" class="btn btn-info  float-right"><i class="fas fa-pencil-alt"></i> Actualizar</button>
                                    </c:if>
                                </c:if>
                                <c:if test="${accion == 'borrar'}">
                                    <button type="submit" class="btn btn-danger   float-right"><i class="fas fa-trash"></i> Borrar</button>
                                </c:if>     
                            </div>

                        </form>
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
