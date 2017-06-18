package com.example.comer.myproject.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.comer.myproject.R;
import com.google.android.gms.common.api.GoogleApiClient;

public class TwoNewsRepeat extends Activity {
    private TextView textview;
    private TextView textview1;
    private TextView textview2;
    private TextView textview3;
    private TextView textview4;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twonewsrepeat);

        textview = (TextView) findViewById(R.id.text1);
        textview1 = (TextView) findViewById(R.id.text2);
        textview2 = (TextView) findViewById(R.id.text3);
        textview3 = (TextView) findViewById(R.id.text4);
        textview4 = (TextView) findViewById(R.id.text5);

        textview.setText("The" + " " + "45" + " " + "Belgili tanımlılık anlamına gelir.");
        textview1.setText("To" + " " + "32" + " " + "İçin, e, e doğru anlamlarına gelir.");
        textview2.setText("A" + " " + "31" + " " + "Bir anlamına gelir.");
        textview3.setText("And" + " " + "20" + " " + "Ve anlamına gelir.");
        textview4.setText("Of" + " " + "13" + " " + "Nin, in, den anlamına gelir.");

    }


}


