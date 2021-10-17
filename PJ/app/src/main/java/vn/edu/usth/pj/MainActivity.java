package vn.edu.usth.pj;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
//831ec66c83c84a2792b943a37e1e3e56
    BottomNavigationView bottomNavigationView;
    FloatingActionButton floatAct;



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnavigationbar);

        bottomNavigationView.setBackground(null);

        bottomNavigationView.getMenu().getItem(2).setEnabled(false);

        getSupportFragmentManager().beginTransaction().replace(R.id.reFrame,new Home()).commit();

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.home :
                        getSupportFragmentManager().beginTransaction().replace(R.id.reFrame,new Home()).commit();
                        break;
                    case R.id.search :
                        getSupportFragmentManager().beginTransaction().replace(R.id.reFrame,new Search()).commit();
                        break;
                    case R.id.saved :
                        getSupportFragmentManager().beginTransaction().replace(R.id.reFrame,new Saved()).commit();
                        break;
                    case R.id.setting :
                         Intent pref = new Intent(getApplicationContext(),SettingsActivity.class);
                         startActivity(pref);
                         break;
                }
                return true;
            }
        });

        floatAct = (FloatingActionButton) findViewById(R.id.person);
        floatAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.reFrame,new Account()).commit();
            }
        });

    }
}