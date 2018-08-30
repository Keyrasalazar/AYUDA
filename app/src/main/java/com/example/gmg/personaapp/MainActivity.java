package com.example.gmg.personaapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Persona> personaList= new ArrayList<>();
    private ListView lvPersona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvPersona=(ListView) findViewById(R.id.lvPersona);
        PersonaAdapter adapter= new PersonaAdapter(this,R.layout.layout_item_persona, personaList);
        lvPersona.setAdapter(adapter);
    registerForContextMenu(lvPersona);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opcion,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_contextual,menu);
        menu.setHeaderTitle("opciones");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this,PersonaActivity.class);
        startActivityForResult(intent,1234);
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if(item.getItemId()==R.id.borrar)
        {
            personaList.remove(info.position);
        }
        else
        {

        }
        actualizarListView();
        return super.onContextItemSelected(item);
    }








    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1234 && resultCode==RESULT_OK)
        {
            Persona p= (Persona) data.getExtras().get("persona");
            personaList.add(p);
        }
        actualizarListView();
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void actualizarListView()
    {
        ((PersonaAdapter)lvPersona.getAdapter()).notifyDataSetChanged();

    }


}
