package com.javieramado.toolbarpreferences;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

public class AccountFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.account_preferences);
    }
}
