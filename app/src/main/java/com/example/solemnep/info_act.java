package com.example.solemnep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class info_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

    }
    //intent implicito telefono
    public void marcar(View view)
    {
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel: " + " 965054221"));
        startActivity(i);
    }
        public void volver(View view)
        {
            Intent atras = new Intent(this, home_act.class);
            startActivity(atras);

        }
    //intent implicito mapa
    public void mapa(View view)
    {
        Intent i = new Intent(this, Mapa.class);
        startActivity(i);
    }
}