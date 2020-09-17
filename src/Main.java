import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        Insertar i= new Insertar();
        if (!i.insertarUser()){}
        Consultar c =new Consultar();
        c.consultarUser();
    }
}
