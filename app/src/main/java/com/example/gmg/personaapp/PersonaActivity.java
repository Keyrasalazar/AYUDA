package com.example.gmg.personaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PersonaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona);
    }

    public void onClick(View view)
    {
        EditText nombre = (EditText) findViewById(R.id.nombre);
        EditText cedula= (EditText) findViewById(R.id.cedula);
        EditText edad= (EditText) findViewById(R.id.edad);
        EditText peso= (EditText) findViewById(R.id.peso);
        EditText tiposangre=(EditText) findViewById(R.id.tiposangre);

        Persona persona = new Persona(cedula.getText().toString(),
                nombre.getText().toString(),
                Integer.valueOf(edad.getText().toString()),
                Float.valueOf(peso.getText().toString()),
                tiposangre.getText().toString());
        Intent intent = new Intent();
        intent.putExtra("persona",persona);
        setResult(RESULT_OK,intent);
        finish();
    }
}
