package hcmute.edu.vn.foody07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class QuanAnListActivity extends AppCompatActivity {
    SQLiteDatabase database;
    final String DATABASE_NAME="foody.sqlite";
    Button btnCity,btnBack;
    EditText txtSearch;

    ListView listView;
    ArrayList<QuanAn> list;
    QuanAnListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_an_list);

        btnCity=(Button) findViewById(R.id.btnCity);
        btnBack=(Button) findViewById(R.id.btnBack);
        txtSearch=(EditText)findViewById(R.id.txtSearch);

        initCity();
        initQuanAn();
        btnCity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), TinhThanhActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!s.equals("")){
                    search();
                } else {
                    initQuanAn();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void initQuanAn() {
        //ánh xạ
        listView= (ListView) findViewById(R.id.listView);
        list=new ArrayList<>();
        adapter=new QuanAnListAdapter(this,list);
        listView.setAdapter(adapter);
        //đọc data
        Intent intent=getIntent();
        int CodeNumber= intent.getIntExtra("CodeNumber",-1);
        database=Database.initDatabase(this,DATABASE_NAME);
        Cursor cursor=database.rawQuery("SELECT * FROM QUANAN WHERE CodeNumber=?",new String[]{CodeNumber+""});
        list.clear();
        for(int i=0;i<cursor.getCount();i++){
            cursor.moveToPosition(i);
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            String address=cursor.getString(2);
            byte[] img=cursor.getBlob(4);
            String type=cursor.getString(3);
            //thêm dữ lie5u vào list
            list.add(new QuanAn(id,name,address,img,type));
        }
        adapter.notifyDataSetChanged(); //adapter vẽ lại giao diện
    }
    public void search() {

        Cursor cursor = database.rawQuery("SELECT DISTINCT NameShopFood, DiaChi, QUANAN.Image " +
                "FROM MONAN JOIN QUANAN ON MONAN.IdShopFood = QUANAN.IdShopFood " +
                "WHERE NameShopFood LIKE '%" + txtSearch.getText() + "%' OR DiaChi LIKE '%" + txtSearch.getText() + "%' " +
                "OR NameDishes LIKE '%" + txtSearch.getText() + "%'" , null);
        list.clear();
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            String name = cursor.getString(0);
            String address = cursor.getString(1);
            byte[] img = cursor.getBlob(2);
            list.add(new QuanAn(name, address, img));
        }
        adapter.notifyDataSetChanged();
    }
    private void initCity() {
        Intent intent=getIntent();
        int CodeNumber= intent.getIntExtra("CodeNumber",-1);
        database=Database.initDatabase(this,DATABASE_NAME);
        Cursor cursor=database.rawQuery("SELECT * FROM TINHTHANH WHERE CodeNumber=?",new String[]{CodeNumber+""});
        cursor.moveToFirst();
        String ten=cursor.getString(1);
        btnCity.setText(ten);
    }
}