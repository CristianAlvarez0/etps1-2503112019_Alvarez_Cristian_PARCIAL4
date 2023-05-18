package com.example.parcial4_cristian_alvarez;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class EditarEliminar extends AppCompatActivity {

    EditText etNombres, etApellidos,etDireccion,etidCl,etidVe,etCiudad;
    EditText etMarca, etModelo;
    EditText etMatricula, etKilometraje;
    Button btedit,btBuscarporid;
    Button btEliminar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editareliminar);


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
        btedit = findViewById(R.id.btnEditar);
        btEliminar = findViewById(R.id.btnEliminar);
        btBuscarporid=findViewById(R.id.btnBuscar);


       /* btBuscarporid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SQLiteOpenHelper admin = new SQLiteOpenHelper(getApplicationContext(),"bd",null,1);
                SQLiteDatabase bd= admin.getWritableDatabase();

                String idCl=etidCl.getText().toString();

                Cursor filas=bd.rawQuery("select sNombreCliente,sApellidosClientes,sDireccionClientes,sCiudadCliente " +
                        "from bd where ID_Cliente="+idCl,null);

                if(filas.moveToFirst()){
                    etNombres.setText(filas.getString(0));
                    etApellidos.setText(filas.getString(1));
                    etDireccion.setText(filas.getString(2));
                    etCiudad.setText(filas.getString(3));
                }
                else{
                    Toast.makeText(getApplicationContext(),"No se encontro" +
                            " el cliente",Toast.LENGTH_LONG).show();

                }
                bd.close();

            }
        });*/
    }
}