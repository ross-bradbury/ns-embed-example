package com.example.myexistingapplication;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tns.JavaScriptImplementation;

@JavaScriptImplementation(javaScriptFile = "./MyCustomNativeScriptFragment.js")
public class MyCustomNativeScriptFragment extends android.app.Fragment {
    public MyCustomNativeScriptFragment(){
        com.tns.Runtime.initInstance(this);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        com.tns.Runtime.callJSMethod(this, "onHiddenChanged", void.class, new Object[]{hidden});
    }

    @Override
    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        return (Animator)com.tns.Runtime.callJSMethod(this, "onCreateAnimator", Animator.class, transit, enter, nextAnim);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        com.tns.Runtime.callJSMethod(this, "onCreate", void.class, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (View)com.tns.Runtime.callJSMethod(this, "onCreateView", View.class, inflater, container, savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        com.tns.Runtime.callJSMethod(this, "onSaveInstanceState", void.class, outState);
    }

    @Override
    public void onDestroyView() {
        com.tns.Runtime.callJSMethod(this, "onDestroyView", void.class);
    }

    @Override
    public void onDestroy() {
        com.tns.Runtime.callJSMethod(this, "onDestroy", void.class);
    }

    @Override
    public String toString() {
        return (String)com.tns.Runtime.callJSMethod(this, "toString", String.class);
    }
}
