package hcmute.edu.vn.ngotam.sqliteimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class PlaceActivity extends AppCompatActivity {
    private static final String[] items = {"An Giang",
            "Bà Rịa - Vũng Tàu",
            "Bắc Giang",
            "Bắc Kạn",
            "Bạc Liêu",
            "Bắc Ninh",
            "Bến Tre",
            "Bình Định",
            "Bình Dương",
            "Bình Phước",
            "Bình Thuận",
            "Cà Mau",
            "Cao Bằng",
            "Đắk Lắk",
            "Đắk Nông",
            "Điện Biên",
            "Đồng Nai",
            "Đồng Tháp",
            "Gia Lai",
            "Hà Giang"};
    Button btnHuy;
    ListView lvCity;
    ArrayList<String> all_city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        lvCity = (ListView) findViewById(R.id.lvCity);
        btnHuy = (Button) findViewById(R.id.btnCancelCity);
        all_city = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            all_city.add(items[i]);
        }
        ArrayAdapter adapter = new ArrayAdapter(PlaceActivity.this, android.R.layout.simple_list_item_1, all_city);
        lvCity.setAdapter(adapter);

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlaceActivity.this, MainActivity.class));
            }
        });
    }
}
