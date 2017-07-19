package com.example.amaispedida.interfaces;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.example.amaispedida.R;
import com.example.amaispedida.adapters.MusicaListViewAdapter;
import com.example.amaispedida.adapters.MusicaRecyclerViewAdapter;
import com.example.amaispedida.domain.Musica;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by João Paulo Bart Dias on 12/07/2017.
 */

public class MusicasActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Musica> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicas);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_musicas);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mList = new ArrayList<>();


        String[] musicas = new String[]{"Like a Rolling Stone", "Welcome To The Jungle", "Angie", "Bad Love", "Heartbreak", "Foxy Lady", "Time Stand Still", "Hole in My Soul", "Zombie", "Like a Hurricane", "Love of my life", "Hey hey my my", "TNT", "We Can Work It Out", "Band on the run", "Shine on you crazy diamond"};
        String[] artistas = new String[]{"Bob Dylan", "Guns'n Roses", "Rolling Stones", "Eric Clapton", "Led Zeppelin", "Jimi Hendrix", "Rush", "Aerosmith", "Cramberries", "Scorpions", "Queen", "Neil Young", "AC/DC", "Beatles", "Paul McCartney", "Pink Floyd"};

        for (int i = 0; i < 40; i++) {
            Musica m = new Musica(musicas[i % musicas.length], artistas[i % artistas.length]);
            mList.add(m);
        }

        adapter = new MusicaRecyclerViewAdapter(mList, this);
        recyclerView.setAdapter(adapter);

    }


}
