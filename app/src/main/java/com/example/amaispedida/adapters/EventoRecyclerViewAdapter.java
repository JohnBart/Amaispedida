package com.example.amaispedida.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amaispedida.R;
import com.example.amaispedida.domain.Evento;
import com.example.amaispedida.domain.Musica;

import java.util.List;

/**
 * Created by João Paulo Bart Dias on 19/07/2017.
 */

public class EventoRecyclerViewAdapter extends RecyclerView.Adapter<EventoRecyclerViewAdapter.ViewHolder>{
    private List<Evento> mList;
    private Context context;


    public EventoRecyclerViewAdapter(List<Evento> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }



    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.evento_listview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Evento evento = mList.get(position);
        holder.imagemArtista.setImageResource(evento.getImagemArtista());
        holder.nomeArtista.setText(evento.getNomeArtista()) ;
        holder.generoMusical.setText(evento.getGeneroMusical());
        holder.localShow.setText(evento.getLocalShow());
        holder.dataShow.setText(evento.getDataHoraShow());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imagemArtista;
        public TextView nomeArtista;
        public TextView generoMusical;
        public TextView localShow;
        public TextView dataShow;

        public ViewHolder(View itemView) {
            super(itemView);
            imagemArtista = (ImageView) itemView.findViewById(R.id.imagem_artista);
            nomeArtista = (TextView) itemView.findViewById(R.id.nome_artista_textView);
            generoMusical = (TextView) itemView.findViewById(R.id.genero_musical_textView);
            localShow = (TextView) itemView.findViewById(R.id.local_show_textView);
            dataShow = (TextView) itemView.findViewById(R.id.data_hora_show_textView);
        }
    }
}
