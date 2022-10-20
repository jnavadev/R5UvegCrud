package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crud.db.DbRestaurantes;

public class NuevoActivity extends AppCompatActivity {

    EditText txtName;
    Button btnGuarda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtName = findViewById(R.id.txtName);
        btnGuarda = findViewById(R.id.btnGuarda);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbRestaurantes dbRestaurantes = new DbRestaurantes(NuevoActivity.this);
                long id = dbRestaurantes.insertaRestaurante(txtName.getText().toString());

                if(id > 0){
                    Toast.makeText(NuevoActivity.this, "Restaurante registrado", Toast.LENGTH_LONG).show();
                    limpiar();
                } else{
                    Toast.makeText(NuevoActivity.this, "Error al guardar", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void limpiar(){
        txtName.setText("");
    }
}