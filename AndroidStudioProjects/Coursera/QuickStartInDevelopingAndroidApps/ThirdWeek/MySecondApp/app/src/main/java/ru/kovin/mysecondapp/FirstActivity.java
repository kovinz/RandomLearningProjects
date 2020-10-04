package ru.kovin.mysecondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private EditText mEdit;
    private Button mConfirmButton;

    View.OnClickListener mOnConfirmClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (isTextValid()) {
                showText(mEdit.getText());
            }
            Intent StartSecondIntent = new Intent(FirstActivity.this, SecondActivity.class);
            StartSecondIntent.putExtra(SecondActivity.TEXT_KEY, mEdit.getText().toString());
            startActivity(StartSecondIntent);
        }
    };

    private boolean isTextValid(){
        return !TextUtils.isEmpty(mEdit.getText());
    }

    private void showText(Editable string)
    { Toast.makeText(this, string, Toast.LENGTH_LONG).show(); }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        mEdit = findViewById(R.id.et_random_text);
        mConfirmButton = findViewById(R.id.btn_confirm);

        mConfirmButton.setOnClickListener(mOnConfirmClickListener);
    }
}
