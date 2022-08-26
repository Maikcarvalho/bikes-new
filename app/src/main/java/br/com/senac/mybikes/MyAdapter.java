package br.com.senac.mybikes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    List<Bike> lstBike;

    //Criando o construtor da classe Adaptadora - alt+insert
    public MyAdapter(Context context, List<Bike> lstBike) {
        this.context = context;
        this.lstBike = lstBike;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Instanciar a janela modelo
        View view;

        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.modelo_bike,null);

        //Instanciar a classe ViewHolder
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //Inserir os valores nos componentes do modelo
        holder.txtTitulo.setText(lstBike.get(position).getTitulo());
        holder.txtPreco.setText(lstBike.get(position).getPreco());
        holder.txtDisp.setText(lstBike.get(position).getDisponivel());

        holder.imgBike.setImageResource(lstBike.get(position).getImagemBike());

        //Clique no objeto após o carregamento

        holder.txtBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Passando os valores de uma janela para outra
                Intent intent = new Intent(context,MostrarBikeActivity.class);

                intent.putExtra("titulo",lstBike.get(position).getTitulo());
                intent.putExtra("preco",lstBike.get(position).getPreco());
                intent.putExtra("disponivel",lstBike.get(position).getDisponivel());
                intent.putExtra("imagem",lstBike.get(position).getImagemBike());

                //abrindo a janela
                context.startActivity(intent);



            }
        });

    }

    //Quantos itens a lista vai ter
    @Override
    public int getItemCount() {
        return lstBike.size();
    }

    //Criando uma inner class - classe interna
    public class MyViewHolder extends RecyclerView.ViewHolder{
        //Criando as variáveis globais que representam o modelo
        TextView txtTitulo, txtPreco, txtDisp, txtBotao;
        ImageView imgBike;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //Ligando as variáveis do java para ids do modelo
            txtTitulo = itemView.findViewById(R.id.txtModeloTituloBike);
            txtPreco = itemView.findViewById(R.id.txtModeloPrecoBike);
            txtDisp = itemView.findViewById(R.id.txtModeloDisponivelBike);

            imgBike = itemView.findViewById(R.id.imgModeloBike);
            txtBotao = itemView.findViewById(R.id.txtModeloComprarBike);
        }
    }
}
