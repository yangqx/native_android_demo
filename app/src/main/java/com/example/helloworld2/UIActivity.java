package com.example.helloworld2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld2.fragment.ContainerActivity;
import com.example.helloworld2.gridview.GridViwActivity;
import com.example.helloworld2.jump.AActivity;
import com.example.helloworld2.listview.ListViewActivity;
import com.example.helloworld2.recyclerview.RecyclerViewActivity;
import com.example.helloworld2.util.ProgressActivity;

public class UIActivity extends AppCompatActivity {

    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mEditTex;
    private Button mBtnRadioButton;
    private Button mBtnCkeckBox;
    private Button mBtnImageView;
    private Button mBtnListView;
    private Button mBtnGridView;
    private Button mBtnRecyclerView;
    private Button mBtnWebView;
    private Button mBtnToast;
    private Button mBtnDialog;
    private Button mBtnProgressBar;
    private Button mBtnCcustomDialog;
    private Button mBtnPopupWindow;
    //
    private  Button mBtnLifeCycle;
    private Button mBtnJump;
    private Button mBtnFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        mBtnTextView = findViewById(R.id.btn_textview);
        mBtnButton = findViewById(R.id.btn_button);
        mEditTex =  findViewById(R.id.btn_edittext);
        mBtnRadioButton = findViewById(R.id.btn_radiobutton);
        mBtnCkeckBox = findViewById(R.id.btn_checkbox);
        mBtnImageView = findViewById(R.id.btn_imageView);
        mBtnListView = findViewById(R.id.btn_listView);
        mBtnGridView = findViewById(R.id.btn_gridView);
        mBtnRecyclerView = findViewById(R.id.btn_recyclerView);
        mBtnWebView = findViewById(R.id.btn_webView);
        mBtnToast = findViewById(R.id.btn_toast);
        mBtnDialog = findViewById(R.id.btn_dialog);
        mBtnProgressBar = findViewById(R.id.btn_progressBar);
        mBtnCcustomDialog = findViewById(R.id.btn_customDialog);
        mBtnPopupWindow = findViewById(R.id.btn_popupWindow);
        //
        mBtnLifeCycle = findViewById(R.id.btn_lifecycle);
        mBtnJump = findViewById(R.id.btn_jump);
        mBtnFragment = findViewById(R.id.btn_fragment);


        setListeners();
//
//        mBtnTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //跳转到TextView演示界面
//                Intent intent = new Intent(UIActivity.this,TextViewActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        mBtnButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //跳转到Button演示界面
//                Intent intent = new Intent(UIActivity.this,ButtonActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        mEditTex.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //跳转到EditText演示界面
//                Intent intent = new Intent(UIActivity.this,EditTextActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    private void setListeners(){
        OnClick onClick = new OnClick();
        mBtnTextView.setOnClickListener(onClick);
        mBtnButton.setOnClickListener(onClick);
        mEditTex.setOnClickListener(onClick);
        mBtnRadioButton.setOnClickListener(onClick);
        mBtnCkeckBox.setOnClickListener(onClick);
        mBtnImageView.setOnClickListener(onClick);
        mBtnListView.setOnClickListener(onClick);
        mBtnGridView.setOnClickListener(onClick);
        mBtnRecyclerView.setOnClickListener(onClick);
        mBtnWebView.setOnClickListener(onClick);
        mBtnToast.setOnClickListener(onClick);
        mBtnDialog.setOnClickListener(onClick);
        mBtnProgressBar.setOnClickListener(onClick);
        mBtnCcustomDialog.setOnClickListener(onClick);
        mBtnPopupWindow.setOnClickListener(onClick);
        mBtnJump.setOnClickListener(onClick);

        //
        mBtnLifeCycle.setOnClickListener(onClick);
        mBtnFragment.setOnClickListener(onClick);

    }

    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()){
                //跳转到TextView演示界面
                case R.id.btn_textview:intent = new Intent(UIActivity.this,TextViewActivity.class);
                    break;
                //跳转到Button演示界面
                case R.id.btn_button: intent = new Intent(UIActivity.this,ButtonActivity.class);
                    break;
                //跳转到EditText演示界面
                case R.id.btn_edittext:intent = new Intent(UIActivity.this,EditTextActivity.class);
                    break;
                //跳转到radiobutton演示界面
                case R.id.btn_radiobutton:intent = new Intent(UIActivity.this,RadioButtonActivity.class);
                    break;
                //跳转到checkbox演示界面
                case R.id.btn_checkbox:intent = new Intent(UIActivity.this, CkeckBoxActivity.class);
                    break;
                //跳转到mBtnImageView演示界面
                case R.id.btn_imageView:intent = new Intent(UIActivity.this, ImageViewActivity.class);
                    break;
                //跳转到mBtnListView演示界面
                case R.id.btn_listView:intent = new Intent(UIActivity.this, ListViewActivity.class);
                    break;
                //跳转到mBtnGridView演示界面
                case R.id.btn_gridView:intent = new Intent(UIActivity.this, GridViwActivity.class);
                    break;
                //跳转到mBtnRecyclerView演示界面
                case R.id.btn_recyclerView:intent = new Intent(UIActivity.this, RecyclerViewActivity.class);
                    break;
                //跳转到mBtnWebView演示界面
                case R.id.btn_webView:intent = new Intent(UIActivity.this, WebViewActivity.class);
                    break;
                //跳转到mToast演示界面
                case R.id.btn_toast:intent = new Intent(UIActivity.this, ToastActivity.class);
                    break;
                //跳转到mBtnDialog演示界面
                case R.id.btn_dialog:intent = new Intent(UIActivity.this, DialogActivity.class);
                    break;
                //跳转到mBtnPregressBar演示界面
                case R.id.btn_progressBar:intent = new Intent(UIActivity.this, ProgressActivity.class);
                    break;
                //跳转到mBtnCcustomDialog演示界面
                case R.id.btn_customDialog:intent = new Intent(UIActivity.this, CustomDialogActivity.class);
                    break;
                //跳转到mBtnPopupWindow演示界面
                case R.id.btn_popupWindow:intent = new Intent(UIActivity.this, PopupWindowActivity.class);
                    break;

                //跳转到mBtnLifeCycle演示界面
                case R.id.btn_lifecycle:intent = new Intent(UIActivity.this, LifeCycleActivity.class);
                    break;

                //跳转到mBtnJump演示界面
                case R.id.btn_jump:intent = new Intent(UIActivity.this, AActivity.class);
                    break;

                //跳转到Fragment演示界面
                case R.id.btn_fragment:intent = new Intent(UIActivity.this, ContainerActivity.class);
                    break;


            }
            startActivity(intent);
        }
    }
}
