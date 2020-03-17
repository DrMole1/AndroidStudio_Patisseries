package com.example.patisserie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


// 3 méthodes obligatoires avec l'ArrayAdapter
// - Le constructeur
// - Le GetView() (récupère la donnée et la vue des éléments)
// - Le GetCount() (récupère le nombre d'éléments)
public class Adapter extends ArrayAdapter<Patisserie> {

    //Déclaration des variables
    // ===================================
    ArrayList<Patisserie> PatisserieList;
    Context context;
    int viewRes;
    Resources res;
    // ===================================

    static class ViewHolder{
        TextView title;
        TextView description;
        ImageView image;
    }

    public Adapter(Context context, int textViewResourceId, ArrayList<Patisserie> patisserie){
        super(context,textViewResourceId,patisserie);
        this.PatisserieList = patisserie;
        this.context = context;
        this.res = context.getResources();
        this.viewRes = textViewResourceId;
    }


    @Override
    public View getView(int position, View ConvertView, ViewGroup parent)
    {

        View view = ConvertView;
        // Déclaration variable de classe ViewHolder (déclarée plus haut)
        ViewHolder holder;

        if (view == null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewRes, parent, false);
            holder = new ViewHolder();
            holder.title = (TextView) view.findViewById(R.id.title);
            holder.description = (TextView) view.findViewById(R.id.description);
            holder.image = (ImageView) view.findViewById(R.id.image);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        final Patisserie patisserieElement = PatisserieList.get(position);

        if (patisserieElement != null){
            // Si la patisserie est existante, on prend son nom et sa description, puis on la met dans le holder
            final String patisserieName = String.format("Nom de la patisserie : %s", patisserieElement.getPatisserieName());
            holder.title.setText(patisserieName);
            final String patisserieDesc = String.format("Description : %s", patisserieElement.getPatisserieDesc());
            holder.description.setText(patisserieDesc);
            final int patisserieImage =(patisserieElement.getPatisserieImage());
            holder.image.setImageResource(patisserieImage);
        }

        return view;
    }

    // Méthode qui compte le nombre d'éléments de la liste
    public int getCount() {
        return PatisserieList.size();
    }

}