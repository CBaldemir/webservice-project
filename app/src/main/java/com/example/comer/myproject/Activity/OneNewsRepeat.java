package com.example.comer.myproject.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.comer.myproject.Adapter.CustomNewsAdapter;
import com.example.comer.myproject.Interface.RestInterfaceController2;
import com.example.comer.myproject.Models.Items2;
import com.example.comer.myproject.Models.retrofitModel;
import com.example.comer.myproject.R;
import com.example.comer.myproject.Utils.Constans;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class OneNewsRepeat extends Activity {
    private TextView textview;
    private TextView textview1;
    private TextView textview2;
    private TextView textview3;
    private TextView textview4;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onenewsrepeat);

        textview = (TextView) findViewById(R.id.text1);
        textview1 = (TextView) findViewById(R.id.text2);
        textview2 = (TextView) findViewById(R.id.text3);
        textview3 = (TextView) findViewById(R.id.text4);
        textview4 = (TextView) findViewById(R.id.text5);

        textview.setText("The" + " " + "39" + " " + "Belgili tanımlılık anlamına gelir.");
        textview1.setText("And" + " " + "25" + " " + "Ve anlamına gelir.");
        textview2.setText("To" + " " + "18" + " " + "İçin, e, e doğru anlamlarına gelir");
        textview3.setText("Of" + " " + "17" + " " + "Nin, in, den anlamına gelir");
        textview4.setText("A" + " " + "13" + " " + "Bir anlamına gelir.");

    }


}


