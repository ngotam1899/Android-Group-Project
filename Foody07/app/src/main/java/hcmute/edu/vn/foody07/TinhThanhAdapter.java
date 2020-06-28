package hcmute.edu.vn.foody07;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TinhThanhAdapter extends BaseAdapter {
    private Activity context;
    private List<TinhThanh> list;

    public TinhThanhAdapter(Activity context, List<TinhThanh> list) {
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
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.tinh_thanh_items,null);

        TextView txtTinhThanh= (TextView) row.findViewById(R.id.txtTinhThanh);
        Button btnChon=(Button) row.findViewById(R.id.btnChon);

        final TinhThanh tinhThanh=list.get(position);
        txtTinhThanh.setText(tinhThanh.ProvinceName);
        btnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,QuanAnListActivity.class);
                intent.putExtra("CodeNumber",tinhThanh.CodeNumber);
                context.startActivity(intent);
            }
        });
        return row;
    }
}
