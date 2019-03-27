package com.jeugene.newslive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.github.jlmd.animatedcircleloadingview.AnimatedCircleLoadingView;

import java.util.ArrayList;

public class News extends AppCompatActivity implements iNavigationControllerCallback {


    String text;

    @BindView(R.id.rec2)
    RecyclerView rec2;

    RecAdapter2 adapt2;

    @BindView(R.id.circle_loading_view)
    AnimatedCircleLoadingView circleload;

    iNavigationController navigationcontroller;
    LinearLayoutManager lm;

    final String vald = "news";
     ArrayList<datalst2.Doc> datalst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);

        circleload.startDeterminate();
        circleload.setPercent(100);


        dataload();



    }


    protected void dataload()
    {

        lm = new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        rec2.setLayoutManager(lm);
        rec2.setHasFixedSize(true);

        navigationcontroller = new HomeAcitivtyController(getApplicationContext(),this,vald);
        navigationcontroller.navigationdrawer();


        circleload.stopOk();



    }

    @Override
    public void NavigationSuccess(ArrayList<datalist.Book> datalist) {


    }

    @Override
    public void NavigatioSuccess2(ArrayList<datalst2.Doc> datalst) {


        this.datalst = datalst;
        adapt2 = new RecAdapter2(datalst);
        rec2.setAdapter(adapt2);


        adapt2.setOnItemClickListener2(new onItemClickListener() {
            @Override
            public void onItemClick1(com.jeugene.newslive.datalist.Book list1) {


            }

            @Override
            public void onItemClick2(datalst2.Doc list2) {

                Intent intent = new Intent(News.this,popscreen.class);
                intent.putExtra("titl",list2.getSnippet());
                intent.putExtra("bod",list2.getLead_paragraph());
                intent.putExtra("imag","https://cdn.pixabay.com/photo/2015/02/05/11/07/news-624859_640.png");
                startActivity(intent);


            }

        });


    }



}

















