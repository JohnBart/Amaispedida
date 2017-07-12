package com.example.amaispedida;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class EspectadorMainActivity extends Activity {

    private ListView listView;
    private EventoListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espectador_main);

        listView = (ListView) findViewById(R.id.listview_evento);
        adapter = new EventoListViewAdapter(getApplicationContext());

        for(int i=0; i<10; i++) {
            Evento evento = new Evento();
            evento.setNomeArtista("Homer Simpson");
            evento.setGeneroMusical("Rock");
            evento.setImagemArtista(R.drawable.homer_rock);
            evento.setLocalShow("Bar do Moe");
            evento.setDataHoraShow("22 julho/19:00");

            adapter.addItem(evento);
        }
        listView.setAdapter(adapter);
    }

}
