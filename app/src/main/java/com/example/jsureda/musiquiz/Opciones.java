package com.example.jsureda.musiquiz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Opciones extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.opciones);


        final Preference prefA = (Preference) findPreference("check_box_preference_1");
        final Preference prefB = (Preference) findPreference("check_box_preference_2");
        final Preference prefC = (Preference) findPreference("check_box_preference_3");
        final Preference prefD = (Preference) findPreference("check_box_preference_4");
        prefA.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                if (prefB.isSelectable()){
                    prefB.setSelectable(false);
                }
                else{
                    prefB.setSelectable(true);
                }
                return true;
            }
        });
        prefB.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                if (prefA.isSelectable()){
                    prefA.setSelectable(false);
                }
                else{
                    prefA.setSelectable(true);
                }
                return true;
            }
        });
        prefC.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
            if (prefD.isSelectable()){
                prefD.setSelectable(false);
            }
            else{
                prefD.setSelectable(true);
            }
            return true;
        }
        });
        prefD.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                if (prefC.isSelectable()){
                    prefC.setSelectable(false);
                }
                else{
                    prefC.setSelectable(true);
                }
                return true;
            }
        });
    }
}
