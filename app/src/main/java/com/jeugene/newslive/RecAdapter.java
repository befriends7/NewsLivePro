package com.jeugene.newslive;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.Classholder> {

 ArrayList<datalist.Book> datalst;
    private onItemClickListener onItemClickListener;

    public RecAdapter(ArrayList<datalist.Book> datalst) {
        this.datalst = datalst;
    }

    public onItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }



    @NonNull
    @Override
    public Classholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View viewholder = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new Classholder(viewholder);
    }







    @Override
    public void onBindViewHolder(@NonNull Classholder holder, int position) {

        datalist.Book list = datalst.get(position);
        holder.tiitle.setText(list.getTitle());
        holder.desc.setText(list.getDescription());
        holder.author.setText(list.getAuthor());

        Picasso.get().load(list.getBook_image()).fit().into(holder.image1);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick1(list);
            }
        };

        holder.tiitle.setOnClickListener(listener);
        holder.desc.setOnClickListener(listener);
        holder.author.setOnClickListener(listener);
        holder.image1.setOnClickListener(listener);

    }

    @Override
    public int getItemCount() {
        return datalst.size();
    }

    protected class Classholder extends RecyclerView.ViewHolder
    {

        @BindView(R.id.tiitle)
        TextView tiitle;

        @BindView(R.id.desc)
        TextView desc;

        @BindView(R.id.author)
        TextView author;

        @BindView(R.id.image1)
        ImageView image1;

        public Classholder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
