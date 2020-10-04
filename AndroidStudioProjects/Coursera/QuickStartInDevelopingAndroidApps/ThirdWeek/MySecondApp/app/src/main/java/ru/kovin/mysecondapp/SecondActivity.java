package ru.kovin.mysecondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    public static String TEXT_KEY = "TEXT_KEY";

    private TextView mTextView;
    private Button mButton;

    View.OnClickListener mSecondClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Uri address = Uri.parse("http://google.com/search?q=" + mTextView.getText().toString());
            Intent searchIntent = new Intent(Intent.ACTION_VIEW, address);
            startActivity(searchIntent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        mTextView = findViewById(R.id.tv_mirror);
        mButton = findViewById(R.id.btn_second);

        Bundle bundle = getIntent().getExtras();
        mTextView.setText(bundle.getString(TEXT_KEY));

        mButton.setOnClickListener(mSecondClickListener);
    }
}
