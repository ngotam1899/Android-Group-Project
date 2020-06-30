package hcmute.edu.vn.foody07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import hcmute.edu.vn.foody07.TabLayouts.FragmentClose;
import hcmute.edu.vn.foody07.TabLayouts.FragmentResult;
import hcmute.edu.vn.foody07.TabLayouts.PageViewAdapter;

public class QuanAnListActivity extends AppCompatActivity {
    SQLiteDatabase database;
    final String DATABASE_NAME="foody.sqlite";
    Button btnCity,btnBack;
    EditText txtSearch;

    ListView listView;
    ArrayList<QuanAn> list;
    QuanAnListAdapter adapter;

    private TabLayout tabLayout;
    private PageViewAdapter viewAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_an_list);

        btnCity=(Button) findViewById(R.id.btnCity);
        btnBack=(Button) findViewById(R.id.btnBack);
        txtSearch=(EditText)findViewById(R.id.txtSearch);

        initCity();
        //initQuanAn();
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

        tabLayout=(TabLayout) findViewById(R.id.tabLayout);
        viewPager=(ViewPager) findViewById(R.id.viewPager);
        viewAdapter=new PageViewAdapter(getSupportFragmentManager());

        //add fragment
        viewAdapter.AddFragment(new FragmentResult(), "Đúng nhất");
        viewAdapter.AddFragment(new FragmentClose(),"Gần tôi");

        viewPager.setAdapter(viewAdapter);
        tabLayout.setupWithViewPager(viewPager);

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
            double distance = cursor.getDouble(12);
            distance = Math.round(distance*100)/100D;
            //thêm dữ lie5u vào list
            list.add(new QuanAn(id,name,address,img,type,distance));
        }
        adapter.notifyDataSetChanged(); //adapter vẽ lại giao diện
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