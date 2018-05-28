package com.example.jsureda.musiquiz;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;

public class Opciones extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.opciones);
        final SwitchPreference prefSw = (SwitchPreference) findPreference("pref1");
        final CheckBoxPreference prefA = (CheckBoxPreference) findPreference("check_box_preference_1");
        final CheckBoxPreference prefB = (CheckBoxPreference) findPreference("check_box_preference_2");
        final CheckBoxPreference prefC = (CheckBoxPreference) findPreference("check_box_preference_3");
        final CheckBoxPreference prefD = (CheckBoxPreference) findPreference("check_box_preference_4");

        if (prefA.isChecked()) {
            prefA.setEnabled(false);
        }
        if (prefB.isChecked()) {
            prefB.setEnabled(false);
        }
        if (prefC.isChecked()) {
            prefC.setEnabled(false);
        }
        if (prefD.isChecked()) {
            prefD.setEnabled(false);
        }
        prefA.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                if (prefB.isChecked()) {
                    prefB.setChecked(false);
                    prefB.setEnabled(true);
                }
                if (prefA.isChecked()) {
                    prefA.setEnabled(false);
                }
                return true;
            }
        });
        prefB.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                if (prefA.isChecked()) {
                    prefA.setChecked(false);
                    prefA.setEnabled(true);
                }
                if (prefB.isChecked()) {
                    prefB.setEnabled(false);
                }
                return true;
            }
        });
        prefC.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                if (prefD.isChecked()) {
                    prefD.setChecked(false);
                    prefD.setEnabled(true);
                }
                if (prefC.isChecked()) {
                    prefC.setEnabled(false);
                }
                return true;
            }
        });
        prefD.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                if (prefC.isChecked()) {
                    prefC.setChecked(false);
                    prefC.setEnabled(true);
                }
                if (prefD.isChecked()) {
                    prefD.setEnabled(false);
                }
                return true;
            }
        });
    }
}
