import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca_db";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "Root1234*";

    public static Connection getConexion() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("✔ Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("✘ Error de conexión: " + e.getMessage());
        }
        return conexion;
    }

    public static void cerrarConexion(Connection conexion) {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("✔ Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("✘ Error al cerrar conexión: " + e.getMessage());
        }
    }
}