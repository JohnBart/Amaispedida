package com.example.amaispedida;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by João Paulo Bart Dias on 12/07/2017.
 */

public class MusicaListViewAdapter extends BaseAdapter{
    private ArrayList<Musica> mData = new ArrayList<Musica>();
    private LayoutInflater mInflater;

    public MusicaListViewAdapter(Context context){
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addItem(Musica musica){
        mData.add(musica);
        notifyDataSetChanged();
    }

    @Override
    public int getCount(){
        return mData.size();
    }

    @Override
    public Musica getItem(int position){
        return mData.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
      ViewHolder holder = new ViewHolder();
        if(convertView==null){
            convertView = mInflater.inflate(R.layout.musica_listview, null);
            holder.musicaTextView = (TextView) convertView.findViewById(R.id.musica_textview);
            holder.compositorTextView = (TextView) convertView.findViewById(R.id.compositor_textview);


            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.musicaTextView.setText(mData.get(position).getMusica());
        holder.compositorTextView.setText(mData.get(position).getCompositor());


        return convertView;

    }

    public static class ViewHolder{
        public TextView musicaTextView;
        public TextView compositorTextView;
    }


}
