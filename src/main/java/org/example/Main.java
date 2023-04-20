package org.example;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        Conexion conexion = new Conexion();
        do {
            System.out.println("----------------");
            System.out.println("Aplicacion de mensajes");
            System.out.println("1. Crear mensaje");
            System.out.println("2. Listar mensaje");
            System.out.println("3. Eliminar mensaje");
            System.out.println("4. Editar mensaje");
            System.out.println("5. Salir \n");

            System.out.println("Seleccione una opcion:");
            option = sc.nextInt();

            switch (option){
                case 1:
                    MensajesServices.crearMensaje();
                    break;
                case 2:
                    MensajesServices.listarMensajes();
                    break;
                case 3:
                    MensajesServices.borrarMensaje();
                    break;
                case 4:
                    MensajesServices.editarMensaje();
                    break;
                default:
                    System.out.println("Debe eleigir una opcion valida");
                    break;
            }
        }while (option != 5);

    }
}