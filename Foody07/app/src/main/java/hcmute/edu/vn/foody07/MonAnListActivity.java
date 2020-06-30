package hcmute.edu.vn.foody07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import hcmute.edu.vn.foody07.TabLayouts.FragmentClose;
import hcmute.edu.vn.foody07.TabLayouts.FragmentMenuImage;
import hcmute.edu.vn.foody07.TabLayouts.FragmentMenuList;
import hcmute.edu.vn.foody07.TabLayouts.FragmentResult;
import hcmute.edu.vn.foody07.TabLayouts.MenuViewAdapter;
import hcmute.edu.vn.foody07.TabLayouts.PageViewAdapter;

public class MonAnListActivity extends AppCompatActivity {
    SQLiteDatabase database;
    final String DATABASE_NAME="foody.sqlite";
    TextView txtName;
    Button btnBack;
    private TabLayout tabLayout;
    private MenuViewAdapter viewAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_an_list);

        txtName=(TextView) findViewById(R.id.txtName);
        btnBack=(Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MonAnListActivity.this, MainActivity.class));
            }
        });

        initQuanAn();

        tabLayout=(TabLayout) findViewById(R.id.tabLayout_menu);
        viewPager=(ViewPager) findViewById(R.id.viewPager_menu);
        viewAdapter=new MenuViewAdapter(getSupportFragmentManager());

        //add fragment
        viewAdapter.AddFragment(new FragmentMenuImage(), "Ảnh");
        viewAdapter.AddFragment(new FragmentMenuList(),"Thực đơn");

        viewPager.setAdapter(viewAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initQuanAn() {
        Intent intent=getIntent();
        int IdShopFood= intent.getIntExtra("IdShopFood",-1);
        database=Database.initDatabase(this,DATABASE_NAME);
        Cursor cursor=database.rawQuery("SELECT * FROM QUANAN WHERE IdShopFood=?",new String[]{IdShopFood+""});
        cursor.moveToFirst();
        String ten=cursor.getString(1);
        txtName.setText(ten);
    }
}