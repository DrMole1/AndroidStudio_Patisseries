package com.example.patisserie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // On initialise la liste avec une variable de type Patisserie
    // On lui affecte des valeurs grâce aux mutateurs pour on add() la version à la liste
    private void initList(ArrayList<Patisserie> androidList){
        Patisserie patisserie = new Patisserie();
        patisserie.setPatisserieName("Dorayaki");
        patisserie.setPatisserieDesc("Dessert japonais aux haricots rouges sucrés.");
        patisserie.setPatisserieImage(R.drawable.dorayaki);
        androidList.add(patisserie);

        Patisserie patisserie2 = new Patisserie();
        patisserie2.setPatisserieName("Gaufre");
        patisserie2.setPatisserieDesc("A ne pas confondre avec la gaufre bleue.");
        patisserie2.setPatisserieImage(R.drawable.gaufre);
        androidList.add(patisserie2);

        Patisserie patisserie3 = new Patisserie();
        patisserie3.setPatisserieName("Macaron");
        patisserie3.setPatisserieDesc("Un peu cher, mais que c'est bon !");
        patisserie3.setPatisserieImage(R.drawable.macaron);
        androidList.add(patisserie3);

        Patisserie patisserie4 = new Patisserie();
        patisserie4.setPatisserieName("Millefeuille");
        patisserie4.setPatisserieDesc("Mille couches de ganaches et de plaisir.");
        patisserie4.setPatisserieImage(R.drawable.millefeuille);
        androidList.add(patisserie4);

        Patisserie patisserie5 = new Patisserie();
        patisserie5.setPatisserieName("Muffin");
        patisserie5.setPatisserieDesc("Ceux au choloclat sont mes préférés.");
        patisserie5.setPatisserieImage(R.drawable.muffin);
        androidList.add(patisserie5);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        // On créée la liste dans la création de l'activité
        ArrayList<Patisserie> androidList= new ArrayList<Patisserie>();
        // On initialise (méthode en haut)
        initList(androidList);
        // On créée un adapter pour cette liste en prenant en compte le modèle (le moule)
        final Adapter adapter = new Adapter(this,R.layout.modele_list,androidList);
        // On créée l'activité principale et on pose l'adapter sur cette vue
        final ListView list= (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);

        // Mise en place du filter
        EditText filter = (EditText)findViewById(R.id.filter);
        // Lorsqu'on édite le filter
        filter.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Ne marche pas, mais j'aurai essayé
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // Quand on clique sur un élément de liste, indique la position et le nom de la patisserie sélectionnée
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Patisserie selectedItem= (Patisserie)adapter.getItemAtPosition(position);
                Log.v("ListPersonnalisée", "Element selectionné: " + selectedItem.getPatisserieName());

                // Lancement de l'activité relative à la patisserie cliquée
                if(selectedItem.getPatisserieName() == "Dorayaki")
                {
                    Intent IntentDorayaki = new Intent(MainActivity.this, EcranDorayaki.class);
                    startActivity(IntentDorayaki);
                }
                else if(selectedItem.getPatisserieName() == "Gaufre")
                {
                    Intent IntentGaufre = new Intent(MainActivity.this, EcranGaufre.class);
                    startActivity(IntentGaufre);
                }
                else if(selectedItem.getPatisserieName() == "Macaron")
                {
                    Intent IntentMacaron = new Intent(MainActivity.this, EcranMacaron.class);
                    startActivity(IntentMacaron);
                }
                else if(selectedItem.getPatisserieName() == "Millefeuille")
                {
                    Intent IntentMillefeuille = new Intent(MainActivity.this, EcranMillefeuille.class);
                    startActivity(IntentMillefeuille);
                }
                else if(selectedItem.getPatisserieName() == "Muffin")
                {
                    Intent IntentMuffin = new Intent(MainActivity.this, EcranMuffins.class);
                    startActivity(IntentMuffin);
                }
            }
        });
    }
}