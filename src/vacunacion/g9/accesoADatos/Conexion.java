package vacunacion.g9.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private static final String URL = "jdbc:mariadb://localhost/";
    private static final String BD = "vacunacion-g9";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static Connection connection;
    
    private Conexion (){
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            JOptionPane.showMessageDialog(null, "Driver cargados");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar Driver de conexion " + ex.getMessage());
        }
    }
    
    public static Connection getConexion(){
        if (connection == null) {
            try {
                Conexion conexion = new Conexion();
                connection = DriverManager.getConnection(URL + BD, USUARIO, PASSWORD);
                JOptionPane.showMessageDialog(null, "Conexion exitosa");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse a base de datos " + ex.getMessage());
            }
        }
        return connection;  
    }  
}