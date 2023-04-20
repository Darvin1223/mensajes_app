package org.example;

import org.example.Modelo.Mensajes;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MensajesServices {

    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el mensaje:");
        String mensaje = sc.nextLine();
        System.out.println("\n");
        System.out.println("Cual es tu nombre?");
        String autor = sc.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(autor);
        MensajesDao.crearMensajeDB(registro);
    }

    public static void listarMensajes(){
        MensajesDao.leerMensajeDB();
    }

    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el ID del mensaje a borrar: ");
        int id = sc.nextInt();
        MensajesDao.borrarMensajeDB(id);
    }

    public static void editarMensaje(){

    }
}
