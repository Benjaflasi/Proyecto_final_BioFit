package com.example.solemnep;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.loader.content.AsyncTaskLoader;

import android.content.AsyncQueryHandler;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import objetos.administradores;
import objetos.insumosB;

public class MainActivity extends AppCompatActivity {

    private EditText user,pass;
    private TextView msj;
    private administradores adm = new administradores();
    private ProgressBar barra;
    private Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user= findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        msj = findViewById(R.id.msj);
        barra = findViewById(R.id.progressBar);
        but = findViewById(R.id.button2);

        barra.setVisibility(View.INVISIBLE);//Hace invisible la barra

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //correr tarea asincrona
                new Task().execute();
            }
        });
    }
        //tarea asincrona
    class Task extends AsyncTask<String,Void,String>
    {
        //definicion de mi tarea inicial
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE);
            msj.setText("Verificando credenciales...");
        }
        //procesar tarea en segundo plano
        @Override
        protected String doInBackground(String... strings) {
            try {
                for (int i = 0; i <=10; i++)
                {
                    Thread.sleep(800);
                }

            }catch (InterruptedException e)
            {
            }
            return null;
        }
        //finaliza tarea
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            barra.setVisibility(View.INVISIBLE);

            String usuario = user.getText().toString().trim();
            String contra = pass.getText().toString().trim();

            String userO = adm.getUser1().trim();
            String userOb = adm.getUser2().trim();
            String passOb = adm.getPass2().trim();
            String passO = adm.getPass1().trim();

            switch (usuario) {
                case "matias" :
                    if (usuario.equals(userO ) && contra.equals(passO))
                    {
                        Intent siguiente = new Intent(getBaseContext(), home_act.class);
                        startActivity(siguiente);
                    }
                    break;
                case  "benjaflasi957":
                    if (usuario.equals( userOb) && contra.equals( passOb))
                    {
                        Intent siguiente = new Intent(getBaseContext(), home_act.class);
                        startActivity(siguiente);

                    }
                    break;
                case "":
                    if (usuario.equals("")&& contra.equals(""))
                    {
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("campos vacios ingrese usuario y contraseña nuevamente");
                    }
                    break;
                default:
                    if(!usuario.equals(userO + userOb)&& !contra.equals(userO + userOb))
                    {
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Datos incorrectos prueba nuevamente");

                    }
                    break;
            }


        }
    }
    public void inicio(View view)
    {
        msj.setText("Verificando credenciales...");

    }
    public void TWITTER(View view)
    {
        Intent I = new Intent(Intent.ACTION_VIEW);//abre web
        I.setData(Uri.parse("https://twitter.com/"));//le paso direccion
        startActivity(I);
    }
    public void FACE(View view)
    {
        Intent I = new Intent(Intent.ACTION_VIEW);//abre web
        I.setData(Uri.parse("https://www.facebook.com//"));//le paso direccion
        startActivity(I);

    }
    public void YOUTUBE(View view)
    {
        Intent I = new Intent(Intent.ACTION_VIEW);//abre web
        I.setData(Uri.parse("https://www.youtube.com/"));//le paso direccion
        startActivity(I);
    }

    public void salir(View view)
    {
        Intent intent =new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}
