package com.example.servidormetoca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMeToca {


    public static void main(String[] args){

        //Se inicializan las variables que funcionarán como número a dar al cliente y número a atender.
        int turnosCogidos = 0;
        int turnoActual = 0;

        //Se inicia el servidor
        try{
            System.out.println("Servidor en marcha...");
            ServerSocket sk = new ServerSocket(7);
            while(true){
                //Se acepta la conexión del cliente y/o botón.
                Socket input = sk.accept();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(input.getInputStream()));
                PrintWriter salida = new PrintWriter(new OutputStreamWriter(input.getOutputStream()));
                //Se lee el número (En string y luego se pasa a integer) y se manda al switch.
                String nuevo = entrada.readLine();
                int inputInt = Integer.parseInt(nuevo);

                //Según que input reciba, se ejecutará:
                switch (inputInt){
                    //Se envía número al cliente y se se suma 1 a la cola.
                    case 1:
                        turnosCogidos++;
                        String turno= Integer.toString(turnosCogidos);
                        salida.println(turno);
                        System.out.println(turnosCogidos);
                        break;
                    //Se suma uno a la lista de clientes atendidos y se envía el Nº de cliente actual a todos los clientes.
                    case 2:
                        turnoActual++;
                        String turnoAct= Integer.toString(turnosCogidos);
                        salida.println(turnoAct);
                        System.out.println(turnoActual);
                        break;
                    //El operador podrá resetear a 0 ambas listas.
                    case 3:
                        turnoActual = 0;
                        turnosCogidos = 0;
                        System.out.println(turnoActual + "" + turnosCogidos);
                        break;
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}
