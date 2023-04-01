package tese.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tese.pojo.Usuario;

public class UsuarioDAO {

    static String sqlCrearTabla = "CREATE TABLE USUARIOS "
            + "(ID PRIMARY KEY,"
            + " email text,"
            + " password text"
            + ")";

    String sqlInsert = "INSERT INTO  usuarios (email, telefono, password) VALUES ( ?, ?, ? )";
    String sqlUpdate = "UPDATE usuarios set email= ?, password = ? where id = ? ";
    String sqlDelete = "DELETE from usuarios where id = ?;";
    String sqlSelectById = "SELECT id, email, password from usuarios where id =?";
    String sqlSelectByEmail = "SELECT id, email, password from usuarios where email =?";
    String sqlSelectAll = "select * from usuarios";

    public boolean crearTabla() {
        return DatabaseDAO.crearTabla(sqlCrearTabla);

    }

    public int insert(Usuario u) throws SQLException, ClassNotFoundException {
        int cuantos;
        String stt = u.getTelefono().replaceAll("\\D+", "");
        System.out.println("UsuarioDAO.insert:" + u + "|" + stt);
        Connection conn = DatabaseDAO.openConnection();
        PreparedStatement ps = conn.prepareStatement(sqlInsert);
        ps.setString(1, u.getEmail());
        ps.setString(2, stt);
        ps.setString(3, u.getPassword());
        cuantos = ps.executeUpdate();
        DatabaseDAO.closeConnection(conn);
        return cuantos;
    }

    public int update(Usuario u) throws SQLException, ClassNotFoundException {
        int cuantos;
        PreparedStatement ps = DatabaseDAO.openConnection().prepareStatement(sqlUpdate);
        ps.setString(1, u.getEmail());
        ps.setString(2, u.getPassword());
        ps.setInt(3, u.getId());
        cuantos = ps.executeUpdate();
        // 
        return cuantos;
    }

    public int delete(int id) throws SQLException, ClassNotFoundException {
        int cuantos;
        PreparedStatement ps = DatabaseDAO.openConnection().prepareStatement(sqlDelete);
        ps.setInt(1, id);
        cuantos = ps.executeUpdate();
        //DatabaseDAO.closeConnection();
        return cuantos;
    }

    //---
    public Usuario select(int id) throws SQLException, ClassNotFoundException {
        Usuario user = null;
        PreparedStatement preparedStatement = DatabaseDAO.openConnection().prepareStatement(sqlSelectById);
        preparedStatement.setInt(1, id);
        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            user = new Usuario();
            user.setId(rs.getInt("id"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
        }
        //DatabaseDAO.closeConnection();
        return user;
    }

    public Usuario select(String email) throws SQLException, ClassNotFoundException {
        Usuario user = null;
        PreparedStatement preparedStatement = DatabaseDAO.openConnection().prepareStatement(sqlSelectByEmail);
        preparedStatement.setString(1, email);
        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            user = new Usuario();
            user.setId(rs.getInt("id"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
        }
        // DatabaseDAO.closeConnection();
        return user;
    }

    public List selectAll() throws ClassNotFoundException, SQLException {
        List users = new ArrayList();
        PreparedStatement ps = DatabaseDAO.openConnection().prepareStatement(sqlSelectAll);
        System.out.println(ps);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Usuario user = new Usuario();
            user.setId(rs.getInt("id"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            users.add(user);

        }
        // DatabaseDAO.closeConnection();
        return users;
    }
}
