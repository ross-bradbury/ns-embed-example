package com.example.myexistingapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private View spinner;

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
        fab.setVisibility(View.GONE);

        spinner = findViewById(R.id.spinner);
    }

    @Override
    protected void onPause() {
        spinner.setVisibility(View.GONE);
        super.onPause();
    }

    private void showSpinner() {
        // TODO: This would need to be improved. It just shows something happened when the buttons are tapped.
        spinner.setVisibility(View.VISIBLE);
    }

    public void showScreen1(View view) {
        showSpinner();

        // TODO: Go to /welcome (currently going to "/" and being redirected)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                show(MyCustomNativeScriptActivity.class);
            }
        }, 500);
    }


    public void showScreen2(View view) {
        showSpinner();

        // TODO: Go to /demo
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                show(MyCustomNativeScriptActivity.class);
            }
        }, 500);
    }

    private <T> void show(Class<T> clazz) {
        com.tns.Runtime runtime = com.tns.RuntimeHelper.initRuntime(getApplication());
        if (runtime != null) {
            runtime.run();

            android.content.Intent intent = new android.content.Intent(MainActivity.this, clazz);
            intent.setAction(android.content.Intent.ACTION_DEFAULT);
            startActivity(intent);
        }
    }
}
