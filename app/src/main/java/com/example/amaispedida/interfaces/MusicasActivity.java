package com.example.amaispedida.interfaces;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.amaispedida.R;
import com.example.amaispedida.adapters.MusicaListViewAdapter;
import com.example.amaispedida.domain.Musica;

/**
 * Created by João Paulo Bart Dias on 12/07/2017.
 */

public class MusicasActivity extends Activity {
    private ListView listView;
    private MusicaListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicas);

        listView = (ListView) findViewById(R.id.listview_musicas);
        adapter = new MusicaListViewAdapter(getApplicationContext());

        for(int i=0; i<40; i++) {
            Musica musica = new Musica();
            musica.setMusica("Like a rolling Stone");
            musica.setCompositor("Bob Dylan");
            adapter.addItem(musica);
        }

        listView.setAdapter(adapter);
    }
}
