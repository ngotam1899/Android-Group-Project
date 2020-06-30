package hcmute.edu.vn.foody07;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class QuanAnDetailActivity extends AppCompatActivity {
    SQLiteDatabase database;
    final String DATABASE_NAME="foody.sqlite";
    Button btnBack, btnMenu,btnWifi;
    TextView txtName, txtCity, txtSituation, txtOpen,txtClose, txtAddress, txtDistance, txtType,txtMin,txtMax;
    ListView listView;
    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_an_detail);

        btnWifi = (Button) findViewById(R.id.btnWifi);
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

        try {
            initQuanAnDetail();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuanAnDetailActivity.this, MainActivity.class));
            }
        });
        btnWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogWifi();
            }
        });
    }

    private void DialogWifi() {
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialog_add_wifi);
        dialog.show();

        EditText txtWifiname = (EditText) findViewById(R.id.txtWifiname);
        EditText txtPass = (EditText) findViewById(R.id.txtPass);


    }

    private void initQuanAnDetail() throws ParseException {
        try {
            Intent intent = getIntent();
            final int IdShopFood = intent.getIntExtra("IdShopFood", -1);
            database = Database.initDatabase(this, DATABASE_NAME);
            Cursor cursor = database.rawQuery("SELECT * FROM QUANAN,TINHTHANH WHERE IdShopFood=? AND QUANAN.CodeNumber=TINHTHANH.CodeNumber", new String[]{IdShopFood + ""});
            cursor.moveToFirst();

            String ten = cursor.getString(1);
            String diachi = cursor.getString(2);
            String type = cursor.getString(3);
            int min = cursor.getInt(5);
            int max = cursor.getInt(6);

            double distance = cursor.getDouble(12);
            distance = Math.round(distance * 100) / 100D;
            txtDistance.setText(distance + " km");

            String city = cursor.getString(14);
            //cursor.getLocalTime
            Date open = dateFormat.parse(cursor.getString(9));
            Date current = dateFormat.parse(dateFormat.format(new Date()));
            Date close = dateFormat.parse(cursor.getString(10));
            if (current.after(open) && current.before(close)) {
                txtSituation.setTextColor(Color.GREEN);
                txtSituation.setText("ĐANG MỞ CỬA");
            } else {
                txtSituation.setTextColor(Color.RED);
                txtSituation.setText("CHƯA MỞ CỬA");
            }

            txtName.setText(ten);
            txtType.setText(type);
            txtAddress.setText(diachi);
            txtMax.setText(max + "");
            txtMin.setText(min + "");

            txtClose.setText(close.getHours() + ":" + close.getMinutes() + "0");
            txtOpen.setText(open.getHours() + ":" + open.getMinutes() + "0");

            txtCity.setText(city);

            findViewById(R.id.btnMenu).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(QuanAnDetailActivity.this, MonAnListActivity.class);
                    intent.putExtra("IdShopFood", IdShopFood);
                    startActivity(intent);
                }
            });
        } catch (Exception e){

        }
    }
}