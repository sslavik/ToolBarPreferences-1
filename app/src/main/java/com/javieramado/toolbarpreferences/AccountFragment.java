package com.javieramado.toolbarpreferences;

import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.preference.EditTextPreference;
import androidx.preference.PreferenceFragmentCompat;

public class AccountFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.account_preferences);
        initPreferenceUser();
        initPreferencePassword();
    }

    /**
     * Inicializa la preferencia EditTextPreference User
     */
    private void initPreferenceUser() {
        EditTextPreference edpUser = getPreferenceManager().findPreference(getString(R.string.key_user));
        edpUser.setOnBindEditTextListener(new EditTextPreference.OnBindEditTextListener() {
            @Override
            public void onBindEditText(@NonNull EditText editText) {
                editText.setSingleLine(true); //Que ocupe una línea
                editText.setInputType(InputType.TYPE_CLASS_TEXT); //Que sea de tipo texto
                editText.selectAll(); //Se seleccione al completo. Tiene que estar lo último para que funcione.
            }
        });
    }

    /**
     * Inicializa la preferencia EditTextPreference Password
     */
    private void initPreferencePassword() {
        EditTextPreference edpPassword = getPreferenceManager().findPreference(getString(R.string.key_password));
        edpPassword.setOnBindEditTextListener(new EditTextPreference.OnBindEditTextListener() {
            @Override
            public void onBindEditText(@NonNull EditText editText) {
                editText.setSingleLine(true); //Que ocupe una línea
                //Es necesario poner los dos tipos para que funcione
                editText.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD); //Que sea de tipo texto
                editText.selectAll(); //Se seleccione al completo. Tiene que estar lo último para que funcione.
            }
        });
    }
}
