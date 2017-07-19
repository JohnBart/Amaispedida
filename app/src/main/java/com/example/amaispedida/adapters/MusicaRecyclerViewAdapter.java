package com.example.amaispedida.adapters;
import android.app.LauncherActivity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.amaispedida.R;
import com.example.amaispedida.domain.Musica;

import java.util.List;


/**
 * Created by João Paulo Bart Dias on 18/07/2017.
 */

public class MusicaRecyclerViewAdapter extends RecyclerView.Adapter<MusicaRecyclerViewAdapter.ViewHolder>{
    private List<Musica> mList;
    private Context context;

    public MusicaRecyclerViewAdapter(List<Musica> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.musica_listview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Musica musica = mList.get(position);
        holder.musicaTextView.setText(musica.getMusica());
        holder.compositorTextView.setText(musica.getCompositor()) ;



    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView musicaTextView;
        public TextView compositorTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            musicaTextView = (TextView) itemView.findViewById(R.id.musica_textview);
            compositorTextView = (TextView) itemView.findViewById(R.id.compositor_textview);
        }
    }



}
