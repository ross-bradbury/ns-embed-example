package com.example.myexistingapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.tns.JavaScriptImplementation;

@JavaScriptImplementation(javaScriptFile = "./MyCustomNativeScriptActivity.js")
public class MyCustomNativeScriptActivity extends android.app.Activity {
    public MyCustomNativeScriptActivity(){
        com.tns.Runtime.initInstance(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        com.tns.Runtime.callJSMethod(this, "onCreate", void.class, savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        com.tns.Runtime.callJSMethod(this, "onSaveInstanceState", void.class, outState);
    }

    @Override
    protected void onStart() {
        com.tns.Runtime.callJSMethod(this, "onStart", void.class);
    }

    @Override
    protected void onStop() {
        com.tns.Runtime.callJSMethod(this, "onStop", void.class);
    }

    @Override
    protected void onDestroy() {
        com.tns.Runtime.callJSMethod(this, "onDestroy", void.class);
    }

    @Override
    public void onBackPressed() {
        com.tns.Runtime.callJSMethod(this, "onBackPressed", void.class);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        com.tns.Runtime.callJSMethod(this, "onRequestPermissionsResult", void.class, requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        com.tns.Runtime.callJSMethod(this, "onActivityResult", void.class, requestCode, resultCode, data);
    }
}
