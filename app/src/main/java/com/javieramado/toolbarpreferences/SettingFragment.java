package com.javieramado.toolbarpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

public class SettingFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.setting_preferences);
        //Se quiere recoger el evento cuando se modifique el tono
        onSharedPreferenceChanged(PreferenceManager.getDefaultSharedPreferences(getActivity()), getString(R.string.key_ringtone_notification));
        //onSharedPreferenceChanged(PreferenceManager.getDefaultSharedPreferences(getActivity()), getString(R.string.key_password));
    }

    @Override
    public void onResume() {
        super.onResume();
        //Se debe registrar el listener
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        //Se debe de quitar el evento, siempre
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference preference = findPreference(key);
        if (key.equals(getString(R.string.key_ringtone_notification))){
            //DownCasting
            ListPreference listPreference = (ListPreference)preference;
            int prefIndex = listPreference.findIndexOfValue(sharedPreferences.getString(key,""));
            if (prefIndex >= 0)
                preference.setSummary(listPreference.getEntries()[prefIndex]);
            else
                preference.setSummary(sharedPreferences.getString(key, ""));
        }
    }
}
