package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection get_connection(){
        Connection conection = null;
        try{
          conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","darvin","");
          if(conection != null){
              System.out.println("Conexion establecida");
          }
        }catch (SQLException e) {
//            throw new RuntimeException(e);
            System.out.println(e);
        }

        return conection;
    };
}
