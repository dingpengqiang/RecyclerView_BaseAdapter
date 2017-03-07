package com.jing.recyclerview_baseadapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.one:
                jumpActivity(OneActivity.class);
                break;
            case R.id.two:
                jumpActivity(TwoActivity.class);
                break;
        }
    }

    private void jumpActivity(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }


}
