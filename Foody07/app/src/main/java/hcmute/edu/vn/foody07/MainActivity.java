package hcmute.edu.vn.foody07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final String DATABASE_NAME="foody.sqlite";
    SQLiteDatabase database;
    Button btnCity;
    RecyclerView list_item;
    ArrayList<QuanAn> list;
    QuanAnAdapter anAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        readData();

        btnCity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), TinhThanhActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }

    private void readData() {
        database=Database.initDatabase(this,DATABASE_NAME);
        Cursor cursor=database.rawQuery("SELECT NameShopFood,DiaChi,Image FROM QUANAN",null);
        //xóa dữ liệu cũ
        list.clear();
        for(int i=0;i<cursor.getCount();i++){
            cursor.moveToPosition(i);
            String name=cursor.getString(0);
            String address=cursor.getString(1);
            byte[] img=cursor.getBlob(2);
            //thêm dữ lie5u vào list
            list.add(new QuanAn(name,address,img));
        }
        anAdapter.notifyDataSetChanged(); //adapter vẽ lại giao diện
    }

    private void addControls() {
        btnCity=(Button) findViewById(R.id.btnCity);
        list_item=(RecyclerView) findViewById(R.id.recyclerView);
        list=new ArrayList<>();
        anAdapter=new QuanAnAdapter(this,list);
        list_item.setLayoutManager(new GridLayoutManager(this,2));
        list_item.setAdapter(anAdapter);
    }
}