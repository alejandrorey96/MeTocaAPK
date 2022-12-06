package com.example.metocaapk;

import android.content.Intent;
import android.os.StrictMode;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.metocaapk.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    //private TextView pantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*pantalla = (TextView) findViewById(R.id.Texto01);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .permitNetwork().build());
        ejecutaCliente();*/
    }

    public void onButtonPressed(View view) {
        Intent intent = new Intent(this,NumTurno.class);
        startActivity(intent);
    }

    /*private void ejecutaCliente(){
        String ip = "192.168.0.26";
        int puerto = 7;
        log(" socket " + ip + " " + puerto);
        try{
            Socket sk = new Socket(ip,puerto);
            BufferedReader entrada = new BufferedReader(new
                    InputStreamReader(sk.getInputStream()));
            PrintWriter salida = new PrintWriter(
                    new OutputStreamWriter(sk.getOutputStream()),true);
            log("enviando ... Hola Mundo!");
            salida.println("Hola mundo");
            log("recibiendo ... " + entrada.readLine());
            sk.close();
        }
        catch (Exception e){
            log("error: " + e.toString());
        }
    }*/

    /*private void log(String cadena){
        pantalla.append(cadena + "\n");
    }*/

}