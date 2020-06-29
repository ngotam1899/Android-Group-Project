package hcmute.edu.vn.foody07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;

public class QuanAnDetailActivity extends AppCompatActivity {
    SQLiteDatabase database;
    final String DATABASE_NAME="foody.sqlite";
    Button btnBack, btnMenu;
    TextView txtName, txtCity, txtSituation, txtOpen,txtClose, txtAddress, txtDistance, txtType,txtMin,txtMax;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_an_detail);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnMenu = (Button) findViewById(R.id.btnMenu);
        txtName = (TextView) findViewById(R.id.txtName);
        txtCity = (TextView) findViewById(R.id.txtCity);
        txtAddress = (TextView) findViewById(R.id.txtAddress);
        txtOpen = (TextView) findViewById(R.id.txtOpen);
        txtClose = (TextView) findViewById(R.id.txtClose);
        txtMin = (TextView) findViewById(R.id.txtMin);
        txtMax = (TextView) findViewById(R.id.txtMax);
        txtDistance = (TextView) findViewById(R.id.txtDistance);
        txtType = (TextView) findViewById(R.id.txtType);

        initQuanAnDetail();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuanAnDetailActivity.this, MainActivity.class));
            }
        });
    }

    private void initQuanAnDetail() {
        Intent intent = getIntent();
        int IdShopFood=intent.getIntExtra("IdShopFood",-1);
        database=Database.initDatabase(this,DATABASE_NAME);
        Cursor cursor=database.rawQuery("SELECT * FROM QUANAN WHERE IdShopFood=?",new String[]{IdShopFood+""});
        cursor.moveToFirst();

        String ten=cursor.getString(1);
        String diachi=cursor.getString(2);
        String type=cursor.getString(3);
        int min=cursor.getInt(5);
        int max=cursor.getInt(6);
        String close=cursor.getString(10);
        String open=cursor.getString(9);
        //cursor.getLocalTime

        txtName.setText(ten);
        txtType.setText(type);
        txtAddress.setText(diachi);
        txtMax.setText(max+"");
        txtMin.setText(min+"");
        txtClose.setText(close);
        txtOpen.setText(open);

    }
}