package com.example.solemnep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class perfil_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
    }

    public void volver(View view)
    {
        Intent atras = new Intent(this, home_act.class);
        startActivity(atras);
    }

    public void correo1(View view)
    {
        Intent In = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:matiasetter@gmail.com"));
        startActivity(In);

    }
    public void correo2(View view)
    {
        Intent In = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:dbenjamin12345d@gmail.com"));
        startActivity(In);

    }

}
