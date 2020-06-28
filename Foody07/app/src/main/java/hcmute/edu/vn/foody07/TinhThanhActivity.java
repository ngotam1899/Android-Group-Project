package hcmute.edu.vn.foody07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class TinhThanhActivity extends AppCompatActivity {
    final String DATABASE_NAME="foody.sqlite";
    SQLiteDatabase database;

    ListView list_item;
    ArrayList<TinhThanh> list;
    TinhThanhAdapter anAdapter;
    Button btnHuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinh_thanh);
        btnHuy = (Button) findViewById(R.id.btnCancelCity);
        addControls();
        readData();

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TinhThanhActivity.this, MainActivity.class));
            }
        });
    }

    private void addControls() {
        list_item=(ListView) findViewById(R.id.lvCity);
        list=new ArrayList<>();
        anAdapter=new TinhThanhAdapter(this,list);
        list_item.setAdapter(anAdapter);
    }

    private void readData() {
        database=Database.initDatabase(this,DATABASE_NAME);
        Cursor cursor=database.rawQuery("SELECT * FROM TINHTHANH",null);
        //xóa dữ liệu cũ
        list.clear();
        for(int i=0;i<cursor.getCount();i++){
            cursor.moveToPosition(i);
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            //thêm dữ lie5u vào list
            list.add(new TinhThanh(id, name));
        }
        anAdapter.notifyDataSetChanged(); //adapter vẽ lại giao diện
    }

}