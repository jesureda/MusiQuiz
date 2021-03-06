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
        this.items=items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater)
                    activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_nivel, null);
        }

        Nivel niv = items.get(position);

        TextView title = v.findViewById(R.id.txtNivel);
        title.setText(niv.getNombre());

        ProgressBar barra = v.findViewById(R.id.pBarNivel);
        barra.setProgress(niv.getProgreso()*10);

        ImageView imagen = v.findViewById(R.id.imgViewNivel);
        if (niv.getBloqueado()>0)
        { imagen.setImageResource(R.drawable.ic_secure);
        }else { imagen.setImageResource(R.drawable.ic_partial_secure);}

        return v;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
