package id.ac.poliban.e020320049.listindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.ac.poliban.e020320049.listindemo.model.Flag;

public class InputControlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_control);


        TextView tvValue = findViewById(R.id.tv_value);
        SeekBar seekbar = findViewById(R.id.seekBar);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String value = String.format("%d%%", i);
                tvValue.setText(value);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                tvValue.setText("Started");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button btSubmitCb = findViewById(R.id.bt_submit_cb);
        btSubmitCb.setOnClickListener(this::doInCheckBox);

        Button btSubmitRb = findViewById(R.id.bt_submit_rb);
        btSubmitRb.setOnClickListener(this::doInRadioButton);

        Spinner spinner = findViewById(R.id.spinner);
        List<Flag> mList = new ArrayList<>();
        mList.add(new Flag(R.drawable.argentina,"Argentina"));
        mList.add(new Flag(R.drawable.brazil,"Brazil"));
        mList.add(new Flag(R.drawable.croatia,"Croatia"));
        mList.add(new Flag(R.drawable.france,"France"));
        mList.add(new Flag(R.drawable.japan,"Japan"));
        mList.add(new Flag(R.drawable.marocco,"Marocco"));

        FlagAdapter fa = new FlagAdapter(this,mList);
        spinner.setAdapter(fa);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               Flag flag = (Flag)adapterView.getAdapter().getItem(i);
                Toast.makeText(InputControlActivity.this, flag.getCountryName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void doInRadioButton(View view) {
        int[] rbs = {R.id.rb_prog, R.id.rb_sa, R.id.rb_ui_designer};
        RadioButton[] radioButtons = new RadioButton[rbs.length];
        List<String> result = new ArrayList<>();

        for (int i = 0; i < rbs.length; i++) {
            radioButtons[i] = findViewById(rbs[i]);
            if (radioButtons[i].isChecked())
                result.add(radioButtons[i].getText().toString());

        }
        Toast.makeText(this, result.toString(), Toast.LENGTH_SHORT).show();
    }



    private void doInCheckBox(View view) {
        int[] cbs = {R.id.cb_c, R.id.cb_python, R.id.cb_go, R.id.cb_java};
        CheckBox[] checkBoxes= new CheckBox[cbs.length];
        List<String> result = new ArrayList<>();


        for(int i = 0; i < cbs.length; i++) {
            checkBoxes[i] = findViewById(cbs[i]);
            if(checkBoxes[i].isChecked())
                result.add(checkBoxes[i].getText().toString() );
        }


        Toast.makeText(this, result.toString(), Toast.LENGTH_SHORT).show();
    }
}