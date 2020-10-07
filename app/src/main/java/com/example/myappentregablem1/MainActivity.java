package com.example.myappentregablem1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private Button btnguardar;
    private ListView listview;
    private EditText txtnombre;
  //  private EditText txtmensaje;
    private List<String> mylist = new ArrayList<>();
    private ArrayAdapter<String> myadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnombre = findViewById(R.id.txtnombre);
     //   txtmensaje = findViewById(R.id.txtmensaje);
        btnguardar = findViewById(R.id.btnguardar);
        btnguardar.setOnClickListener(this);
        listview = findViewById(R.id.listview);
        listview.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnguardar:
                String nombre = txtnombre.getText().toString().trim();
                mylist.add(nombre);
                //  case R.id.btnguardar: String mensaje = txtmensaje.getText().toString().trim();
                //    mylist.add(mensaje);

                txtnombre.getText().clear();
                myadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mylist);
                listview.setAdapter(myadapter);

        }

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
        Toast.makeText(this, "Su Nombre es:  " + mylist.get(posicion), Toast.LENGTH_SHORT).show();

    }
}