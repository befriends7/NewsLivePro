package com.jeugene.newslive;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class popscreen extends AppCompatActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.body)
    TextView body;
    @BindView(R.id.imagpop)
    ImageView imagpop;

    Intent intent;
    String titl, bod, imag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popscreen);

        ButterKnife.bind(this);
        intent = getIntent();

        titl = intent.getStringExtra("titl");
        bod = intent.getStringExtra("bod");
        imag = intent.getStringExtra("imag");

        title.setText(titl);
        body.setText(bod);
        Picasso.get().load(imag).fit().into(imagpop);


    }
}
