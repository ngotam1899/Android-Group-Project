package hcmute.edu.vn.ngotam.sqliteimage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddThingsActivity extends AppCompatActivity {
/*
    Button btnAdd, btnCancel;
    EditText edtTen, edtKhoangCach, edtLoaiHinh,edtDiaChi;
    ImageButton btnCamera, btnUpload;
    ImageView imageView;

    final int REQUEST_CODE_CAMERA=123;
    final int REQUEST_CODE_UPLOAD=456;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_things);

        btnAdd=(Button) findViewById(R.id.btnAdd);
        btnCancel=(Button) findViewById(R.id.btnCancel);
        btnCamera=(ImageButton) findViewById(R.id.btnCamera);
        btnUpload=(ImageButton) findViewById(R.id.btnUpload);
        edtDiaChi=(EditText) findViewById(R.id.edtDiaChi);
        edtKhoangCach=(EditText) findViewById(R.id.edtKhoangCach);
        edtLoaiHinh=(EditText) findViewById(R.id.edtLoaiHinh);
        edtTen=(EditText) findViewById(R.id.edtTen);
        imageView=(ImageView) findViewById(R.id.imageView);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //startActivityForResult(intent, REQUEST_CODE_CAMERA);
                ActivityCompat.requestPermissions(
                        AddThingsActivity.this,
                        new String[]{Manifest.permission.CAMERA},
                        REQUEST_CODE_CAMERA
                );
            }
        });
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(Intent.ACTION_PICK);
                //intent.setType("image/*");
                //startActivityForResult(intent, REQUEST_CODE_UPLOAD);
                ActivityCompat.requestPermissions(
                        AddThingsActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_UPLOAD
                );
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chuyển data của imageView sang byte[]
                BitmapDrawable bitmapDrawable= (BitmapDrawable) imageView.getDrawable(); //chuyển về BitmapDrawable
                Bitmap bitmap=bitmapDrawable.getBitmap();   //chuyển về Bitmap
                ByteArrayOutputStream byteArray=new ByteArrayOutputStream();    //chuyển về mảng byte[]
                bitmap.compress(Bitmap.CompressFormat.PNG, 20, byteArray); //quality (1-100), default =100
                byte[] hinhAnh=byteArray.toByteArray();

                MainActivity.database.INSERT_Food(
                        edtTen.getText().toString().trim(),
                        edtDiaChi.getText().toString().trim(),
                        edtKhoangCach.getText().toString().trim(),
                        edtLoaiHinh.getText().toString().trim(),
                        hinhAnh
                );
                Toast.makeText(AddThingsActivity.this,"Đã thêm", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AddThingsActivity.this, MainActivity.class));
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE_CAMERA:
                if(grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent,REQUEST_CODE_CAMERA);
                }
                else {
                    Toast.makeText(this, "Mở camera không thành công", Toast.LENGTH_SHORT).show();
                }
                break;
            case REQUEST_CODE_UPLOAD:
                if(grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    Intent intent=new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent,REQUEST_CODE_UPLOAD);
                }
                else {
                    Toast.makeText(this, "Mở thư viện ảnh không thành công", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data != null){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }
        if(requestCode == REQUEST_CODE_UPLOAD && resultCode == RESULT_OK && data != null){
            Uri uri=data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }*/
}
