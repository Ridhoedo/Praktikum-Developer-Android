package id.ac.poliban.e020320049.listindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.LinkedList;

public class ActivityListView extends AppCompatActivity {
    private LinkedList<String> mList = new LinkedList<>();
    private CountryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


        mList.add("Indonesia");
        mList.add("Brunei Darussalam");
        mList.add("Thailand");
        mList.add("Malaysia");

        //buat object adpater
        adapter = new CountryAdapter(this, mList);

        //buat object List View
        ListView listView = findViewById(R.id.listview);
        //pasang adapter list view
        listView.setAdapter(adapter);

        //tambahkan listener on on item click
        listView.setOnItemClickListener(this::onItemClicked);

        //tambahkan Listener OnItemLongClick
        listView.setOnItemLongClickListener(this::onItemLongClicked);

        //definisikan dan deklarasikan fab_listview
        FloatingActionButton fab = findViewById(R.id.fab_listview);

        //pasang listener Onclick pada
        fab.setOnClickListener(this::addItem);

    }

    private void addItem(View view) {
        //buat object
        View subView = LayoutInflater.from(this)
                .inflate(R.layout.item_input_layout, null, false);

        //object
        EditText etItem = subView .findViewById(R.id.et_item);
        etItem.setHint("Input Nama Negara");
        etItem.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);

        //
        new AlertDialog.Builder(this)
                .setTitle("Add Item")
                .setView(subView)
                .setCancelable(false)
                .setNegativeButton("Batal", null)
                .setPositiveButton("Tambah",(dialogInterface, i) -> {
                    if (!etItem.getText().toString().isEmpty()) {
                        mList.add(etItem.getText().toString());
                        adapter.notifyDataSetChanged();
                    }
                })
                .show();
    }

    private boolean onItemLongClicked(AdapterView<?> adapterView, View view, int i, long l) {
        //method ini kitaa gunakan untuk menghapus item

        //1.tagkap item yang mau dihapus
        String item = adapterView.getAdapter().getItem(i).toString();


        //2.tampilkan alert dialog hapus
        new AlertDialog.Builder(this)
                .setTitle("Hapus Konfirmasi")
                .setMessage(String.format("Hapus %s?", item))
                .setNegativeButton("Batal", null)
                .setPositiveButton("ya", (dialogInterface, which) ->{
                    mList.remove(item);
                    adapter.notifyDataSetChanged();
                } )
                .show();
        return true;
    }

    private void onItemClicked(AdapterView<?> adapterView, View view,int i, long l) {
        String item = adapterView.getAdapter().getItem(i).toString();
        item = String.format("%s telah di klik", item);
        Snackbar.make(view, item, Snackbar.LENGTH_SHORT).show();
    }
}