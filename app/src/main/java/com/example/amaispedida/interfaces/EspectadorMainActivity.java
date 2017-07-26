package com.example.amaispedida.interfaces;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.example.amaispedida.R;
import com.example.amaispedida.adapters.EventoRecyclerViewAdapter;
import com.example.amaispedida.domain.Evento;

import java.util.ArrayList;
import java.util.List;

public class EspectadorMainActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Evento> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espectador_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_evento);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mList = new ArrayList<>();

        Evento evento;

        evento = new Evento(R.drawable.homer_rock, "The Simpsons", "Rock", "Bar do More", "22 Jun 21:00");
        mList.add(evento);

        evento = new Evento(R.drawable.guns, "Guns n Roses", "Hard Rock", "Maracanã", "19 Ago 20:00");
        mList.add(evento);

        evento = new Evento(R.drawable.acdc, "AC/DC", "Hard Rock", "Allianz Parque", "7 Set 22:00");
        mList.add(evento);

        adapter = new EventoRecyclerViewAdapter(mList, this);
        recyclerView.setAdapter(adapter);
    }

}
