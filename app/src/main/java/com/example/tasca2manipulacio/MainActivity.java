package com.example.tasca2manipulacio;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static final String KEY_COUNTER = "COUNTER";
    static final String MIDA = "";
    static final String KEY_COLORT = "";
    static final String KEY_COLORF = "";


    private int mCounter = 0;
    private float mida1 = 0;
    private int mColorT = 0;
    private int mColorF = 0;

    TextView num;
    int numGuardat;
    boolean amagat = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "In onCreate", Toast.LENGTH_SHORT).show();
        Log.i("info", "On Create");


        setContentView(R.layout.activity_main);
        num = (TextView) findViewById(R.id.num);
    }
    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this, "In onStop", Toast.LENGTH_SHORT).show();
        Log.i("info", "On Stop");

    }
    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this, "In onStart", Toast.LENGTH_SHORT).show();
        Log.i("info", "On Start");

    }
    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, "In onResume", Toast.LENGTH_SHORT).show();
        Log.i("info", "On Resume");

    }
    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(this, "In onPause", Toast.LENGTH_SHORT).show();
        Log.i("info", "On Pause");

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "In onDestroy", Toast.LENGTH_SHORT).show();
        Log.i("info", "On Destroy");

    }




    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNTER, Integer.parseInt(num.getText().toString()));
        outState.putInt(MIDA, Math.round(num.getTextSize()));
        outState.putInt(KEY_COLORT, num.getCurrentTextColor());
        outState.putInt(KEY_COLORF, num.getCurrentHintTextColor());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        mCounter = savedInstanceState.getInt(KEY_COUNTER);
        mida1 = savedInstanceState.getInt(MIDA);
        mColorT = savedInstanceState.getInt(KEY_COLORT);
        mColorF = savedInstanceState.getInt(KEY_COLORF);


        num.setText(String.valueOf(mCounter));

        mida1 = mida1 /getResources().getDisplayMetrics().scaledDensity;
        num.setTextSize(mida1);

        num.setTextColor(mColorT);

        num.setBackgroundColor(mColorF);
    }




    //funcio per sumar
    public void sumar(View v){
        if (!amagat){
            int numActu = Integer.parseInt(num.getText().toString());
            numActu++;
            numGuardat = numActu;
            num.setText(""+numActu);
        }
    }
    //funcio per restar
    public void resta(View v){
        if (!amagat){
            int numActu = Integer.parseInt(num.getText().toString());
            numActu--;
            numGuardat = numActu;
            num.setText(""+numActu);
        }


    }

    //funcio per aumentar la mida del text
    public void aumentar(View v){
       float mida = num.getTextSize();
       if (mida < 385){
           mida = mida /getResources().getDisplayMetrics().scaledDensity;
           mida = mida + 5;
           num.setTextSize(mida);
       }

    }

    //funcio per disminuir la mida del text
    public void disminuir(View v){
        float mida = num.getTextSize();
        if (mida > 40){
            mida = mida /getResources().getDisplayMetrics().scaledDensity;
            mida = mida - 5;
            num.setTextSize(mida);
        }
    }


    //funcio per amagar del text
    public void amagar(View v){

        if (!amagat){
            int numActu = Integer.parseInt(num.getText().toString());
            numGuardat = numActu;
        }
        num.setText("");
        amagat = true;

    }

    //funcio per mostrar el text
    public void mostrar(View v){
        num.setText(""+numGuardat);
        amagat = false;
    }

    //funcio per canviar el color del text a un color aleatori
    public void colorText(View v){
        Random rnd = new Random();
        int color = Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        num.setTextColor(color);


    }

    //funcio per canviar el color del fons a un color aleatori
    public void colorFons(View v){
        Random rnd = new Random();
        int color = Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        num.setBackgroundColor(color);

    }



}