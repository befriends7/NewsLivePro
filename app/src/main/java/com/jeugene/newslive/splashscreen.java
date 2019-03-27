package com.jeugene.newslive;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class splashscreen extends AppCompatActivity {

    @BindView(R.id.imagemain)
    ImageView imagemain;
    private final int TIME_DELAY=3000;
    ConnectivityManager cm;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        ButterKnife.bind(this);
        Picasso.get().load(R.drawable.iconmain).fit().into(imagemain);

        cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        if( cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState()== NetworkInfo.State.CONNECTED
                || cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState()== NetworkInfo.State.CONNECTED)

        {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent intent = new Intent(splashscreen.this,MainActivity.class);
                    intent.putExtra("stat","success");
                    startActivity(intent);

                }
            },TIME_DELAY);

        }

        else if(cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState()==NetworkInfo.State.DISCONNECTED ||
                cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState()==NetworkInfo.State.DISCONNECTED)
        {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    alertdial dial = new alertdial();
                    dial.show(getSupportFragmentManager(),"Alert");

                }
            },2000);



        }


    }
}
