package com.example.comer.myproject.Activity;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.comer.myproject.Adapter.CustomAdapter;
import com.example.comer.myproject.Interface.RestInterfaceController;
import com.example.comer.myproject.Models.Items;
import com.example.comer.myproject.Models.retrofitModel;
import com.example.comer.myproject.R;
import com.example.comer.myproject.Utils.Constans;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

public class MainActivity extends Activity {


    private ListView listview;
    TextView textView;
    private RestAdapter restAdapter;
    private RestInterfaceController restInterface;
    private ProgressDialog progressDialog;
    private List<Items> list = new ArrayList<Items>();
    private CustomAdapter customAdapter;
    private static final int REQUEST_PERMISSIONS = 0;
    List<String> izinler = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listview);
        textView=(TextView) findViewById(R.id.tekrarlanan);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listintent=new Intent(getApplicationContext(), ListActivity.class);
                startActivity(listintent);

            }
        });

        // adapter ve servis oluşturma
        restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constans.URL)
                .build();

        restInterface = restAdapter.create(RestInterfaceController.class);


        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Yükleniyor..");
        progressDialog.setCancelable(false);
        progressDialog.show();

        restInterface.getJsonValues(new Callback<retrofitModel[]>() { // json array döneceği için modelimizi array tipinde belirledik


            @Override
            public void success(retrofitModel[] model, retrofit.client.Response response) {
                for (retrofitModel modelValues : model) {

                    Items items = new Items();
                    items.setheader(modelValues.getHeader());
                    items.setcontent(modelValues.getContent());
                    items.setauthor(modelValues.getAuthor());
                    items.setPhoto(modelValues.getPhoto());
                    items.setnewsId(modelValues.getNewsId());
                    list.add(items);

                }

                progressDialog.cancel();

                customAdapter = new CustomAdapter(getApplicationContext(), list);
                listview.setAdapter(customAdapter);


            }

            @Override
            public void failure(RetrofitError error) {

                String merror = error.getMessage();
                Toast.makeText(getApplicationContext(), merror, Toast.LENGTH_LONG).show();
            }
        });


        //İzin olayını kontrol ediyoruz.
        int internetizni = ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET);

        if(internetizni != PackageManager.PERMISSION_GRANTED){
            izinler.add(Manifest.permission.INTERNET);
        }

        if(!izinler.isEmpty())
        {
            ActivityCompat.requestPermissions(this,izinler.toArray(new String[izinler.size()]) , REQUEST_PERMISSIONS);
        }

//Listview Click olayı
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                        // listview in hangi itemine tıklandıysa diğer sayfada ilgili resmi göstermek için sunucudan gelen resmin adını yolluyoruz.
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getApplicationContext(), SecondNews.class);

                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getApplicationContext(), ThirdNews.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getApplicationContext(), FourNews.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(getApplicationContext(), FiveNews.class);
                        startActivity(intent4);
                        break;
                }
            }
        });
    }

// İzin işlemleri
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch ( requestCode ) {
            case REQUEST_PERMISSIONS: {
                for (int i = 0; i < permissions.length; i++) { // İstediğimiz izinler dolaşalım
                    if (grantResults[i] == PackageManager.PERMISSION_GRANTED) { // Eğer izin verilmişse
                        Log.d("Permissions", "İzin Verildi: " + permissions[i]); // İsmiyle birlikte izin verildi yazıp log basalım.

// İzin verildiği için burada istediğiniz işlemleri yapabilirsiniz. Verilen izne göre verileri internetten çekebilir..
                    } else if (grantResults[i] == PackageManager.PERMISSION_DENIED) { // Eğer izin reddedildiyse
                        Log.d("Permissions", "İzin Reddedildi: " + permissions[i]); // İsmiyle birlikte reddedildi yazıp log basalım.
// Burada bir toast mesajı gösterebilirsiniz. Mesela bu işlemi yapabilmek için izin vermeniz gereklidir. gibi..
                    }
                }
            }
            break;
            default: {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }}}