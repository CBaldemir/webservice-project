package com.example.comer.myproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.comer.myproject.Models.Items;
import com.example.comer.myproject.Models.Items2;
import com.example.comer.myproject.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by comer on 15.06.2017.
 */
public class CustomNewsAdapter extends ArrayAdapter<Items2> {

    private Context context;
    private ViewHolder viewHolder;
    private List<Items2> arrayList = new ArrayList<Items2>();
    public CustomNewsAdapter(Context context, List<Items2> list_items) {

        super(context, R.layout.item_layout1, list_items);
        this.context = context;
        this.arrayList = list_items;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(view == null){

            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(R.layout.item_layout1, parent,false);

            viewHolder = new ViewHolder();
            viewHolder.header1 = (TextView)view.findViewById(R.id.header1);
            viewHolder.image1 = (ImageView)view.findViewById(R.id.img);
            viewHolder.content1 = (TextView)view.findViewById(R.id.content1);
            viewHolder.author1 = (TextView)view.findViewById(R.id.author1);
            view.setTag(viewHolder);


        }else{

            viewHolder = (ViewHolder) view.getTag();

        }

        //Items items_info = getItem(position);

    viewHolder.author1.setText(arrayList.get(position).getauthor());

    viewHolder.header1.setText(arrayList.get(position).getheader());

    viewHolder.content1.setText((arrayList.get(position).getcontent()));



try {
    HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
    String metin=arrayList.get(position).getcontent().toString();
    String[] contentArray = metin.split("\\s+");

    for (String singleWord : contentArray) {
        Integer token = hashMap.get(singleWord);
        if (token == null) {
            hashMap.put(singleWord, new Integer(1));
        } else {
            hashMap.put(singleWord, hashMap.get(singleWord) + 1);
        }


    }
    for(String word : hashMap.keySet()){

        System.out.println(word + " : "+ hashMap.get(word));

    }
    //viewHolder.tekrar.setText("Merhaba");
}
catch (Exception e)

{}
        // picasso kütüphanesi kullanarak ilgili resmi aldıktan sonra imageview e set ettik
        //Picasso.with(getContext()).load(Constans.URL_IMAGES+arrayList.get(position).getPhoto()).resize(300,300).into(viewHolder.image);


        return view;

    }



    private static class ViewHolder{

        TextView header1;
        ImageView image1;
        TextView content1;
        TextView author1;
       // ListView list;
    }
}