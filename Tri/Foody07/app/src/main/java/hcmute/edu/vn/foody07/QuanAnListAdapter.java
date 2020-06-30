package hcmute.edu.vn.foody07;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class QuanAnListAdapter extends BaseAdapter {
    ArrayList<QuanAn> list;
    Context context;

    public QuanAnListAdapter(Context context,ArrayList<QuanAn> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.quan_an_list,null);

        ImageView imgCustom = (ImageView) row.findViewById(R.id.imgCustom);
        TextView txtName = (TextView) row.findViewById(R.id.txtName);
        TextView txtAddress= (TextView) row.findViewById(R.id.txtAddress);
        TextView txtType= (TextView) row.findViewById(R.id.txtType);
        TextView txtDistance=(TextView) row.findViewById(R.id.txtDistance);

        final QuanAn quanAn=list.get(position);
        txtName.setText(quanAn.NameShopFood);
        txtAddress.setText(quanAn.DiaChi);
        txtType.setText(quanAn.TypeShop);
        Bitmap bitmap= BitmapFactory.decodeByteArray(quanAn.Image,0,quanAn.Image.length);
        imgCustom.setImageBitmap(bitmap);
        imgCustom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(context,QuanAnDetailActivity.class);
                intent.putExtra("IdShopFood",quanAn.IdShopFood);
                context.startActivity(intent);
            }
        });
        return row;
    }
}
