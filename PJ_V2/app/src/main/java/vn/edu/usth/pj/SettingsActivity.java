package vn.edu.usth.pj;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.SwitchPreference;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new SettingsFragment())
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


    public static class SettingsFragment extends PreferenceFragmentCompat {
        private SwitchPreference pref;
        private ListPreference Lpref;

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.preferences, rootKey);
            Load_Setting();
        }

        private void Load_Setting() {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());

            pref = (SwitchPreference) findPreference("Theme");
            pref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    } else {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    }
                    return true;
                }
            });

//            Lpref = (ListPreference) findPreference("Font Size");
//            Lpref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
//                @Override
//                public boolean onPreferenceChange(Preference preference, Object newValue) {
//                    int themeID;
//                    String FontPref = sp.getString("Font Size", "-1");
//                    if (FontPref == "Large"){
//                        themeID = R.style.FontSizeLarge;
//                        setTheme(themeID);
//                    }
//                    return true;
//                }
//            });

        }
    }
}