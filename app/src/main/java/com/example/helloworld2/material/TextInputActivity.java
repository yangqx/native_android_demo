package com.example.helloworld2.material;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.example.helloworld2.R;

public class TextInputActivity extends AppCompatActivity {

    private EditText  et_name;
    private EditText  et_password;
    private TextInputLayout til_name;
    private TextInputLayout til_password;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input);
        initView();

        //校验 输入是否合规则
        et_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //
                String s = charSequence.toString();
                if(s.contains("@")){
                    //显示错误提示
                    til_name.setError("输入的格式不对");
                    //til_name.setHint("输入的格式不对");
                }else{
                    //让错误提示消失
                    til_name.setErrorEnabled(false);
                    //til_name.setHint("username");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void initView() {
        et_name = findViewById(R.id.et_name);
        et_password = findViewById(R.id.et_password);
        til_name = findViewById(R.id.til_name);
        til_password = findViewById(R.id.til_password);

    }


}
