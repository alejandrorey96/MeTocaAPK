package com.example.metocaapk;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class NumTurno extends AppCompatActivity {

    TextView turnoNo;
    TextView alerta;
    TextView proceda;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num_turno);
        turnoNo = (TextView) findViewById(R.id.Contador);
        alerta = (TextView) findViewById(R.id.Aviso1);
        proceda = (TextView) findViewById(R.id.Aviso2);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        ejecutaCliente();
    }

    private void ejecutaCliente(){
        String ip = "192.168.0.26";
        int puerto = 7;
        try{
            //Conectamos con el servidor local.
            Socket sk = new Socket(ip,puerto);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            PrintWriter salida = new PrintWriter(new OutputStreamWriter(sk.getOutputStream()),true);
            //Enviamos 1, que indica al servidor que sume una persona a la cola.
            salida.println("1");
            //Recibimos String del número que nos toca.
            String turnoS = entrada.readLine();
            //Mostramos el número de turno por pantalla.
            mostrarTurno(turnoS);
            System.out.print(turnoS);
            //Lo convertimos a integer para usar como dato a comparar.
            int turno = Integer.parseInt(turnoS);
            int turnoActual;
            do{
                do{
                    //Mientras el número que ha recibido el cliente sea mayor o igual al de cliente atendido -1,
                    // no saldrá del bucle y estará en espera.
                    String turnoActualS = entrada.readLine();
                    turnoActual = Integer.parseInt(turnoActualS);

                }while ((turno-1)>=turnoActual);
                //Mientras el número que ha recibido el cliente sea mayor o igual al de cliente atendido,
                // no saldrá del bucle y estará en espera.
                mostrarAlerta(); //Se envía alerta 1.
                String turnoActualS = entrada.readLine();
                turnoActual = Integer.parseInt(turnoActualS);

            }while(turno>=turnoActual);
            mostrarProceda();//Se envía alerta 2.
            sk.close();
        }
        catch (Exception e){
            System.out.print(e);
        }
    }
    private void mostrarTurno(String turno){
        turnoNo.append(turno);
    }

    private void mostrarAlerta(){
        alerta.append("Su turno está cerca");
    }

    private void mostrarProceda(){
        proceda.append("Me Toca!");
    }
}
