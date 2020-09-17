import java.sql.*;
import java.util.HashMap;

public class Consultar {
    private ResultSet resultSet;
    private PreparedStatement consultar;
    private Conexion conexion = new Conexion();

    public String[][] consultarUser() {

        Connection con = conexion.getCon();
        String data[][] = new String[14][2];
        try {
            consultar = con.prepareStatement("SELECT * FROM usuario");
            resultSet = consultar.executeQuery();
            resultSet.last();
            int s = resultSet.getRow();
            data = new String[s][2];
            int i = 0;
            resultSet.first();
            while (resultSet.next()) {
                if (i == 0) {
                    resultSet.first();
                }
                data[i][0] = resultSet.getString("usuario");
                data[i++][1] = resultSet.getString("clave");
            }
            resultSet.close();
            consultar.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    public Boolean actualizarDatos(String campo, String valor, String uid) {
        Connection con = conexion.getCon();
        boolean v = false;
        try {
            Statement statement= con.createStatement();
            statement.executeUpdate("UPDATE usuario SET "+ campo + " = "+ "'"+valor+ "'"+" WHERE usuario.idUsuario = "+ uid);
            v=true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return v;
    }

    public Boolean validar(String u, String p) {

        Connection con = conexion.getCon();
        boolean v = false;
        try {
            consultar = con.prepareStatement("SELECT * FROM usuario");
            resultSet = consultar.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("usuario").equals(u) && resultSet.getString("clave").equals(p)) {
                    v = true;
                }
            }
            resultSet.close();
            consultar.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return v;
    }
}
