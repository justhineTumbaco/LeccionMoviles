package com.example.kevin.leccion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name =(EditText) findViewById(R.id.editText);
    }

    public void jugar(View view){
        String nombre= name.getText().toString();
        Intent i = new Intent(MainActivity.this, Juego.class);
        i.putExtra("nombre", nombre );
        startActivity(i);
    }
}
