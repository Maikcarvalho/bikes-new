package br.com.senac.mybikes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CatalogosActivity extends AppCompatActivity {
    RecyclerView idRecCatalogo;
    List<Bike> listabikes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalogos_layout);

        idRecCatalogo = findViewById(R.id.idRecCatalogo);

        listabikes = new ArrayList<>();
        //Criando a lista de bicicletas
        //Instanciar e inserir os valores das bikes
        listabikes.add(new Bike("Bike Um", "R$ 4.500,00", "45", R.drawable.bike_um));
        listabikes.add(new Bike("Bike Dois", "R$ 3.500,00", "35", R.drawable.bike_dois));
        listabikes.add(new Bike("Bike Tres", "R$ 4.500,00", "45", R.drawable.bike_tres));
        listabikes.add(new Bike("Bike Quatro", "R$ 3.500,00", "35", R.drawable.bike_quatro));
        listabikes.add(new Bike("Bike Cinco", "R$ 4.500,00", "45", R.drawable.bike_cinco));
        listabikes.add(new Bike("Bike Seis", "R$ 3.500,00", "35", R.drawable.bike_seis));
        listabikes.add(new Bike("Bike Sete", "R$ 4.500,00", "45", R.drawable.bike_sete));
        listabikes.add(new Bike("Bike Oito", "R$ 3.500,00", "35", R.drawable.bike_oito));
        listabikes.add(new Bike("Bike Nove", "R$ 4.500,00", "45", R.drawable.bike_nove));
        listabikes.add(new Bike("Bike Melancia", "R$ 7.500,00", "10", R.drawable.bike_melancia));


        //Montagem do layout que será utilizado na lista
        idRecCatalogo.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

        //Layout do tipo linear
        //idRecCatalogo.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        //Instanciar o adaptador
        MyAdapter adapter = new MyAdapter(getApplicationContext(),listabikes);

        //Vai deixar a lista mais eficiente
        idRecCatalogo.setHasFixedSize(true);

        //Executar a montagem da lista com o modelo
        idRecCatalogo.setAdapter(adapter);
    }
}