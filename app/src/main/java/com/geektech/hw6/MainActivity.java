package com.geektech.hw6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.internal.TextWatcherAdapter;

public class MainActivity extends AppCompatActivity {
    private EditText login ;
    private EditText password ;
    private Button btnOk ;
    private TextView text1 ;
    private TextView text2 ;
    private TextView text3 ;
    private TextView text4 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      login = findViewById(R.id.xx) ;
      password = findViewById(R.id.tt);
      btnOk = findViewById(R.id.button);
      text1 = findViewById(R.id.coco);
      text2 = findViewById(R.id.nava);
      text3 = findViewById(R.id.pp);
      text4 = findViewById(R.id.txt_click);
      btnOk.setEnabled(false);
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(login.getText().toString().length() > 0 || password.getText().toString().length() > 0){
                btnOk.setBackgroundResource(R.drawable.bg_buttuon_second);
                btnOk.setEnabled(true);
            } else {
                btnOk.setBackgroundResource(R.drawable.bg_button);
                btnOk.setEnabled(false);
            }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        login.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(login.getText().toString().equals("admin@gmail.com") && password.getText().toString().equals("admin")){
                  login.setVisibility(View.GONE);
                  password.setVisibility(View.GONE);
                  text1.setVisibility(View.GONE);
                  btnOk.setVisibility(View.GONE);
                  text2.setVisibility(View.GONE);
                  text3.setVisibility(View.GONE);
                  text4.setVisibility(View.GONE);
                } else{
                    Toast.makeText(MainActivity.this,"не верный пароль или логин",Toast.LENGTH_LONG).show();
                }
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
               //     while (true) {
                        vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                   // }
                } else {
                    vibrator.vibrate(500);
                }
            }
        });
    }


}
