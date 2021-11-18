package com.example.solemnep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.provider.MediaStore;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import objetos.insumosB;

public class home_act extends AppCompatActivity {

    private insumosB In = new insumosB();
    private VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        video= findViewById(R.id.videoView);

        String ruta = "android.resource://" +getPackageName() + "/"+ R.raw.video;
        Uri uri =  Uri.parse(ruta); //uri ayuda con inten implicitos, establece conexacion correctamente
        video.setVideoURI(uri);

        MediaController media = new MediaController(this);//controles
        video.setMediaController(media);

        video.start();//reproduccion solo

    }

    public void perfil(View view)
    {
        Intent siguiente = new Intent(this, perfil_act.class);
        startActivity(siguiente);

    }
    public void info(View view)
    {
        Intent inf = new Intent(this, info_act.class);
        startActivity(inf);

    }
    public void insumos(View view)
    {
        Intent IN = new Intent(this, Insumos_act.class);
        Bundle bun = new Bundle();//necesario para enviar
        bun.putStringArray("productos", In.getProductos());//preraro proceso bundle
        IN.putExtras(bun);//envio de paquete
        startActivity(IN);
    }

    public void clases(View view)
    {
        Intent siguiente = new Intent(this, Clases_act.class);
        startActivity(siguiente);

    }
}