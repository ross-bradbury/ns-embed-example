package com.example.myexistingapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setInitialRoute("/welcome");
                show(MyCustomNativeScriptActivity.class);
            }
        }, 500);
    }


    public void showScreen2(View view) {
        showSpinner();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setInitialRoute("/demo");
                show(MyCustomNativeScriptActivity.class);
            }
        }, 500);
    }

    private void setInitialRoute(String initialRoute) {
        // TODO: Isn't there a better way to do this?
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("prefs.db", 0);
        sharedPreferences.edit().putString("initialRoute", initialRoute).apply();
    }

    private <T> void show(Class<T> clazz) {
        Log.i("MainActivity", "Calling initRuntime");
        com.tns.Runtime runtime = com.tns.RuntimeHelper.initRuntime(getApplication());
        if (runtime != null) {
            runtime.enableVerboseLogging();

            Log.i("MainActivity", "Calling run");
            runtime.run();

            android.content.Intent intent = new android.content.Intent(MainActivity.this, clazz);
            intent.setAction(android.content.Intent.ACTION_DEFAULT);
            startActivity(intent);
        }
    }
}
