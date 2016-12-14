package com.example.myexistingapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen2(view);
            }
        });
    }

    @Override
    protected void onPause() {
        findViewById(R.id.spinner).setVisibility(View.GONE);
        super.onPause();
    }

    public void showScreen1(View view) {
        findViewById(R.id.spinner).setVisibility(View.VISIBLE);

        show(MyCustomNativeScriptActivity.class);
    }

    public void showScreen2(View view) {
        findViewById(R.id.spinner).setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                show(MyCustomNativeScriptActivity.class);
            }
        }, 1000);
    }

    private <T> void show(Class<T> clazz) {
        com.tns.Runtime runtime = com.tns.RuntimeHelper.initRuntime(getApplication());
        if (runtime != null) {
            runtime.run();

            // TODO: Specify route "/foos/view"

            android.content.Intent intent = new android.content.Intent(MainActivity.this, clazz);
            intent.setAction(android.content.Intent.ACTION_DEFAULT);
            startActivity(intent);
        }
    }
}
