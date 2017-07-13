package com.example.amaispedida;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by João Paulo Bart Dias on 11/07/2017.
 */

public class EventoListViewAdapter extends BaseAdapter {
    private ArrayList<Evento> mData = new ArrayList<Evento>();
    private LayoutInflater mInflater;

    public EventoListViewAdapter(Context context){
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addItem(Evento evento){
        mData.add(evento);
        notifyDataSetChanged();
    }

    @Override
     public int getCount(){
        return mData.size();
    }

    @Override
    public Evento getItem(int position){
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
            convertView = mInflater.inflate(R.layout.evento_listview, null);
            holder.imagemArtistaImagemView = (ImageView) convertView.findViewById(R.id.imagem_artista);
            holder.nomeArtistaTextView = (TextView) convertView.findViewById(R.id.nome_artista_textView);
            holder.generoMusicalTextView = (TextView) convertView.findViewById(R.id.genero_musical_textView);
            holder.localShowTextView = (TextView) convertView.findViewById(R.id.local_show_textView);
            holder.dataHoraTextView = (TextView) convertView.findViewById(R.id.data_hora_show_textView);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imagemArtistaImagemView.setImageResource(mData.get(position).getImagemArtista());
        holder.nomeArtistaTextView.setText(mData.get(position).getNomeArtista());
        holder.generoMusicalTextView.setText(mData.get(position).getGeneroMusical());
        holder.localShowTextView.setText(mData.get(position).getLocalShow());
        holder.dataHoraTextView.setText(mData.get(position).getDataHoraShow());

        return convertView;

    }

    public static class ViewHolder{
        public ImageView imagemArtistaImagemView;
        public TextView nomeArtistaTextView;
        public TextView generoMusicalTextView;
        public TextView localShowTextView;
        public TextView dataHoraTextView;
    }


}
