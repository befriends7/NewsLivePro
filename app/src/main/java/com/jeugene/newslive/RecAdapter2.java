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

public class RecAdapter2 extends RecyclerView.Adapter<RecAdapter2.Classholder> {

 ArrayList<datalst2.Doc> datalst2;

    private onItemClickListener onItemClickListener;

    public RecAdapter2(ArrayList<datalst2.Doc> datalst2) {
        this.datalst2 = datalst2;
    }

    public onItemClickListener getOnItemClickListener2() {
        return onItemClickListener;
    }

    public void setOnItemClickListener2(onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public Classholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View viewholder = LayoutInflater.from(parent.getContext()).inflate(R.layout.row2,parent,false);
        return new Classholder(viewholder);
    }

    @Override
    public void onBindViewHolder(@NonNull Classholder holder, int position) {

        datalst2.Doc list = datalst2.get(position);
        holder.snipet.setText(list.getSnippet());
        holder.para.setText(list.getLead_paragraph());
        holder.url.setText(list.getWeb_url());

        Picasso.get().load(R.drawable.news2).fit().into(holder.image2);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick2(list);
            }
        };


        holder.snipet.setOnClickListener(listener);
        holder.para.setOnClickListener(listener);
        holder.url.setOnClickListener(listener);
        holder.image2.setOnClickListener(listener);

    }

    @Override
    public int getItemCount() {
        return datalst2.size();
    }

    protected class Classholder extends RecyclerView.ViewHolder
    {

        @BindView(R.id.snipet)
        TextView snipet;

        @BindView(R.id.para)
        TextView para;

        @BindView(R.id.url)
        TextView url;

        @BindView(R.id.image2)
        ImageView image2;

        public Classholder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
