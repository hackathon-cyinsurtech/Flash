package com.example.neokl.healthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

    }

    public void MoreInfo(View view) {
        Intent Intent = new Intent(view.getContext(), Main4Activity.class);
        view.getContext().startActivity(Intent);


    }





}
