package hcmute.edu.vn.foody07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final String DATABASE_NAME="foody.sqlite";
    SQLiteDatabase database;
    ContentValues contentValues;
    Button btnCity;
    RecyclerView list_item;
    ArrayList<QuanAn> list;
    QuanAnAdapter anAdapter;

    private static double latitude=0;
    private static double longitude=0;
    private DistanceService distanceService = new DistanceService();
    private String Id_shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        latitude = intent.getDoubleExtra("latitude",0);
        longitude = intent.getDoubleExtra("longitude",0);

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
        contentValues = new ContentValues();

        Cursor cursor=database.rawQuery("SELECT NameShopFood,DiaChi,Image,Latitude,Longitude,IdShopFood,Distance FROM QUANAN",null);
        //xóa dữ liệu cũ
        list.clear();
        for(int i=0;i<cursor.getCount();i++){
            cursor.moveToPosition(i);
            String name=cursor.getString(0);
            String address=cursor.getString(1);
            byte[] img=cursor.getBlob(2);

            double isDistance = cursor.getDouble(6);
            if(isDistance >0 )
            {
                list.add(new QuanAn(name,address,img,isDistance));
            }
            else
            {
                double distance = distanceService.HaversineInKM(latitude,longitude,cursor.getDouble(3),cursor.getDouble(4));
                distance = Math.round(distance*100)/100D;
                contentValues.put("Distance",distance);

                Id_shop = (String) cursor.getString(5);

                Toast.makeText(this,distance+" KM ",Toast.LENGTH_SHORT).show();

                long result =database.update("QUANAN",contentValues,"IdShopFood=?",new String[]{Id_shop});

                list.add(new QuanAn(name,address,img,distance));
            }
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