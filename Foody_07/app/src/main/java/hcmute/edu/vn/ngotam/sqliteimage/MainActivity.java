package hcmute.edu.vn.ngotam.sqliteimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnCity;
    //Button btnThem;
    ListView listView;
    ArrayList<Food> foodsList;
    ThingAdapter adapter;
    public static Database database; //public static để class khác gọi đc

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCity=(Button) findViewById(R.id.btnCity);

        //btnThem=(Button) findViewById(R.id.btnThem);
        /*
        listView=(ListView) findViewById(R.id.listView);
        foodsList=new ArrayList<>();

        adapter=new ThingAdapter(this, R.layout.dong_do_vat,foodsList);
        listView.setAdapter(adapter);

        database=new Database(this, "QuanLyFood.sqlite", null,1);
        database.QueryData("CREATE TABLE IF NOT EXISTS DoAn(Id INTEGER PRIMARY KEY AUTOINCREMENT, Ten VARCHAR(150), DiaChi VARCHAR(250), KhoangCach VARCHAR(150), LoaiHinh VARCHAR(250), HinhAnh BLOB)");

        //get Data

        Cursor cursor=database.GetData("SELECT * FROM DoAn");
        while (cursor.moveToNext()){
            foodsList.add(new Food(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getBlob(5)
            ));
        }
        adapter.notifyDataSetChanged();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddThingsActivity.class));
            }
*/
        btnCity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), PlaceActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

    }
}
