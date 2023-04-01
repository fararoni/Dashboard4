package tese.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tese.pojo.Producto;
import tese.pojo.Usuario;

public class ProductoDAO {

    static String sqlCrearTabla = "CREATE TABLE productos1 "
            + "(id INT NOT NULL AUTO_INCREMENT,"
            + " titulo VARCHAR(30) NOT NULL,"
            + " descripcion  VARCHAR(80) NOT NULL, "
            + " urlimage  VARCHAR(240) NULL, "
            + " precio   DECIMAL(10) NULL, "
            + " PRIMARY KEY (id) ) ENGINE = InnoDB;";

    // MySQL CREATE TABLE `u849192389_tese`.`productos` ( `id` INT NOT NULL AUTO_INCREMENT , `titulo` VARCHAR(30) NOT NULL ,
    // `descripcion` VARCHAR(80) NOT NULL , `urlimage` VARCHAR(240) NOT NULL , `precio` DECIMAL(10) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;
    String sqlInsert = "INSERT INTO  productos (titulo, descripcion, urlimage, precio) VALUES ( ?, ?, ? , ?)";
    String sqlUpdate = "UPDATE productos set titulo= ?, descripcion = ?, urlimage=?, precio =?  where id = ? ";
    String sqlDelete = "DELETE from productos where id = ?";
    String sqlSelectById = "SELECT id, titulo, descripcion, urlimage, precio from productos where id =?";
    String sqlSelectByComodin = "SELECT titulo, descripcion, urlimage, precio from productos where (titulo like ? or descripcion like ?)";
    String sqlSelectAll = "select * from productos";

    public boolean crearTabla() {
        return DatabaseDAO.crearTabla(sqlCrearTabla);

    }

    public int insert(Producto p) throws SQLException {
        Connection conn = DatabaseDAO.openConnection();
        int cuantos;
        System.out.println("UsuarioDAO.insert:" + p);
        PreparedStatement ps = conn.prepareStatement(sqlInsert);
        ps.setString(1, p.getTitulo());
        ps.setString(2, p.getDescripcion());
        ps.setString(3, p.getUrlimage());
        ps.setDouble(4, p.getPrecio());
        cuantos = ps.executeUpdate();
        DatabaseDAO.closeConnection(conn);
        return cuantos;
    }

    public int update(Producto p) throws SQLException {
       Connection conn = DatabaseDAO.openConnection();
        int cuantos;
        conn = DatabaseDAO.openConnection();
        PreparedStatement ps = conn.prepareStatement(sqlUpdate);
        ps.setString(1, p.getTitulo());
        ps.setString(2, p.getDescripcion());
        ps.setString(3, p.getUrlimage());
        ps.setDouble(4, p.getPrecio());
        ps.setDouble(5, p.getId());
        cuantos = ps.executeUpdate();
        DatabaseDAO.closeConnection(conn);
        return cuantos;
    }

    public int delete(int id) throws SQLException {
        Connection conn = DatabaseDAO.openConnection();
        int cuantos;
        PreparedStatement ps = conn.prepareStatement(sqlDelete);
        ps.setInt(1, id);
        cuantos = ps.executeUpdate();
        DatabaseDAO.closeConnection(conn);
        return cuantos;
    }

    //---
    public Producto select(int id) throws SQLException {
        Connection conn = DatabaseDAO.openConnection();
        Producto prod = null;
        PreparedStatement preparedStatement = conn.prepareStatement(sqlSelectById);
        preparedStatement.setInt(1, id);
        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            prod = new Producto();
            prod.setId(rs.getInt("id"));
            prod.setTitulo(rs.getString("titulo"));
            prod.setDescripcion(rs.getString("descripcion"));
            prod.setUrlimage(rs.getString("urlimage"));
            prod.setPrecio(rs.getDouble("precio"));
        }
        DatabaseDAO.closeConnection(conn);
        return prod;
    }

    public Producto select(String comodin) throws SQLException {
        Connection conn = DatabaseDAO.openConnection();
        Producto prod = null;
        PreparedStatement preparedStatement = conn.prepareStatement(sqlSelectByComodin);
        preparedStatement.setString(1, comodin);
        preparedStatement.setString(2, comodin);
        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            prod = new Producto();
            prod.setId(rs.getInt("id"));
            prod.setTitulo(rs.getString("titulo"));
            prod.setDescripcion(rs.getString("descripcion"));
            prod.setUrlimage(rs.getString("urlimage"));
            prod.setPrecio(rs.getDouble("precio"));
        }
        DatabaseDAO.closeConnection(conn);
        return prod;
    }

    public List selectAll() throws SQLException {
        Connection conn = DatabaseDAO.openConnection();
        List productos = new ArrayList();
        PreparedStatement ps = conn.prepareStatement(sqlSelectAll);
        System.out.println(ps);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Producto p = new Producto();
            p.setId(rs.getInt("id"));
            p.setTitulo(rs.getString("titulo"));
            p.setDescripcion(rs.getString("descripcion"));
            p.setUrlimage(rs.getString("urlimage"));
            p.setPrecio(rs.getDouble("precio"));
            productos.add(p);
        }
        DatabaseDAO.closeConnection(conn);
        return productos;
    }
}
