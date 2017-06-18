package com.example.comer.myproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.comer.myproject.Models.Items;
import com.example.comer.myproject.R;
import com.example.comer.myproject.Utils.Constans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by comer on 15.06.2017.
 */
public class CustomAdapter extends ArrayAdapter<Items> {

    private Context context;
    private ViewHolder viewHolder;
    private List<Items> arrayList = new ArrayList<Items>();
    public CustomAdapter(Context context, List<Items> list_items) {

        super(context, R.layout.item_layout, list_items);
        this.context = context;
        this.arrayList = list_items;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(view == null){

            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(R.layout.item_layout, parent,false);

            viewHolder = new ViewHolder();
            viewHolder.header = (TextView)view.findViewById(R.id.header);
            viewHolder.image = (ImageView)view.findViewById(R.id.img);
            viewHolder.content = (TextView)view.findViewById(R.id.content);
            viewHolder.author = (TextView)view.findViewById(R.id.author);

            view.setTag(viewHolder);


        }else{

            viewHolder = (ViewHolder) view.getTag();

        }

        //Items items_info = getItem(position);

        viewHolder.header.setText(arrayList.get(position).getheader());

        viewHolder.content.setText(arrayList.get(position).getcontent());

        viewHolder.author.setText((arrayList.get(position).getauthor()));


        // picasso kütüphanesi kullanarak ilgili resmi aldıktan sonra imageview e set ettik
        //Picasso.with(getContext()).load(Constans.URL_IMAGES+arrayList.get(position).getPhoto()).resize(300,300).into(viewHolder.image);


        return view;

    }



    private static class ViewHolder{

        TextView header;
        ImageView image;
        TextView content;
        TextView author;
    }
}