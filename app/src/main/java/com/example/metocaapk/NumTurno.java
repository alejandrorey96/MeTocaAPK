package com.example.metocaapk;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class NumTurno extends AppCompatActivity {

    private TextView pantalla;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num_turno);

        pantalla = (TextView) findViewById(R.id.Texto01);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        ejecutaCliente();

    }

    private void ejecutaCliente(){
        String ip = "192.168.0.26";
        int puerto = 7;
        log(" socket " + ip + " " + puerto);
        try{
            Socket sk = new Socket(ip,puerto);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            PrintWriter salida = new PrintWriter(new OutputStreamWriter(sk.getOutputStream()),true);
            log("enviando ... Hola Mundo!");
            salida.println("Hola mundo");
            log("recibiendo ... " + entrada.readLine());
            sk.close();
        }
        catch (Exception e){
            System.out.print(e);
        }
    }
    private void log(String cadena){
        pantalla.append(cadena + "\n");
    }
}
