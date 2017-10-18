package com.example.johan.laboratory6b;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    private Button btnDisco;
    private TextView tv1;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init()
    {
        btnDisco = (Button) findViewById(R.id.btnDisco);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
//        final Colorize colorize = new Colorize();
        btnDisco.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new Colorize().start();
            }
        });
    }

    public void disco1(int color)
    {
        tv1.setBackgroundColor(color);
    }

    public void disco2(int color)
    {
        tv2.setBackgroundColor(color);
    }

    private class Colorize extends Thread
    {
        Random rand = new Random();

        public void run()
        {
            while (true)
            {
                int r = rand.nextInt();
                int g = rand.nextInt();
                int b = rand.nextInt();
                int color = Color.argb(255, r, g, b);
                runOnUiThread(new SetColor(color));
                try
                {
                    Thread.sleep(150);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    private class SetColor implements Runnable
    {
        private int color;

        public SetColor(int color)
        {
            this.color = color;
        }

        public void run()
        {
            disco1(color);
            disco2(color);
        }
    }
}
