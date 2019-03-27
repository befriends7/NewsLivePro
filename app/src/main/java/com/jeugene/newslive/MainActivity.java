package com.jeugene.newslive;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;


import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.view.MenuItem;

import android.widget.TextView;
import android.widget.Toast;
import com.github.jlmd.animatedcircleloadingview.AnimatedCircleLoadingView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Objects;


public class MainActivity extends AppCompatActivity implements iNavigationControllerCallback {

    private ArrayList<datalist.Book> datalst;
    RecAdapter adaptkot;
    LinearLayoutManager lm;
    private ActionBarDrawerToggle t;
    Intent intent;

    @BindView(R.id.nav1)
    NavigationView nav1;

    @BindView(R.id.rec1)
    RecyclerView rec1;

    @BindView(R.id.circle_loading_view)
    AnimatedCircleLoadingView circleload;

   @BindView(R.id.drawermain)
    DrawerLayout dl;

   final String vald ="book";

    iNavigationController navigationcontroller;
    String stat="";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



        t = new ActionBarDrawerToggle(this, dl,R.string.open, R.string.close);

        dl.addDrawerListener(t);
        t.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        circleload.startDeterminate();
        circleload.setPercent(100);
        lm = new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        rec1.setLayoutManager(lm);


        nav1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch(id) {
                    case R.id.news: {

                        intent = new Intent(MainActivity.this,News.class);
                        startActivity(intent);
                        break;

                    }

                    case R.id.about: {

                        intent = new Intent(MainActivity.this,About.class);
                        intent.putExtra("titl","Rovero");
                        intent.putExtra("bod","Tech Simplified");
                        intent.putExtra("imag","https://cdn.pixabay.com/photo/2017/03/21/02/00/user-2160923_640.png");
                        startActivity(intent);
                        break;

                    }


                }
                return true;
            }
        });




        intent = getIntent();
        stat = intent.getStringExtra("stat");

        switch (stat)
        {
            case "failed":
            {
                circleload.stopFailure();
            }
            case "success":
            {

                loaddata();
                circleload.stopOk();
            }
        }


        }



    protected void loaddata()
    {



        navigationcontroller = new HomeAcitivtyController(getApplicationContext(),this,vald);
        navigationcontroller.navigationdrawer();

    }

    @Override
    public void NavigationSuccess(ArrayList<datalist.Book> datalist) {

        datalst = new ArrayList<>();

        this.datalst = datalist;
        adaptkot = new RecAdapter(datalst);
        rec1.setAdapter(adaptkot);



        adaptkot.setOnItemClickListener(new onItemClickListener() {
            @Override
            public void onItemClick1(com.jeugene.newslive.datalist.Book list1) {


                intent = new Intent(MainActivity.this,popscreen.class);
                intent.putExtra("titl",list1.getTitle());
                intent.putExtra("bod",list1.getDescription());
                intent.putExtra("imag",list1.getBook_image());

                startActivity(intent);

            }

            @Override
            public void onItemClick2(datalst2.Doc list2) {



            }

        });

    }

    @Override
    public void NavigatioSuccess2(ArrayList<datalst2.Doc> datalst2) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);

    }






}
