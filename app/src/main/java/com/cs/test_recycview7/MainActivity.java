package com.cs.test_recycview7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 单选
     * @param view
     */
    public void single(View view){
        startActivity(new Intent(this, SingleActivity.class));
    }

    /**
     * 多选
     * @param view
     */
    public void multi(View view){
        startActivity(new Intent(this, MultiActivity.class));
    }


    public void result(View view){

    }
}
