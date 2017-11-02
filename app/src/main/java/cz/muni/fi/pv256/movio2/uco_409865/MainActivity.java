package cz.muni.fi.pv256.movio2.uco_409865;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnChangeTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(this);
        String themeName = pref.getString("prefPrevTheme", "defaultTheme");
        if(themeName.equals("AppTheme")) {
            setTheme(R.style.SecAppTheme);
            pref.edit().putString("prefPrevTheme", "SecAppTheme").commit();
        } else {
            setTheme(R.style.AppTheme);
            pref.edit().putString("prefPrevTheme", "AppTheme").commit();
        }

        setContentView(R.layout.activity_main);

        btnChangeTheme = (Button) findViewById(R.id.btnChangeTheme);
        btnChangeTheme.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent refresh = new Intent(MainActivity.this, MainActivity.class);
                startActivity(refresh);
                finish();
            }
        });
    }
}
