package com.example.comer.myproject.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.comer.myproject.Adapter.CustomNewsAdapter;
import com.example.comer.myproject.Interface.RestInterfaceController5;
import com.example.comer.myproject.Models.Items2;
import com.example.comer.myproject.Models.retrofitModel;
import com.example.comer.myproject.R;
import com.example.comer.myproject.Utils.Constans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

public class FourNews extends Activity {


    private ListView listview;
    private RestAdapter restAdapter;
    private RestInterfaceController5 restInterface;
    private ProgressDialog progressDialog;
    private List<Items2> list = new ArrayList<>();
    private CustomNewsAdapter customNewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listview = (ListView)findViewById(R.id.listview1);


        Items2 item = new Items2();


        try {
            String yazi = item.getcontent().toString();
            String textars1=yazi.toLowerCase();
            String control[]=textars1.split("[(' '),.-]");
            HashMap<String,Integer> uniques= new HashMap<String, Integer>();
            for (String word : control) {
                if (word.length() <= 2) {
                    continue;
                }
                Integer existingCount = uniques.get(word);
                uniques.put(word, (existingCount == null ? 1 : (existingCount + 1)));
            }

            Set<Map.Entry<String,Integer>> uniqueset = uniques.entrySet();
            for (Map.Entry<String,Integer>entry:uniqueset)
            {
                if (entry.getValue()>1)
                {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                    // Makale içinde tekrarlan ne kadar kelime olduğunu konsola yazar.
                }

            }
        }
        catch (Exception e1)
        {e1.printStackTrace();}





        // adapter ve servis oluşturma
        restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constans.URL)
                .build();

        restInterface = restAdapter.create(RestInterfaceController5.class);

        progressDialog = new ProgressDialog(FourNews.this);
        progressDialog.setMessage("Yükleniyor..");
        progressDialog.setCancelable(false);
        progressDialog.show();

        restInterface.getJsonValues(new Callback<retrofitModel[]>() { // json array döneceği için modelimizi array tipinde belirledik


            @Override
            public void success(retrofitModel[] model, retrofit.client.Response response) {
                for (retrofitModel modelValues : model) {

                    Items2 items2 = new Items2();

                    items2.setheader(modelValues.getHeader());
                    items2.setcontent(modelValues.getContent());
                    items2.setauthor(modelValues.getAuthor());
                    items2.setPhoto(modelValues.getPhoto());
                    items2.setnewsId(modelValues.getNewsId());
                    list.add(items2);

                }

                progressDialog.cancel();

                customNewsAdapter = new CustomNewsAdapter(getApplicationContext(),list);
                listview.setAdapter(customNewsAdapter);


            }

            @Override
            public void failure(RetrofitError error) {

                String merror = error.getMessage();
                Toast.makeText(getApplicationContext(),merror,Toast.LENGTH_LONG).show();
            }
        });
    }



}

       /* listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(),DetailsActivity.class);
                // listview in hangi itemine tıklandıysa diğer sayfada ilgili resmi göstermek için sunucudan gelen resmin adını yolluyoruz.
                intent.putExtra("image_name",list.get(position).getPhoto());

                startActivity(intent);



            }
        });
*/
