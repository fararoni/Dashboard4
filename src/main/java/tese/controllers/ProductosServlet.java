package tese.controllers;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tese.dao.ProductoDAO;
import tese.pojo.Producto;

/*
            SQL                      Form            Action      
                                     GET             POST
    Create  Insert  /ProductosNew    showNewForm     actionInsert 
    Read    Select  /ProductosGrid   showAllGrid     N/A
    Update  Update  /ProductosUpdate showUpdateForm  actionUdate
    Delete  Delete  /ProductosDelete showDeleteForm  actionDelete
    ------  ------  ---------------- --------------  ------------

    1.- Los formularios y grid, se mostraran por el Método GET y 
        las acciones a B.D. por el método POST.
 */
@WebServlet(name = "ProductosServlet", urlPatterns = {
    "/ProductosNew",
    "/ProductosGrid",
    "/ProductosUpdate",
    "/ProductosDelete"
})
public class ProductosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ProductoDAO productoDAO;

    public void init() {
        productoDAO = new ProductoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            if ("/ProductosNew".equals(action)) {
                showNewForm(request, response);
            }
            if ("/ProductosGrid".equals(action)) {
                showAllGrid(request, response);

            }
            if ("/ProductosUpdate".equals(action)) {
                showUpdateForm(request, response);
            }
            if ("/ProductosDelete".equals(action)) {
                showDeleteForm(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            if ("/ProductosNew".equals(action)) {
                actionInsert(request, response);
            }
            if ("/ProductosGrid".equals(action)) {
                showAllGrid(request, response);
            }
            if ("/ProductosUpdate".equals(action)) {
                actionUpdate(request, response);
            }
            if ("/ProductosDelete".equals(action)) {
                actionDelete(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //-- Create  Insert  /ProductosNew    showNewForm     actionInsert 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("showNewForm");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/productos/producto-form.jsp");
        dispatcher.forward(request, response);
    }

    private void actionInsert(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
               System.out.println("Id tiene valor nulo");
        }
        String titulo = request.getParameter("titulo");
        String descripcion = request.getParameter("descripcion");
        String urlimage = request.getParameter("urlimage");
        
        double precio = Double.parseDouble(request.getParameter("precio"));

        Producto newProd = new Producto(id, titulo, descripcion, urlimage, precio);
        productoDAO.insert(newProd);
        response.sendRedirect(request.getContextPath() + "/ProductosGrid");
    }

    //--Read    Select  /ProductosGrid   showAllGrid     N/A
    private void showAllGrid(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List< Producto> listUser = productoDAO.selectAll();
        
        request.setAttribute("listProductos", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/productos/productos-list.jsp");
        dispatcher.forward(request, response);
    }

    //-- Update  Update  /ProductosUpdate showUpdateForm  actionUdate
    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Producto prod = productoDAO.select(id);
        
        request.setAttribute("producto", prod);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/productos/producto-form.jsp");
        dispatcher.forward(request, response);
    }
     private void actionUpdate(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = -1;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
               System.out.println("Id tiene valor nulo");
        }
        String titulo = request.getParameter("titulo");
        String descripcion = request.getParameter("descripcion");
        String urlimage = request.getParameter("urlimage");
        double precio = Double.parseDouble(request.getParameter("precio"));

        Producto updateProd = new Producto(id, titulo, descripcion, urlimage, precio);
        System.out.println(" actionUpdate:" + updateProd );
        productoDAO.update(updateProd);
        response.sendRedirect(request.getContextPath() + "/ProductosGrid");
    }
    
    

    //-- Delete  Delete  /ProductosDelete showDeleteForm  actionDelete
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Producto prod = productoDAO.select(id);
        
        request.setAttribute("producto", prod);
        request.setAttribute("accion", "borrar");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/productos/producto-form.jsp");
        dispatcher.forward(request, response);
    }
    
    private void actionDelete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = -1;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
               System.out.println("Id tiene valor nulo");
        }
        System.out.println(" actionDelete:" + id );
        productoDAO.delete(id);
        response.sendRedirect(request.getContextPath() + "/ProductosGrid");
    }
}
