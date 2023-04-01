package tese.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tese.dao.UsuarioDAO;
import tese.pojo.Usuario;

@WebServlet(name = "UsuarioServlet", urlPatterns
        = {"/Auth/registrar", "/Auth/insertar",
            "/Auth/recuperar", "/Auth/actualizar"})
public class UsuarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UsuarioDAO userDato;
    private final int _GET_ = 0;
    private final int _POST_ = 0;

    public void init() {
        userDato = new UsuarioDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getServletPath();
        System.out.println("UsuarioSevlet.doGet:" + accion);
        if ("/Auth/registrar".equals(accion)) {
            showFormRegistro(request, response);
        } else if ("/Auth/recuperar".equals(accion)) {
            showFormRecuperar(request, response);
        } else if ("/Auth/actualizar".equals(accion)) {
            showFormActualizar(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getServletPath();
        System.out.println("UsuarioSevlet.doPost:" + accion);
        if ("/Auth/registrar".equals(accion)) {
            insertarUsuarioAction(request, response);
        }

    }
    //-------
    private void showFormRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("showFormRegistro:");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/auth/registro.jsp");
        dispatcher.forward(request, response);
    }

    private void insertarUsuarioAction(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            String email        = request.getParameter("email");
            String password     = request.getParameter("password");
            String password2    = request.getParameter("password2");
            String telefono     = request.getParameter("telefono");
            Usuario newUsuario  = new Usuario(email, password, password2, telefono);
            userDato.insert(newUsuario);
            System.out.println("::Se inserto el Usuario:" + email);
            response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
            return;
        } catch (ClassNotFoundException ex) {
            System.out.println("::Error: ClassNotFoundException insertUsuario: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("::Error: SQLException insertUsuario: " + ex.getMessage());
            request.setAttribute("mensaje",  ex.getMessage());
        }
         RequestDispatcher dispatcher = request.getRequestDispatcher("/auth/registro.jsp");
          
        dispatcher.forward(request, response);
    }
    ///---
    private void showFormRecuperar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("showFormRegistro:");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/auth/recuperar.jsp");
        dispatcher.forward(request, response);
    }

    private void showFormActualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("showFormRegistro:");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/auth/actualizar.jsp");
        dispatcher.forward(request, response);
    }
}
