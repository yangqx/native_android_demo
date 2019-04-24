package com.example.helloworld2.material;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.helloworld2.R;

public class SnackBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);
    }

    public void sanckBar(View view) {
        //view 就是当前的按钮
        Snackbar.make(view,"我是snackbar",Snackbar.LENGTH_LONG).setAction("点一点", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SnackBarActivity.this,"被点击了",Toast.LENGTH_SHORT).show();
            }
        }).setActionTextColor(Color.GREEN).show();
    }
}
