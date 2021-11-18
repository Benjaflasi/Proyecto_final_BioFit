package com.example.solemnep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import objetos.insumosB;

public class Insumos_act extends AppCompatActivity {

    private Spinner spin;
    private TextView msj2;
    private RatingBar valoracion;
    private int precio;
    @Override
    protected void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        spin =findViewById(R.id.spinner);
        msj2 =findViewById(R.id.msj2);
        valoracion =findViewById(R.id.ratingBar);

        //bundle conexion entre activity
        //recibir extras
        Bundle bun = getIntent().getExtras();//guarda en un bundle
        String[] listado = bun.getStringArray("productos");//lo recibo por su referencia

        ArrayAdapter adaptar = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listado);
        spin.setAdapter(adaptar);


    }

    public void calcular(View view)
    {

        insumosB IN = new insumosB();

        String seleccion = spin.getSelectedItem().toString();

        for(int i = 0; i < seleccion.length(); i++)
        {
            if(seleccion.equals(IN.getProductos()[i]))
            {
                precio = IN.getPrecios()[i];
                break;
            }
        }

        if (spin.getSelectedItem().toString().equals("proteina"))
        {
            msj2.setText("usted a seleccionado la opcion numero 1");
            msj2.setText("el precio del producto es " + IN.calcularvalor1(precio, 350));valoracion.setRating(1);
        }
        if  (spin.getSelectedItem().toString().equals("mancuernas"))
        {
            msj2.setText("usted a seleccionado la opcion numero 2");
            msj2.setText("el precio del producto es " + IN.calcularvalor1(precio,350));valoracion.setRating(2);
        }
        if (spin.getSelectedItem().toString().equals("barra"))
        {
            msj2.setText("usted a seleccionado la opcion numero 3");
            msj2.setText("el precio del producto es " + IN.calcularvalor1(precio,350));valoracion.setRating(3);
        }
        if (spin.getSelectedItem().toString().equals("guantes"))
        {
            msj2.setText("usted a seleccionado la opcion numero 4");
            msj2.setText("el precio del producto es " + IN.calcularvalor1(precio,350));valoracion.setRating(4);
        }
        if (spin.getSelectedItem().toString().equals("poleras"))
        {
            msj2.setText("usted a seleccionado la opcion numero 5");
            msj2.setText("el precio del producto es " + IN.calcularvalor1(precio,350));valoracion.setRating(5);
        }
    }
    public void volver(View view)
    {
        Intent atras = new Intent(this, home_act.class);
        startActivity(atras);

    }
}