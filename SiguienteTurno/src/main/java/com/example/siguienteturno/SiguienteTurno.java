package com.example.siguienteturno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SiguienteTurno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siguiente_turno);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
    }


    // Pasa de número en el servidor de la lista de clientes atendidos.
    public void onButtonPressed(View view) {
        String ip = "192.168.0.26";
        int puerto = 7;
        try{
            Socket sk = new Socket(ip,puerto);
            PrintWriter salida = new PrintWriter(new OutputStreamWriter(sk.getOutputStream()),true);
            salida.println("2");
            sk.close();
        }
        catch (Exception e){
            System.out.print(e);
        }
    }

    //Resetea los contadores.
    public void onButtonPressed2(View view) {
        String ip = "192.168.0.26";
        int puerto = 7;
        try{
            Socket sk = new Socket(ip,puerto);
            PrintWriter salida = new PrintWriter(new OutputStreamWriter(sk.getOutputStream()),true);
            salida.println("3");
            sk.close();
        }
        catch (Exception e){
            System.out.print(e);
        }
    }
}