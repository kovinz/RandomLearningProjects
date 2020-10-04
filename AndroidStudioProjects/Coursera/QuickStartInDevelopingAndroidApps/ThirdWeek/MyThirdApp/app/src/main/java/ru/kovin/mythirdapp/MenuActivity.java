package ru.kovin.mythirdapp;

import androidx.fragment.app.Fragment;

public class MenuActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return MenuFragment.newInstance();
    }

}
