<%
    String usuario = "Isaí Fararoni";
    String sistema = "TeseAdmin";
%>
  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="<%=request.getContextPath()%>/" class="brand-link">
      <img src="https://cdn.nekdu.com/img/logo_tese.jpeg" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light"><%=sistema%></span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="https://cdn.nekdu.com/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
            <a href="<%=request.getContextPath()%>/perfil/perfil.jsp" class="d-block"><%=usuario%></a>
        </div>
      </div>
      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                Dashboard
              </p>
            </a>
          </li>
          <!-- Intranet-->
          <li class="nav-header">E-Comerce</li>
          <li class="nav-item">
             <a href="<%=request.getContextPath()%>/ClientesGrid" class="nav-link">
              <i class="nav-icon fas fa-edit"></i>
              <p>
                Clientes
              </p>
            </a>
          </li>
          <li class="nav-item">
             <a href="<%=request.getContextPath()%>/ProductosGrid" class="nav-link">
              <i class="nav-icon fas fa-columns"></i>
              <p>
                Productos
              </p>
            </a>
          </li>
          <!-- ---------->
          <li class="nav-item">
            <a href="<%=request.getContextPath()%>/Auth/LogoutServlet" class="nav-link">
              <i class="nav-icon far fa-circle text-danger"></i>
              <p class="text">Cerrar sesión</p>
            </a>
          </li>
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>

