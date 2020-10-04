package ru.kovin.mythirdapp;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;

public class SettingsFragment extends Fragment {

    public static final String SEARCH_KEY = "SEARCH_KEY";

    RadioGroup radioGroup;
    SharedPreferences sharedPref;

    RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            String searcher = null;
            switch (checkedId) {
                case R.id.radio_google:
                    searcher = "http://google.com/search?q=";
                    break;
                case R.id.radio_yandex:
                    searcher = "http://yandex.ru/search/?lr=2&text=";
                    break;
                case R.id.radio_bing:
                    searcher = "http://bing.com/search?q=";
                    break;
                default:
                    break;
            }
            sharedPref.edit().putString(SEARCH_KEY, searcher).apply();
        }
    };

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fr_settings, container, false);

        radioGroup = v.findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
        sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        return v;
    }
}