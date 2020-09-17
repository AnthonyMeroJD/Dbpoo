import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection con;
    public  Connection getCon(){
        final String sURL = "jdbc:mysql://localhost:3306/proyecto";
        try {
            con = DriverManager.getConnection(sURL, "root", "");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }
}
