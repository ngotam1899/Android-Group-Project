package hcmute.edu.vn.foody07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class TinhThanhActivity extends AppCompatActivity  {
    final String DATABASE_NAME = "foody.sqlite";
    SQLiteDatabase database;
    private String temp;
    ListView list_item;
    ArrayList<TinhThanh> list;
    TinhThanhAdapter anAdapter;
    Button btnHuy;
    EditText txtSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinh_thanh);
        btnHuy = (Button) findViewById(R.id.btnCancelCity);
        addControls();
        readData();

        txtSearch = (EditText) findViewById(R.id.txtSearch);
        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.equals("")){
                    search();
                } else {
                    readData();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TinhThanhActivity.this, MainActivity.class));
            }
        });

    }

    private void addControls() {
        list_item = (ListView) findViewById(R.id.lvCity);
        list = new ArrayList<>();
        anAdapter = new TinhThanhAdapter(this, list);
        list_item.setAdapter(anAdapter);
    }

    private void readData() {
        database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM TINHTHANH", null);
        //xóa dữ liệu cũ
        list.clear();
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            //thêm dữ lie5u vào list
            list.add(new TinhThanh(id, name));
        }
        anAdapter.notifyDataSetChanged(); //adapter vẽ lại giao diện
    }
    private void search(){
        Cursor cursor = database.rawQuery("SELECT * FROM TINHTHANH WHERE ProvinceName LIKE '%"+ txtSearch.getText() + "%'", null);

        list.clear();
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            list.add(new TinhThanh(id, name));
        }
        anAdapter.notifyDataSetChanged();

    }
 }

