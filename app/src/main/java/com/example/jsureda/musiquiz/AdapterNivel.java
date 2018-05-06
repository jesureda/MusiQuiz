package com.example.jsureda.musiquiz;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterNivel extends BaseAdapter{

    protected Activity activity;
    protected ArrayList<Nivel> items;

    public AdapterNivel (Activity activity, ArrayList<Nivel> items) {
        this.activity = activity;
        this.items = items;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public void addAll(ArrayList<Nivel> level) {
        for (int i = 0; i < level.size(); i++) {
            items.add(level.get(i));
        }
    }

    @Override
    public Object getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_nivel, null);
        }

        Nivel dir = items.get(position);

        TextView title = (TextView) v.findViewById(R.id.txtNivel);
        title.setText(dir.getNombre());

        ProgressBar barra = (ProgressBar) v.findViewById(R.id.pBarNivel);
        barra.setProgress(dir.getOrden());

        ImageView imagen = (ImageView) v.findViewById(R.id.imgViewNivel);
        if (dir.isBloqueado())
        { imagen.setImageResource(R.drawable.ic_secure);
        }else { imagen.setImageResource(R.drawable.ic_partial_secure);}


        return v;
    }
}
