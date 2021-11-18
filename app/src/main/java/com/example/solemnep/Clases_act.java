package com.example.solemnep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.solemnep.database.AdminSQLiteOpenHelper;

public class Clases_act extends AppCompatActivity {


    private EditText codigo, clase, intensidad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clases);

        codigo = findViewById(R.id.ETVCodigo);
        clase = findViewById(R.id.ETVClase);
        intensidad = findViewById(R.id.ETVIntensidad);

    }

    //Metodo para guardar clases
    public void Guardar(View view)
    {

        //obtengo mi base de datos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BioFit", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //le da permisos de sobreescritura

        String code = codigo.getText().toString();
        String clas = clase.getText().toString();
        String intensi = intensidad.getText().toString();

        if(!code.isEmpty() && !clas.isEmpty() && !intensi.isEmpty())
        {
            //guarda datos en caso de no que los campos no estpen vacios
            ContentValues cont = new ContentValues(); //me permite contener valores
            cont.put("codigo", code);
            cont.put("clase", clas);
            cont.put("intensidad", intensi);

            db.insert("clases", null, cont);
            db.close();
            Limpiar(view);

            Toast.makeText(getBaseContext(), "Has guardado una clase", Toast.LENGTH_SHORT).show();

        }
        else
        {
            //Envia mensaje en caso de tener los campos vacios
            Toast.makeText(getBaseContext(), "Hay campos vacios.", Toast.LENGTH_SHORT).show();
        }

    }

    //metodo para mostrar clases
    public void Mostrar (View view)
    {

        //obtengo la base de datos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BioFit", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String code = codigo.getText().toString();

        if(!code.isEmpty())
        {

            //mostramos los datos solicitado

            Cursor file = db.rawQuery("SELECT clase,intensidad FROM clases WHERE codigo =" + code, null);

            if(file.moveToFirst()) //verfica si la consulta tiene valores
            {

                clase.setText(file.getString(0)); //mostrar por posicion
                intensidad.setText(file.getString(1));
                db.close();

            }
            else
            {
                Toast.makeText(getBaseContext(), "No hay clases con ese codigo.", Toast.LENGTH_SHORT).show();
            }

        }
        else
        {
            Toast.makeText(getBaseContext(), "Por favor ingrese un codigo.", Toast.LENGTH_SHORT).show();
        }

    }

    //metodo para eliminar clases
    public void Eliminar(View view)
    {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BioFit", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String code = codigo.getText().toString();

        if(!code.isEmpty())
        {

            //eliminamos a si hay codigo
            db.delete("clases", "codigo = " + code, null);
            db.close();
            Limpiar(view);
            Toast.makeText(getBaseContext(), "has eliminado una clase correctamente, codigo: " + code, Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(getBaseContext(), "Por favor ingrese un codigo.", Toast.LENGTH_SHORT).show();
        }

    }

    //metodo para actualizar clases
    public void Actualizar (View view)
    {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BioFit", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //le da permisos de sobreescritura

        String code = codigo.getText().toString();
        String clas = clase.getText().toString();
        String intensi = intensidad.getText().toString();

        if(!code.isEmpty() && !clas.isEmpty() && !intensi.isEmpty())
        {

            ContentValues cont = new ContentValues(); //me permite contener valores
            cont.put("clase", clas);
            cont.put("intensidad", intensi);

            db.update("clases", cont, "codigo = "+code, null);
            db.close();
            Limpiar(view);

            Toast.makeText(getBaseContext(), "Has actualizado una clase", Toast.LENGTH_SHORT).show();

        }
        else
        {
            //Envia mensaje en caso de tener los campos vacios
            Toast.makeText(getBaseContext(), "Hay campos vacios.", Toast.LENGTH_SHORT).show();
        }

    }

    //metodo extra para limpiar clases
    public void Limpiar(View view)
    {
        codigo.setText("");
        clase.setText("");
        intensidad.setText("");
    }



}