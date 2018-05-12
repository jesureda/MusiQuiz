package com.example.jsureda.musiquiz;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;

public class Opciones extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.opciones);

        final CheckBoxPreference prefA = (CheckBoxPreference) findPreference("check_box_preference_1");
        final CheckBoxPreference prefB = (CheckBoxPreference) findPreference("check_box_preference_2");
        final CheckBoxPreference prefC = (CheckBoxPreference) findPreference("check_box_preference_3");
        final CheckBoxPreference prefD = (CheckBoxPreference) findPreference("check_box_preference_4");
        prefA.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                if (prefB.isChecked()){
                    prefB.setChecked(false);
                }
                return true;
            }
        });
        prefB.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                if (prefA.isChecked()){
                    prefA.setChecked(false);
                }
                return true;
            }
        });
        prefC.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                if (prefD.isChecked()){
                    prefD.setChecked(false);
                }
                return true;
        }
        });
        prefD.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                if (prefC.isChecked()){
                    prefC.setChecked(false);
                }
                return true;
            }
        });
    }
}
