package hcmute.edu.vn.foody07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class QuanAnDetailActivity extends AppCompatActivity implements OnMapReadyCallback {
    SQLiteDatabase database;
    final String DATABASE_NAME="foody.sqlite";
    Button btnBack, btnMenu,btnWifi, btnUpdate;
    TextView txtName, txtCity, txtSituation, txtOpen,txtClose, txtAddress, txtDistance, txtType,txtMin,txtMax,txtPass_view;
    ListView listView;
    EditText txtWifiname,txtPass;
    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

    GoogleMap map;
    String ten;
    String diachi;
    String type;
    int min;
    int max;
    String city;
    double latitude;
    double longtitude;

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
        txtPass_view = (TextView) findViewById(R.id.txtPass_view);
        txtSituation=(TextView) findViewById(R.id.txtSituation);

        try {
            initQuanAnDetail();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        initWifiDetail();
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

        MapFragment fragment = (MapFragment) getFragmentManager().findFragmentById(R.id.store_map_id);
        fragment.getMapAsync(this);
    }

    private void initWifiDetail() {
        Intent intent = getIntent();
        final int IdShopFood=intent.getIntExtra("IdShopFood",-1);
        database=Database.initDatabase(this,DATABASE_NAME);
        Cursor cursor=database.rawQuery("SELECT * FROM WIFI WHERE IdShopFood=?",new String[]{IdShopFood+""});
        cursor.moveToFirst();

        String ten=cursor.getString(1);
        String pass=cursor.getString(2);
        btnWifi.setText(ten);
        txtPass_view.setText(pass);
    }

    private void DialogWifi() {
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialog_add_wifi);


        txtWifiname = (EditText) findViewById(R.id.txtWifiname);
        txtPass = (EditText) findViewById(R.id.txtPass);
        btnUpdate=(Button) findViewById(R.id.btnUpdate);
        initWifi();
        dialog.show();
    }

    private void initWifi() {
        Intent intent = getIntent();
        final int IdShopFood=intent.getIntExtra("IdShopFood",-1);
        database=Database.initDatabase(this,DATABASE_NAME);
        Cursor cursor=database.rawQuery("SELECT * FROM WIFI WHERE IdShopFood=?",new String[]{IdShopFood+""});
        cursor.moveToFirst();

        String ten=cursor.getString(1);
        String pass=cursor.getString(2);
        //txtWifiname.setText();
        //txtPass.setText(pass);
    }

    private void initQuanAnDetail() throws ParseException {
        try {
            Intent intent = getIntent();
            final int IdShopFood = intent.getIntExtra("IdShopFood", -1);
            database = Database.initDatabase(this, DATABASE_NAME);
            Cursor cursor = database.rawQuery("SELECT * FROM QUANAN,TINHTHANH WHERE IdShopFood=? AND QUANAN.CodeNumber=TINHTHANH.CodeNumber", new String[]{IdShopFood + ""});
            cursor.moveToFirst();

            ten = cursor.getString(1);
            diachi = cursor.getString(2);
            type = cursor.getString(3);
            min = cursor.getInt(5);
            max = cursor.getInt(6);
            latitude = cursor.getDouble(7);
            longtitude=cursor.getDouble(8);
            double distance = cursor.getDouble(12);
            distance = Math.round(distance * 100) / 100D;
            txtDistance.setText(distance + " km");

            city = cursor.getString(14);
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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        LatLng latLng = new LatLng(latitude,longtitude);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,40));
        map.addMarker(new MarkerOptions().title(ten).snippet(diachi).position(latLng));
    }
}