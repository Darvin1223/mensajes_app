package org.example;

import org.example.Modelo.Mensajes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDao {

    public static void crearMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try{
                String query ="INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?,?)";
                ps= conexion.prepareStatement(query);
                ps.setString(1,mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("El mensaje fue creado correctamente");
            }catch (SQLException x){
                System.out.println(x);
            }

        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void leerMensajeDB(){
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs= null;
        try(Connection conexion = db_connect.get_connection()) {
          String query = "SELECT * FROM mensajes";
          ps = conexion.prepareStatement(query);
          rs = ps.executeQuery();

          while(rs.next()){
              System.out.println("ID: " + rs.getInt("id_mensaje"));
              System.out.println("Mensaje: " + rs.getString("mensaje"));
              System.out.println("Autor: " + rs.getString("autor_mensaje"));
              System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
              System.out.println("\n");
          }

        }catch (SQLException e){
            System.out.println("Hubo un problem al tratar de recuperar los mensajes");
            System.out.println(e);
        }
    }

    public static void borrarMensajeDB(int id){
        Conexion db_connect = new Conexion();


        try(Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;

            try{
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id);
                ps.executeUpdate();
                System.out.println("El mensaje fue eliminado");
            }catch (Exception ex){
                System.out.println("Hubo un error al tratar de eliminar el mensaje!!!");
                System.out.println(ex);
            }
        }catch (SQLException e){
        System.out.println(e);
    }
    }

    public static void actualizarMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();


        try(Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try{
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("El mensaje fue actualizado");
            }catch (Exception ex){
                System.out.println("Hubo un problema con la actualizacion del mensaje");
                System.out.println(ex);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
