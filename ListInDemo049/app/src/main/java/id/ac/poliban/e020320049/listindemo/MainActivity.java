package id.ac.poliban.e020320049.listindemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar()!=null)getSupportActionBar().setTitle("List In Demo 049");
    }

    //tempelkan main menu ke action bar

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
     //   int nightmode = AppCompatDelegate.getDefaultNightMode();
       // if (nightmode == AppCompatDelegate.MODE_NIGHT_YES){
           // menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
      /*  int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        }
        else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }*/
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        }
        else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
   /*     int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        recreate();*/
       /* return true;*/

        if (item.getItemId() == R.id.night_mode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }

        switch (item.getItemId()){
            case R.id.open_listview:
                startActivity(new Intent(this, ActivityListView.class));
               break;

            case R.id.open_recycle:
                startActivity(new Intent(this, ActivityRecycleView.class));
                break;

            case R.id.quit:
                finish();
                break;
            case R.id.open_input_control:
                startActivity(new Intent(this, InputControlActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}