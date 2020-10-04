package ru.kovin.mythirdapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Fragment;

import androidx.annotation.Nullable;

import java.util.Objects;

public class SearchFragment extends Fragment {

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    private void ShowText() {
        Toast.makeText(getActivity(), "Choose one of the services", Toast.LENGTH_LONG).show();
    }

    EditText mText;
    Button mBtn;
    private View.OnClickListener mOnClickButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
            String service = sharedPref.getString(SettingsFragment.SEARCH_KEY, null);
            if (!Objects.equals(service, "null")) {
                Uri address = Uri.parse(service + mText.getText().toString());
                Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
                startActivity(openlinkIntent);

            } else {
                ShowText();
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fr_search, container, false);
        mText = v.findViewById(R.id.et_search_text);
        mBtn = v.findViewById(R.id.btn_search);
        mBtn.setOnClickListener(mOnClickButtonListener);
        return v;
    }

}
