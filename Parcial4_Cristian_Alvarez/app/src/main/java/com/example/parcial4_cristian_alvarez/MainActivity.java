package com.example.parcial4_cristian_alvarez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parcial4_cristian_alvarez.Helper.SQLiteOpenHelper;

public class MainActivity extends AppCompatActivity {

    EditText etNombres, etApellidos,etDireccion,etCiudad,etidCl,etidVe;
    EditText etMarca, etModelo;
    EditText etMatricula, etKilometraje;
    Button btAdd;
    Button btEditaryEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etidCl=findViewById(R.id.edtIdCliente);
        etidVe=findViewById(R.id.edtIdVehiculo);
        etCiudad=findViewById(R.id.edtCiudad);
        etNombres=findViewById(R.id.edtNombre);
        etApellidos=findViewById(R.id.edtApellido);
        etDireccion=findViewById(R.id.edtDireccion);
        etMarca=findViewById(R.id.edtMarca);
        etModelo = findViewById(R.id.edtModelo);
        etMatricula=findViewById(R.id.edtMatricula);
        etKilometraje=findViewById(R.id.edtKilometraje);
        btAdd = findViewById(R.id.btnAgregar);
        btEditaryEliminar = findViewById(R.id.btnEditarEliminar);



        btEditaryEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento=new Intent(getApplicationContext(), EditarEliminar.class);
                startActivity(intento);
            }
        });


        SQLiteOpenHelper admin = new SQLiteOpenHelper(getApplicationContext(), "db",null,1);
        SQLiteDatabase db= admin.getWritableDatabase();
        if(db!=null){
            Toast.makeText(this, "Base de datos creada", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Error en crear la Base de datos", Toast.LENGTH_LONG).show();
        }



        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteOpenHelper admin = new SQLiteOpenHelper(getApplicationContext(),"bd",null,1);
                SQLiteDatabase bd= admin.getWritableDatabase();

                String idCl=etidCl.getText().toString();
                String idVe=etidVe.getText().toString();
                String nom=etNombres.getText().toString();
                String ape=etApellidos.getText().toString();
                String dire=etDireccion.getText().toString();
                String ciu=etCiudad.getText().toString();
                String mar=etMarca.getText().toString();
                String mod=etModelo.getText().toString();
                String mat=etMatricula.getText().toString();
                String kil=etKilometraje.getText().toString();

                ContentValues informacion =new ContentValues();

                informacion.put("ID_Cliente",idCl);
                informacion.put("ID_Vehiculos",idVe);
                informacion.put("sNombreCliente",nom);
                informacion.put("sApellidosClientes",ape);
                informacion.put("sDireccionClientes",dire);
                informacion.put("sCiudadCliente",ciu);
                informacion.put("sMarca",mar);
                informacion.put("sModelo",mod);
                informacion.put("sMatricula",mat);
                informacion.put("iKilometros",kil);

                try {
                    bd.insert("MD_Clientes", null, informacion);
                    bd.insert("MD_Vehiculos", null, informacion);
                    bd.insert("MD_ClienteVehiculo", null, informacion);

                    Toast.makeText(getApplicationContext(), "Se inserto ", Toast.LENGTH_LONG).show();
                    bd.close();

                } catch (Exception e){
                    Toast.makeText(getApplicationContext(), ""+e.getCause(), Toast.LENGTH_LONG).show();
                }

            }
        });



    }
}