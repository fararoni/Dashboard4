package tese.dao;
///-- Conexion

import java.sql.Connection;
import java.sql.DriverManager;
//-- Consulta y acrtualizacion
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//-- Errores
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseDAO {

    //-- Conexion a BD
    private static String dbDatabase = "u849192389_tese";
    private static String dbURL = "jdbc:mysql://sql650.main-hosting.eu:3306/" + dbDatabase + "?useSSL=false";
    private static String dbUser = "u849192389_tese";
    private static String dbPassword = "DraP7ewrl5rIW?S3Lja6";
    private static String dbDriver = "com.mysql.cj.jdbc.Driver";

    public static Connection openConnection() throws SQLException {
        Connection conn = null;
        System.out.println("--| Conexión a la base de datos [DatabaseDAO.openConnection()].");
        try {
            Class.forName(dbDriver);
            System.out.println("--|--| Se ha cargado el driver " + dbDriver);
            if (conn == null) {
                conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
                System.out.println("--|--| Iniciando conexióm a la base de datos: " + dbDatabase);
                if (conn != null) {
                    System.out.println("--|--|--- Conectado a la base de datos ok." + dbDatabase);
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println(":::| No se encontró el driver de base de datos");
            System.out.println(":::|   " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println(":::| Error de SQLException");
            System.out.println(":::|   " + e.getMessage());
            throw e;
        } finally {
            System.out.println("--| Llegó a finally de [DatabaseDAO.openConnection]");
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        
        try {
            if (conn != null && ! conn.isClosed() ) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("--| Se ha cerrado la conexión a la base de datos [DatabaseDAO.closeConnection]");
    }

    //-- Crear tala
    public static boolean crearTabla(String sql) {
        boolean resultado = false;
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("...| Tabla creada." + sql);
            resultado = true;
            closeConnection(conn);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    //-- Consulta - Select
}
