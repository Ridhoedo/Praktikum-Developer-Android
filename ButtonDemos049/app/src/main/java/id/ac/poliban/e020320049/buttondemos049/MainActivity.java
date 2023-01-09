package id.ac.poliban.e020320049.buttondemos049;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar()!=null)getSupportActionBar().setTitle("Button Demos 049");
        //buat objek dari kelas button yang mereferensi ke view
        //yang kita buat dilayout
        Button btOne = findViewById(R.id.button1);
        Button btTwo = findViewById(R.id.button2);
        Button btThree = findViewById(R.id.button3);
        Button btFour = findViewById(R.id.button04);
        Button btFive = findViewById(R.id.button05);
        //.....

        //pasangi method setOnClick untuk masing masing objek button
        //sehingga ketika mereka diklik akan merespon
        btOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,  "button 1 di klik", Toast.LENGTH_LONG);
            }
        });
        btTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Button 2 di klik", Toast.LENGTH_LONG);
            }
        });
        btThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Button 3 diklik", Toast.LENGTH_LONG);
            }
        });
        btFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Button 4 diklik", Toast.LENGTH_LONG);

            }
        });
        btFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Button 5 diklik", Toast.LENGTH_LONG);
            }
        });


    }
}