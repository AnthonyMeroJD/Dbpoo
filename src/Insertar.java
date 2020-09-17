import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insertar {
    final private Scanner s = new Scanner(System.in);
    private PreparedStatement insertar;

    public boolean insertarUser() {
        Conexion conexion = new Conexion();
        Connection con = conexion.getCon();
        boolean r = false;
        try {
            insertar = con.prepareStatement("INSERT INTO usuario VALUES (null,?,?)");
            System.out.println("Ingrese el nombre de user");
            insertar.setString(1, s.nextLine());
            System.out.println("Ingrese la contraseña");
            insertar.setString(2, s.nextLine());
            r = insertar.execute()  ;
            insertar.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {

        }
        return r;
    }
}
