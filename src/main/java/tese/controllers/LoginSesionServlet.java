package tese.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tese.dao.UsuarioDAO;
import tese.pojo.Usuario;

@WebServlet(name = "SesionServlet", urlPatterns = {"/Auth/LoginServlet"})
public class LoginSesionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UsuarioDAO userDato;

    public void init() {
        userDato = new UsuarioDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("::LoginSesionServlet.doGet:");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/auth/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
        System.out.println("::LoginSesionServlet.doPost. loginUsuario ---");
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Usuario newUsuario = userDato.select(email);

            if (newUsuario == null) {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/auth/login.jsp");
                PrintWriter out = response.getWriter();
                request.setAttribute("mensaje", "El nombre de usuario o contraseña es incorrecto");
                rd.forward(request,response);
            } else {
                System.out.println(":: Se inicia la sesión del usuario: [" + newUsuario + "]");
                HttpSession session = request.getSession();
                session.setAttribute("USUARIO", email);
                session.setMaxInactiveInterval(30 * 60);
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: insertUsuario: " + ex.getMessage());
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginSesionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
