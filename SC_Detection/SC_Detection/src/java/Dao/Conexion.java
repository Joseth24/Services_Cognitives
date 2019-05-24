package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection cn;

    public void conectar() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=SERVICIO", "sa", "70253971");
            System.out.println("Conectado");
        } catch (ClassNotFoundException e) {
            System.out.println("Error.." + e);
        }
    }

    public void cerrar() throws SQLException {
        try {
            if (cn != null) {
                if (cn.isClosed() == false) {
                    cn.isClosed();
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            Conexion conexion = new Conexion();
            conexion.conectar();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }
    


    //GETTER AND SETTER
    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

}
