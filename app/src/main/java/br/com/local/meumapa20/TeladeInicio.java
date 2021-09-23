package br.com.local.meumapa20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TeladeInicio extends AppCompatActivity {


    private Button btn1;
    private EditText lat;
    private EditText lgn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telade_inicio);
        lat = (EditText) findViewById(R.id.lat);
        lgn = (EditText) findViewById(R.id.lgn);
    }


    public void onClickbtn1(View view) {
        double latitude = Double.parseDouble(lat.getText().toString());
        double longitude = Double.parseDouble(lgn.getText().toString());

       Intent intentEnviadora = new Intent(getApplicationContext(), MapsActivity.class);
       Bundle Parametros = new Bundle();

       Parametros.putDouble("Chave_lat", latitude);
       Parametros.putDouble("Chave_lgn", longitude);

        intentEnviadora.putExtras(Parametros);
        startActivity(intentEnviadora);

    }
}